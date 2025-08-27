package com.example.controller;

import com.example.dto.UsernameAvailabilityResponse;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/check-username")
    public ResponseEntity<UsernameAvailabilityResponse> checkUsername(@RequestParam String username) {
        boolean isAvailable = memberService.checkUsernameAvailability(username);
        return ResponseEntity.ok(new UsernameAvailabilityResponse(isAvailable));
    }
}