package com.iiseeu.demo.data.remote.api;

/**
 * Author: housong
 * Date: 2016/6/22 10:07
 */
public class HttpApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;

    public HttpApiException(int resultCode) {
        getApiExceptionMessage(resultCode);
    }

    public HttpApiException(String detailMessage) {
        super(detailMessage);
    }

    private static String getApiExceptionMessage(int code) {
        String message;
        switch (code) {
            case USER_NOT_EXIST:
                message = "用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            default:
                message = "未知错误";
        }
        return message;
    }
}
