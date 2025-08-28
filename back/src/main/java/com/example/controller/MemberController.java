package com.example.controller;

import com.example.dto.MemberSignUpRequestDto;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody MemberSignUpRequestDto requestDto) {
        Long memberId = memberService.signUp(requestDto);
        // 생성된 리소스의 URI를 Location 헤더에 담아 201 Created 응답을 반환합니다.
        return ResponseEntity.created(URI.create("/api/members/" + memberId)).build();
    }

    @GetMapping("/check-username")
    public ResponseEntity<Map<String, Boolean>> checkUsername(@RequestParam String username) {
        // isUsernameExists는 아이디가 존재하면 true를 반환합니다.
        // API의 명확성을 위해, '사용 가능 여부(available)'는 존재하지 않을 때 true가 되어야 합니다.
        boolean isAvailable = !memberService.isUsernameExists(username);
        return ResponseEntity.ok(Collections.singletonMap("available", isAvailable)); // 사용 가능하면 {"available": true}
    }
}