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

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> Result<?> defultExcepitonHandler(HttpServletRequest request, WMSException e) {
        e.printStackTrace();
        Result result = new Result();
        result.error(e.getCode(), e.getMsg());
        return result;
    }

}

