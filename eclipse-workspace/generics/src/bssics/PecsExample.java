package bssics;

import java.util.ArrayList;
import java.util.List;

public class PecsExample {
	
	public static void main(String[] args) {
		List <Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		List<? extends Number> nums = lst;
		System.out.println(lst.get(0));
//		nums.add(3.2);
//		nums.add(3);
//		nums.add(new Integer(3));
		
	}

}