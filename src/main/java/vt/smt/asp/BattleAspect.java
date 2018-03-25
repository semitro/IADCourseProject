package vt.smt.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by semitro on 25.03.18.
 */
@Aspect
@Component
public class BattleAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Before("execution(public ActionResult step(String, GAMERS))")
//    public void getStepAdvice(){
//        System.out.println("Совершается очередной ход");
//    }
    @Before("execution(public String getName())")
    public void getNameAdvice(){
        System.out.println("Executing Advice on getName()");
    }

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* vt.smt.controllers.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }

    @Before("execution(* vt.smt.db.repositories.*.*(..))")
    public void beforeRepo(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }

    @Pointcut("execution(* getName(..))")// the pointcut expression
    public void anyGetName() {
    }// the pointcut signature
    @After("anyGetName()")
    public void afterGetName(){
        System.out.println("УРАА!!\nАспекты работают!");
    }
}
