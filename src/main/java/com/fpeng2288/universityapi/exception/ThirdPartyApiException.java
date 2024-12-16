package com.fpeng2288.universityapi.exception;

/**
 * ClassName: ThirdPartyApiException
 * Package: com.fpeng2288.universityapi.exception
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/15 1:08
 * @version 1.0
 */
public class ThirdPartyApiException extends RuntimeException{

    public ThirdPartyApiException(String message, Throwable cause){
        super(message, cause);
    }

    public ThirdPartyApiException(String message) {
        super(message);
    }
}
