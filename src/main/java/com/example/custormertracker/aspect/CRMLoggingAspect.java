package com.example.custormertracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // set logger
    private Logger mylogger = Logger.getLogger(getClass().getName());

    // set pointcut declarations
    @Pointcut("execution(* com.example.custormertracker.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.example.custormertracker.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.example.custormertracker.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void forAppFlow() {
    }


    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint ){

        //call the methods that are passed there
        String methods = joinPoint.getSignature().toShortString();
       mylogger.info("\n======>>>in @before: calling method: "+methods);

       // display the arguments that a being passing to the methods

        // get the arguments
        Object[] args = joinPoint.getArgs();
        //display the arguments
        for (Object o : args) {
            mylogger.info("======>>> Arguments:  "+o);
        }

    }





    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint,Object theResult){

        // display the method we are returning from
        String methods = theJoinPoint.getSignature().toShortString();
        mylogger.info("\n======>>>in @before: calling method: "+methods);


        // display the data returned

        mylogger.info("====>> Result: "+theResult);

    }






}
