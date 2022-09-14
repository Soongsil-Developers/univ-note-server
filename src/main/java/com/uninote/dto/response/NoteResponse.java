package com.uninote.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NoteResponse {

    private final Long id;
    private final String title;
    private final String content;

    @Builder
    public NoteResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
