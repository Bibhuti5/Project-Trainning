package com.cg.school.advice;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
public class ExecutionTimeTrackerAdvice {

    @Around("@annotation(com.cg.school.advice.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long endTime=System.currentTimeMillis();
        log.info("Method name"+pjp.getSignature()+" time taken to execute : "+(endTime-startTime)+"ms");
        return obj;
    }

}
