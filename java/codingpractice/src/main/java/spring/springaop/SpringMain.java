package spring.springaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

		// Works on beans created by Spring
		System.out.println(employeeService.getEmployee().getName());

		System.out.println(employeeService.getEmployee().getAnotherName());
		// Does not work on beans not created

		employeeService.getEmployee().setName("Mahabir");

		try {
			employeeService.getEmployee().throwException();
		} catch (Exception e) {

		}

		employeeService.getEmployee().canLaugh();

		EmployeeService empsc = new EmployeeService();
		Employee emp = new Employee();
		emp.setName("Soumen");
		empsc.setEmployee(emp);
		System.out.println(empsc.getEmployee().getName());
		ctx.close();
	}
}
