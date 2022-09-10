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
    private String content;

    private String mainCategory;
    private String subCategory;

    @Enumerated(value = EnumType.STRING)
    private BookMark bookMark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Note(String title, String content, String mainCategory, String subCategory, BookMark bookMark, Member member) {
        this.title = title;
        this.content = content;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.bookMark = bookMark;
        this.member = member;
    }

    public NoteEditor.NoteEditorBuilder toEditor() {
        return NoteEditor.builder()
                .title(title)
                .content(content);
    }

    public void edit(NoteEditor noteEditor) {
        title = noteEditor.getTitle();
        content = noteEditor.getContent();
    }
}
