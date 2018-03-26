package vt.smt.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by semitro on 25.03.18.
 */
@Aspect
@Component
public class GameAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* step(..))")
    public void getStepAdvice(JoinPoint joinPoint){
        logger.info("Step - {} ", joinPoint);
    }

    @Before("execution(* sellItem(..))")
    public void getSellingBeforeAdvice(JoinPoint joinPoint){
        logger.info("Попытка продажи- {} ", joinPoint);
    }

    @After("execution(* sellItem(..))")
    public void getSellingAfteradvice(JoinPoint joinPoint){
        logger.info("Попытка продажи- {} ", joinPoint);
    }


    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
//    @Before("execution(* vt.smt.controllers.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        //Advice
//        logger.info(" Check for user access ");
//        logger.info(" Allowed execution for {}", joinPoint);
//    }

}
