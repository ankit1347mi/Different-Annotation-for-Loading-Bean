package com.tyss.differentconditionalannotaions.dto;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class MyBean {
    private String message;

    public MyBean(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
