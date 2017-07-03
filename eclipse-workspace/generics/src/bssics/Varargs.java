package bssics;

import java.util.ArrayList;
import java.util.List;

public class Varargs {
	
	public static <T> List<T> toList(T ... elts) {
		
		List<T> retLst = new ArrayList<T>();
		for (T elt : elts) {
			retLst.add(elt);
		}
		return retLst;
	}
	
	public static void main(String[] args) {
		List<Integer> ints = toList(1,2,3);
		System.out.println(ints);
		List<String> strs = toList("1", "2", "3");
		System.out.println(strs);
		ints = toList(new Integer[]{1,2});
		System.out.println(ints);
		List<List<Integer>> mylist = toList(new ArrayList<Integer>());
		ints = toList(); // Eclipse compiles, but sun java compiler warns 
		// THat type inference is not possible
		ints = Varargs.<Integer>toList(); // Explicit qualification of template 
		// corrects above problem
		List<Object> objs = toList(1, "2"); // Wrong
		objs = Varargs.<Object>toList(1,"2");//Right
		
	}

}
