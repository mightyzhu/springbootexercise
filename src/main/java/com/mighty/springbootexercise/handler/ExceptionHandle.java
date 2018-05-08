package com.mighty.springbootexercise.handler;

import com.mighty.springbootexercise.entity.Result;
import com.mighty.springbootexercise.exceptions.UserException;
import com.mighty.springbootexercise.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            return ResultUtil.error(((UserException) e).getCode(), e.getMessage());
        } else {
            logger.error("系统异常{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}
