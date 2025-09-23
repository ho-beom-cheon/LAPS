package com.example.service;

import com.example.dto.MemberSignUpRequestDto;
import com.example.entity.Member;
import com.example.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 각 테스트 후 DB를 롤백하여 테스트 간 독립성을 보장합니다.
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Commit // 이 테스트는 종료 후 롤백 대신 커밋됩니다.
    @DisplayName("회원가입이 성공적으로 수행되어야 한다.")
    void signUp_success() {
        // given
        MemberSignUpRequestDto requestDto = new MemberSignUpRequestDto();
        requestDto.setUsername("testuser3");
        requestDto.setPassword("password123");
        requestDto.setName("테스트유저");
        requestDto.setEmail("test@example.com");
        requestDto.setPhone("010-1234-5678");

        // when
        Long savedMemberId = memberService.signUp(requestDto);

        // then
        assertThat(savedMemberId).isNotNull();
        Member foundMember = memberRepository.findById(savedMemberId).orElse(null);
        assertThat(foundMember).isNotNull();
        assertThat(foundMember.getUsername()).isEqualTo(requestDto.getUsername());
    }

    @Test
    @DisplayName("이미 존재하는 아이디로 회원가입 시 예외가 발생해야 한다.")
    void signUp_withDuplicateUsername_shouldThrowException() {
        // given
        // 먼저 사용자를 한 명 가입시킵니다.
        memberRepository.saveAndFlush(Member.builder() // save() 대신 saveAndFlush()를 사용하여 DB에 즉시 반영
                .username("testuser4")
                .password("password")
                .name("기존유저")
                .email("test@example.com")
                .phone("010-1111-2222")
                .build());

        MemberSignUpRequestDto duplicateRequestDto = new MemberSignUpRequestDto();
        duplicateRequestDto.setUsername("testuser");
        duplicateRequestDto.setPassword("anotherpassword");
        duplicateRequestDto.setName("다른유저");
        duplicateRequestDto.setEmail("another@example.com");
        duplicateRequestDto.setPhone("010-3333-4444");

        // when & then
        // 같은 아이디로 다시 가입을 시도하면 IllegalStateException이 발생해야 합니다.
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            memberService.signUp(duplicateRequestDto);
        });
        assertThat(exception.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
    }

    @Test
    @DisplayName("사용자 아이디가 존재할 때 true를 반환해야 한다.")
    void isUsernameExists_whenExists_returnsTrue() {
        // given
        String username = "existingUser";
        memberRepository.save(Member.builder()
                .username(username)
                .password("pw")
                .name("existingName")
                .email("existing@example.com")
                .phone("010-5555-6666").build());

        // when
        boolean exists = memberService.isUsernameExists(username);

        // then
        assertThat(exists).isTrue();
    }

    @Test
    @DisplayName("사용자 아이디가 존재하지 않을 때 false를 반환해야 한다.")
    void isUsernameExists_whenNotExists_returnsFalse() {
        // when
        boolean exists = memberService.isUsernameExists("nonExistentUser");

        // then
        assertThat(exists).isFalse();
    }
}