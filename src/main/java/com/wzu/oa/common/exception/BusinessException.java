package com.wzu.oa.common.exception;

/**
 * @author jack
 * @date 2018-01-23   20:17
 */
public class BusinessException extends Exception {
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
