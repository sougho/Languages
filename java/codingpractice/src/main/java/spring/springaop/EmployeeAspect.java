package spring.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * Before Aspect Example
 */
@Aspect
public class EmployeeAspect {

	@Before("execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getName()");
	}
	
	@Before("execution(* spring.springaop.EmployeeService.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
}
