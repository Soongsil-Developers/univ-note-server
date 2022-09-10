package com.uninote.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Note extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "note_id")
    private Long id;

    private String title;

    @Lob
    private String contents;

    private String mainCategory;
    private String subCategory;

    @Enumerated(value = EnumType.STRING)
    private BookMark bookMark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Note(String title, String contents, String mainCategory, String subCategory, BookMark bookMark, Member member) {
        this.title = title;
        this.contents = contents;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.bookMark = bookMark;
        this.member = member;
    }
}
