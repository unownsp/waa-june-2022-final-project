package alumnimanagement.aspect;

import alumnimanagement.dto.ExecutionLogDTO;
import alumnimanagement.services.ExecutionLogService;
import alumnimanagement.utility.Helper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@RequiredArgsConstructor
public class AllLogAspect {
    private final ExecutionLogService executionLogService;
    private final Helper helper;
    @Pointcut("within(alumnimanagement.services.impl..*)")
    public void headerChecker() {
    }

    @Before("headerChecker()")
    public void execute(JoinPoint joinPoint) throws Throwable {

        executionLogService.createLog(new ExecutionLogDTO(Helper.getCurrentDate(),
                joinPoint.getSignature().getName(),
                helper.getLoggedUserId(), helper.getLoggedUserId(), joinPoint.getThis().toString(), "All Log"));
    }
}
