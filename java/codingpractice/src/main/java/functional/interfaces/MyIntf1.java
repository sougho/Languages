package functional.interfaces;

import java.util.function.Function;

public interface MyIntf1 {
	
	default public void fn () {}
	
	public static interface MyFunc extends Function<Integer, Integer> {};
	public static void main(String[] args) {
	}

}
