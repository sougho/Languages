package codingpractice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OptimalPalindrome {

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

		for (int i = 1; i < s.length(); i++) {
			List<Integer> cl = mem.get(i - 1);
			int begin = cl.get(cl.size() - 2);
			int case1 = 0;
			if ((i > 0) && (s.charAt(i) == s.charAt(i - 1))) {
				case1 = i - cngtsCount.get(i - 1) - 1;
				cngtsCount.set(i, cngtsCount.get(i - 1) + 1);
			} else {
				case1 = i - 1;
			}

			if ((begin > 0) && (s.charAt(begin - 1) == s.charAt(i))) {
				int prevSol = begin - 2;
				int prevCost = 0;
				if (prevSol >= 0) {
					prevCost = mem.get(prevSol).size();
				}
				if (mem.get(case1).size() < prevCost) {
					List<Integer> newList = new ArrayList<Integer>(mem.get(i - 1));
					newList.add(i);
					mem.add(i, newList);
				} else {
					List<Integer> newList = null;
					if (prevSol >= 0)
						newList = new ArrayList<Integer>(mem.get(prevSol));
					else {
						newList = new ArrayList<Integer>();
						newList.add(0);
					}

					newList.add(i + 1);
					mem.add(i, newList);
				}
			} else {
				int cost1 = mem.get(i - 1).size();
				int cost2 = mem.get(case1).size();
				if (cost2 <= cost1) {
					if (case1 == -1) {
						List<Integer> newList = new ArrayList<Integer>();
						newList.add(0);
						newList.add(i + 1);
						mem.add(i, newList);
					} else {
						List<Integer> newList = new ArrayList<Integer>(mem.get(case1));
						newList.add(i + 1);
						mem.add(i, newList);
					}
				} else {
					List<Integer> newList = new ArrayList<Integer>(mem.get(i-1));
					newList.add(i + 1);
					mem.add(i, newList);
				}
			}
		}
		System.out.println("---- SUBPROBLEMS ----");
		for (int i = 0; i < mem.size(); i++) {
			System.out.println(mem.get(i));
		}
		System.out.println("---- SUBPROBLEMS END ----");
		return mem.get(s.length() - 1);
	}

	public static void printSegmentedString(String s, List<Integer> cuts) {
		int currCut = 0;
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
