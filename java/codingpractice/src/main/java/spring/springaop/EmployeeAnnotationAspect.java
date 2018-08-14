package spring.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAnnotationAspect {

	@Before("@annotation(spring.springaop.Laughable)")
	public void myAdvice(){
		System.out.println("LOOOOOOOOOOOL");
	}
}
