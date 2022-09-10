package com.uninote.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) { this.password = password; }

    @OneToMany(mappedBy = "member")
    private List<Note> note = new ArrayList<>();

    @Builder
    public Member(Long id, String email, String password, String nickname, Authority authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.authority = authority;
    }
}