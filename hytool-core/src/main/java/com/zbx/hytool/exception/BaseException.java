package com.zbx.hytool.exception;

public class BaseException extends RuntimeException{

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable b) {
        super(b);
    }

    public BaseException(String msg, Throwable b) {
        super(msg, b);
    }
}
