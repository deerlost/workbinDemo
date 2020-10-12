package com.mushiny.workbin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @ClassName： :
 * @Package
 * @anthor：wyang
 * @date：
 * @版本：V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WMSException.class)
    public Result handleWmsException(WMSException ex) {
        Result result = new Result();
        result.error(ex.getCode(), ex.getMsg());
        return result;
    }

}

