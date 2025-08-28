package com.example.service;

import com.example.dto.MemberSignUpRequestDto;
import com.example.entity.Member;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Long signUp(MemberSignUpRequestDto requestDto) {
        if (isUsernameExists(requestDto.getUsername())) {
            log.warn("이미 존재하는 아이디로 회원가입 시도: {}", requestDto.getUsername());
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }

        Member member = Member.builder()
                .username(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword())) // 비밀번호 암호화
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .build();

        return memberRepository.save(member).getId();
    }

    public boolean isUsernameExists(String username) {
        // memberRepository를 사용하여 데이터베이스에 해당 username이 존재하는지 확인합니다.
        log.debug("아이디 중복 확인: {}", username);
        return memberRepository.existsByUsername(username);
    }
}