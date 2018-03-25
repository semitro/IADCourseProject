package vt.smt.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by semitro on 25.03.18.
 */
@Aspect
@Component
public class ControllerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(vt.smt.controllers.*.new(..))")
    public void constructor(JoinPoint joinPoint) {
        logger.info(" Controller constructed -  {} ", joinPoint);
    }
}
