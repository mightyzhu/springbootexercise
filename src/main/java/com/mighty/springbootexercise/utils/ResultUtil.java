package com.mighty.springbootexercise.utils;

import com.mighty.springbootexercise.entity.Result;

public class ResultUtil {

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
