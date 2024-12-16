package com.fpeng2288.universityapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.fpeng2288.universityapi.exception
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/15 1:23
 * @version 1.0
 */
public class GlobalExceptionHandler {

    @ExceptionHandler(ThirdPartyApiException.class)
    public ResponseEntity<String> handleThirdPartyApiException(ThirdPartyApiException ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error: " + ex.getMessage());
    }

}
