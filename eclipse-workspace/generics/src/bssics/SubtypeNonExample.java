package bssics;

import java.util.ArrayList;
import java.util.List;

public class SubtypeNonExample {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		//List<Number> nums = ints;
		//nums.add(3.4322); // oops!!
	}
}
