package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public boolean checkUsernameAvailability(String username) {
        return !"test".equalsIgnoreCase(username);
    }
}