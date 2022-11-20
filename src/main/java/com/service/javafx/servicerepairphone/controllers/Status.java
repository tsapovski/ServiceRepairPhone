package com.service.javafx.servicerepairphone.controllers;

public enum Status {
    InWORK("W", "В работе"), TRUE("T", "Готово");
    private String code;
    private String text;

    Status(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return (code);
    }

    public String getText() {
        return text;
    }

    public static Status getByCode(String statusCode) {
        for (Status s : Status.values()) {
            if (s.text.equals(statusCode)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
