package com.rms.risproject.constant;

public enum ErrorCode implements com.rms.common.exception.ErrorCode {
    PARAM_NOTNULL(10001, "参数s%不能为空", "param s% not null"),
    PARAM_ERROR(10001, "参数s%不能为空");

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return LanguageInterceptor.threadLanguage.get() == "zh" ? message : messageEn;
    }

    @Override
    public String getMessageEn() {
        return LanguageInterceptor.threadLanguage.get() == "zh" ? message : messageEn;
    }

    private int code;
    private String message;
    private String messageEn;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(int code, String message, String messageEn) {
        this.code = code;
        this.message = message;
        this.messageEn = messageEn;
    }
}
