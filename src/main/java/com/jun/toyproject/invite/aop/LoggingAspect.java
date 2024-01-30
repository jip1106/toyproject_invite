package com.jun.toyproject.invite.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component    -> 순서를 보장하기 위해 별도의 클래스로 분리해서 분리한 클래스에 @Aspect, @Component를 사용
//@Aspect
@Slf4j
public class LoggingAspect {

    /**
     * @Around에 포인트컷 표현식을 직접 넣을수도 있지만, @Pointcut 애노테이션을 사용해서 별도로 분리 할 수도 있다.
     */
    @Pointcut("execution(* com.jun.toyproject.invite.*.*.controller.*.*(..))")
    private void pointcut(){}

    /**
     * @Around 애노테이션의 값인 execution(* com.jun.toyproject.invite.admin.view.main.controller.*.*(..)) = 포인트컷
     * @Around 애노테이션의 메서드인 logExcuteTime = 어드바이스
     *
     * */
   // @Around( "execution(* com.jun.toyproject.invite.admin.view.main.controller.*.*(..))"+
   //         "|| execution(* com.jun.toyproject.invite.user.*.controller.*.*(..))"
   // )
    //@Around에 포인트컷 표현식을 직접 넣을수도 있지만, @Pointcut 애노테이션을 사용해서 별도로 분리 할 수도 있다.
    @Around("pointcut()")
    public Object logExcuteTime(ProceedingJoinPoint joinPoint) throws Throwable{

        LocalDateTime now = LocalDateTime.now();
        String strStTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"));
        log.info("[startTime] {}", strStTime);

        Object proceed = joinPoint.proceed();
        log.info("[joinPoint.getTarget()] {}",joinPoint.getTarget());
        log.info("[joinPoint.getSignature()] {} " , joinPoint.getSignature());
        log.info("[joinPoint.getArgs()] {} " , joinPoint.getArgs());
        log.info("[joinPoint.getKind()] {} " , joinPoint.getKind());
        log.info("[joinPoint.getThis()] {} " , joinPoint.getThis());
        log.info("[joinPoint.getSourceLocation()] {} " , joinPoint.getSourceLocation());
        log.info("[joinPoint.getStaticPart()] {} " , joinPoint.getStaticPart());
        log.info("[joinPoint.getClass()] {} " , joinPoint.getClass());

        LocalDateTime end = LocalDateTime.now();
        String strEndTime = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"));
        log.info("[endTime] {}", strEndTime);

        Duration excuteTime = Duration.between(now, end);
        log.info("[실행시간] {}초 {}나노", excuteTime.getSeconds(), excuteTime.getNano());

        return proceed;
    }

    //어드바이스는 순서를 보장하지 않는다 -> 순서를 지정하고 싶으면 @Aspect 적용단위로 @Order 애노테이션을 적용 해야한다
    //@Order 애노테이션은 어드바이스 단위가 아니라 클래스 단위로 적용할 수 있다.
    //여러 어드바이스가 있으면 순서를 보장받을 수 없기 때문에 애스펙트를 별도의 클래스로 분리 해야한다
    @Component
    @Aspect
    @Order(1)
    public static class LogAspect{
        /*@Pointcut("execution(* com.jun.toyproject.invite.admin.view.main.controller.*.*(..))"+
                "|| execution(* com.jun.toyproject.invite.user.*.controller.*.*(..))")

         */
        @Pointcut("execution(* com.jun.toyproject.invite.*.*.controller.*.*(..))")
        private void logPointcut(){}

        @Around("logPointcut()")
        public Object logExcuteTime(ProceedingJoinPoint joinPoint) throws Throwable{

            LocalDateTime now = LocalDateTime.now();
            String strStTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"));
            log.info("[시작시간] {}", strStTime);

            Object proceed = joinPoint.proceed();
            log.info("[joinPoint.getSignature()] {} " , joinPoint.getSignature());
            //log.info("[joinPoint.getTarget()] {}",joinPoint.getTarget());\
            //log.info("[joinPoint.getArgs()] {} " , joinPoint.getArgs());
            //log.info("[joinPoint.getKind()] {} " , joinPoint.getKind());
            //log.info("[joinPoint.getThis()] {} " , joinPoint.getThis());
            //log.info("[joinPoint.getSourceLocation()] {} " , joinPoint.getSourceLocation());
            //log.info("[joinPoint.getStaticPart()] {} " , joinPoint.getStaticPart());
            //log.info("[joinPoint.getClass()] {} " , joinPoint.getClass());

            LocalDateTime end = LocalDateTime.now();
            String strEndTime = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS"));
            log.info("[종료시간] {}", strEndTime);

            Duration excuteTime = Duration.between(now, end);
            log.info("[실행시간] {}초 {}나노", excuteTime.getSeconds(), excuteTime.getNano());

            return proceed;
        }
    }
}
