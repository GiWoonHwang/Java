package com.mysite.sbb.common.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum TypeCode {

    ONE("A"),
    TWO("B"),
    THREE("C"),
    FOUR("D");

    @Getter
    private String code;


}
