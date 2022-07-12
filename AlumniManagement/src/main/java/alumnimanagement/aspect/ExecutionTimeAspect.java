package alumnimanagement.aspect;

import alumnimanagement.dto.ExecutionLogDTO;
import alumnimanagement.services.ExecutionLogService;
import alumnimanagement.utility.Helper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ExecutionLogService executionLogService;
private final Helper helper;

    @Pointcut("@annotation(alumnimanagement.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns:" + (finish - start));
        executionLogService.createLog(new ExecutionLogDTO(Helper.getCurrentDate(),
                proceedingJoinPoint.getSignature().getName(),
                (finish - start), helper.getLoggedUserId(), proceedingJoinPoint.getThis().toString(),"Execution Time"));
        return result;
    }
}
