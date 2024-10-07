package springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAspect {
   
   @Pointcut("execution(* springaop.service..*Impl.*(..))")
   public void methodPointcut() {   
   }
   
   
   @Before("methodPointcut()")
   public void before() {
      System.out.println("(@Before)비지니스 메소드 수행 전 실행!");
   }
   
   @AfterReturning("methodPointcut()")
   public void afterReturning() {
      System.out.println("(@AfterReturning)비지니스 메소드가 정상적으로 반환 후 실행!");
   }
   
   @AfterThrowing("methodPointcut()")
   public void afterThrowing() {
      System.out.println("(@AfterThrowing)비지니스 메소드 수행 중 예외 발생 시 실행!");
   }
   
   @After("methodPointcut()")
   public void after() {
      System.out.println("(@After)비지니스 메소드 수행 후 무조건 실행!");
   }
   
   @Around("methodPointcut()")
   public void around(ProceedingJoinPoint pjp) {
      System.out.println("(@Around)비지니스 메소드 수행 전 실행!");
   try {
      System.out.println("(@Around)비지니스 클래스 명: "+pjp.getTarget().getClass().getName());
      System.out.println("(@Around)비지니스 메소드명: "+ pjp.getSignature().getName());
      Object[]args=pjp.getArgs();
      for(Object obj:args) {
         System.out.println("(@Around)비지니스 메소드 인자" + obj);
      }
      pjp.proceed();//비지니스 메소드 수행
   }catch(Throwable th) {
      th.printStackTrace();
   }
      System.out.println("(@Around)비지니스 메소드 수행 수 실행");
   }
   
   
   
}//class