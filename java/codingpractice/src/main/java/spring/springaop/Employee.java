package spring.springaop;


public class Employee {

	private String name;
	
	public String getName() {
		return name;
	}
	
	public String getAnotherName() {
		System.out.println("get another name");
		return name;
	}

	public void setName(String nm) {
		this.name=nm;
	}
	
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}	
	
	@Laughable
	public void canLaugh() {
		System.out.println("Finished Laughing, now be serious!!!");
	}
}
