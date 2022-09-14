package com.uninote.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class NoteEdit {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @Builder
    public NoteEdit(String title, String content) {
        this.title = title;
        this.content = content;
    }
}