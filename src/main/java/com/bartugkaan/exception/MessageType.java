package com.bartugkaan.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXIST("1004", "No record exist"),
    GENERAL_EXCEPTION("1000", "General Error Occurred");


    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
