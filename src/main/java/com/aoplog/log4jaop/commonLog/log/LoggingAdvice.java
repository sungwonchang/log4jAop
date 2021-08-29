package com.aoplog.log4jaop.commonLog.log;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAdvice {

    @Before("execution(* com.aoplog.log4jaop.Service.*.*(..)) || "
            + "execution(* com.aoplog.log4jaop.Repository.*.*(..))")
    public void startLog(JoinPoint joinpoint){
        log.info("Before Start : -----------------------------------------");
        /*전달되는 파라미터들을 Object의 배열로 받아옴*/
        log.info("Before 1 전체 인자: " + Arrays.toString(joinpoint.getArgs()));
        //해당 Advice의 타입을 알아냄
        log.info("Before 2 Advice Type : " + joinpoint.getKind());
        //실행하는 대상 객체의 메소드에 대한 정보를 아아낼 때 사용합니다
        log.info("Before 3 메소드정보 : " + joinpoint.getSignature().getName());
        //target객체를 알아낼 때 사용합니다.
        log.info("Before 4 target : " + joinpoint.getTarget());
        //advice를 행하는 객체를 알아낼 때 사용합니다.
        log.info("Before 5 advicethis : " + joinpoint.getThis().toString());


        log.info("Before End   : -----------------------------------------");
    }


    @After("execution(* com.aoplog.log4jaop.Service.*.*(..)) || "
            + "execution(* com.aoplog.log4jaop.Repository.*.*(..))")
    public void aftertLog(JoinPoint joinpoint){
        log.info("After Start : -----------------------------------------");
        /*전달되는 파라미터들을 Object의 배열로 받아옴*/
        log.info("After 1 전체 인자 : " + Arrays.toString(joinpoint.getArgs()));
        //해당 Advice의 타입을 알아냄
        log.info("After 2 Advice Type : " + joinpoint.getKind());
        //실행하는 대상 객체의 메소드에 대한 정보를 아아낼 때 사용합니다
        log.info("After 3 메소드정보 : " + joinpoint.getSignature().getName());
        //target객체를 알아낼 때 사용합니다.
        log.info("After 4 target : " + joinpoint.getTarget());
        //advice를 행하는 객체를 알아낼 때 사용합니다.
        log.info("After 5 advicethis : " + joinpoint.getThis().toString());


        log.info("After End   : -----------------------------------------");
    }

    @Around("execution(* com.aoplog.log4jaop.Service.*.*(..)) || execution(* com.aoplog.log4jaop.Repository.*.*(..))")
    public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Around Start -------------------------------------------------");
        long startTime = System.currentTimeMillis();
        log.info(Arrays.toString(pjp.getArgs()));

        Object result = pjp.proceed();

        long endTime = System.currentTimeMillis();
        log.info("Around Result :" + pjp.getSignature().getName() + " : " + (endTime - startTime));
        log.info("Around End -------------------------------------------------");

        return result;
    }
}
