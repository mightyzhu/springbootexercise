package com.mighty.springbootexercise.aspect;

import com.mighty.springbootexercise.controller.UserController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Before("execution(public * com.mighty.springbootexercise.controller..UserController.userList(..))")
    public void log(JoinPoint joinPoint) {
        logger.info("1111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("url={}", request.getRequestURL());

        // method
        logger.info("method={}", request.getMethod());

        // ip
        logger.info("ip={}", request.getRemoteAddr());

        // class method
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + joinPoint.getSignature().getName());

        // class 参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("execution(public * com.mighty.springbootexercise.controller..UserController.userList(..))")
    public void doAfter() {
        logger.info("222");
    }

    // 定义切点
    @Pointcut("execution(public * com.mighty.springbootexercise.controller..UserController.userList(..))")
    public void doaop() {
        logger.info("333"); // 无用
    }

    @After("doaop()")
    public void doAfter2() {
        logger.info("444");
    }

    @AfterReturning(returning = "object", pointcut = "doaop()")
    public void afterReturning(Object object) {
        logger.info("response={}", object.toString()); // 无用
    }

}
