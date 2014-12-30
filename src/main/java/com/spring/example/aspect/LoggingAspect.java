package com.spring.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 *
 * @author ajay
 */

//@Aspect
//@Component
public class LoggingAspect {

	@Pointcut("within(com.spring.example..*)")
	private void selectAll(){}
	
	@Before("selectAll()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("[ " + joinPoint.getSignature().getDeclaringTypeName() + " ] : " + joinPoint.getSignature().toShortString());
	}
	
	//This mehod is throwing exception
	@Around("selectAll()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try{
        System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
        + " \narguments : " + Arrays.toString(joinPoint.getArgs()));
        joinPoint.proceed(); // continue on the intercepted method
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }

}
