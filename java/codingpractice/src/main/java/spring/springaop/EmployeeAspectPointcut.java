package spring.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointcut {
	
	
	/**
	 * Advices
	 */
	
	@Before("getNamePointCut()")
	public void firstAdvice() {
		System.out.println("First Advice");
	}
	
	@Before("getNamePointCut()")
	public void secondAdvice() {
		System.out.println("Second Advice");
	}
	
	/**
	 * Pointcuts
	 */
	
	@Pointcut("execution(public String getName())")
	public void getNamePointCut() {
		
	}

	@Pointcut("within(spring.springaop.*)")
	public void allMethodsPointcut(){
		
	}
}
