package com.mysite.web;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity // 엔티티라고 명시해 주는 것
public class Question {
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 수 증가
    private Integer id;

    @Column(length = 200)
    private  String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

}
