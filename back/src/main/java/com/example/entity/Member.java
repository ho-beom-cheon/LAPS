package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @SequenceGenerator(
            name = "MEMBER_SEQ_GENERATOR",
            sequenceName = "MEMBER_SEQ", // 데이터베이스에 생성될 시퀀스 이름
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

}
