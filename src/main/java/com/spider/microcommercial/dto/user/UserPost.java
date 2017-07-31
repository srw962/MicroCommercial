package com.spider.microcommercial.dto.user;

import java.time.LocalDateTime;

public class UserPost {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime creationDate;

    public UserPost() {
    }

    public UserPost(Long id, String title, String content, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
