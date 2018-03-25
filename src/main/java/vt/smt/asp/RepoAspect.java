package vt.smt.asp;

import org.aspectj.lang.JoinPoint;
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
public class RepoAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* vt.smt.db.repositories.*.*(..))")
    public void beforeRepo(JoinPoint joinPoint) {
        logger.info(" Repository -  {} with args {}", joinPoint, joinPoint.getArgs());
    }

}
