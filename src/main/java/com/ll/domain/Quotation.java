package com.ll.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor // 모든 필드를 입력 받는 생성자일시 사용
public class Quotation {
    @Getter
    private int id;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private String authorName;
}
