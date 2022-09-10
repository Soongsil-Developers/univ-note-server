package com.uninote.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class NoteCreate {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "제목을 입력해주세요.")
    private String content;

    private String mainCategory;
    private String subCategory;

    @Builder
    public NoteCreate(String title, String content, String mainCategory, String subCategory) {
        this.title = title;
        this.content = content;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
    }
}
