package functional.function;

import java.util.function.Function;

public class FunctionalRecursive {
	
	//int i = i + 5;
	int i;
	{ 
		i = i + 5;
	}
	
	public void f() {
		System.out.println(i);
	}
	
	// Function member function
	
	// Non Final
	
	public Function<Integer,Integer> factMember1;
	{
	  factMember1 = x -> x<=1? 1 : x*factMember1.apply(x-1);
	}
	
	// Final
	public final Function<Integer,Integer> factMember2 = x -> x<=1? 1 : x*this.factMember2.apply(x-1);
	
	// Static method
	// non final 
	
	public static Function<Integer,Integer> factStatic1;
	static
	{
		factStatic1 = x -> x<=1? 1 : x*factStatic1.apply(x-1);
	}
	
	// final
	public static final Function<Integer,Integer> factStatic2 = x -> x<=1? 1 : x*FunctionalRecursive.factStatic2.apply(x-1);
	
	public static void main(String[] args) {
		new FunctionalRecursive().f();
		System.out.println(factStatic2.apply(4));
	}

}
