package com.ai.tide.common.exception;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/12 16:13
 **/
public class TideMQException extends Exception {
    private static final long serialVersionUID = -6452292966949943649L;

    public TideMQException() {
        super();
    }

    public TideMQException(String message) {
        super(message);
    }

    public TideMQException(String message, Throwable cause) {
        super(message, cause);
    }

    public TideMQException(Throwable cause) {
        super(cause);
    }
}
