package com.ll.domain;

public class Quotation {
    private int id;
    private String content;
    private String authorName;

    public Quotation(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.authorName = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
