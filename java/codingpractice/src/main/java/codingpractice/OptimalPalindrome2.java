package codingpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class OptimalPalindrome2 {

	public List<Integer> computeOptimalPalindrome(String s) {

		List<List<Integer>> mem = new ArrayList<List<Integer>>();
		// First element
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		mem.add(l);
		List<Integer> cngtsCount = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			cngtsCount.add(i, 1);
		}
		// cngtsCount.add(0, 1);
		
		
		//int minSubProblem = s.length() + 1;
		for (int i = 1; i < s.length(); i++) {
			
		}
		
		System.out.println("---- SUBPROBLEMS ----");
		for (int i = 0; i < mem.size(); i++) {
			System.out.println(mem.get(i));
		}
		System.out.println("---- SUBPROBLEMS END ----");
		return mem.get(s.length() - 1);
	}

	public static void printSegmentedString(String s, List<Integer> cuts) {
		//int currCut = 0;
		System.out.print("|");
		for (int i = 0; i < cuts.size(); i++) {
			for (int j = cuts.get(i); j < cuts.get(i + 1) && j < s.length(); j++) {
				System.out.print(s.charAt(j));
			}
			System.out.print("|");
		}

		System.out.println();
	}

	@Test
	public void testSingleton() {
		String s = "a";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void testDbltone() {
		String s = "aa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test10() {
		String s = "aaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test11() {
		String s = "aaaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test3() {
		String s = "aaaaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test4() {
		String s = "xyaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test5() {
		String s = "abcbaaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test6() {
		String s = "ababbbabbababa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test7() {
		String s = "ababbbabbaaaaa";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test8() {
		String s = "aca";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}

	@Test
	public void test9() {
		String s = "bacab";
		List<Integer> cuts = computeOptimalPalindrome(s);
		printSegmentedString(s, cuts);
	}
}
