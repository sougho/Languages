package easy;

public class Levenstein {
	
	public static int distance(String s1, String s2) {
		int rows = s1.length() + 1;
		int cols = s2.length() + 1;
		int [] mem = new int [rows * cols];
		
		for (int i = 0; i < rows; i++)
		{
			set2darray(mem, i, 0, cols, i);
		}
		for (int j = 0; j < cols; j++)
		{
			set2darray(mem, 0, j, cols, j);
		}
		for (int i = 1; i < rows; i++) 
			for (int j = 1; j < cols; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					set2darray(mem, i, j, cols, get2darray(mem, i-1, j-1, cols));
				} else {
					set2darray(mem, i, j, cols, min(
							get2darray(mem, i-1, j-1, cols) + 1,
							get2darray(mem, i, j-1, cols) + 1,
							get2darray(mem, i-1, j, cols) + 1)
							);
				}
			}
		//printArray(mem, rows, cols);
		return get2darray(mem, rows-1, cols-1, cols);
	}
	private static void printArray(int [] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i * n + j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int min(int i, int j, int k) {
		if (i <= j) {
			if (i <= k) return i;
			else return k;
		} else {
			if ( j <= k) return j;
			else return k;
		}
	}
	
	private static void set2darray(int [] arr, int row, int col, int maxcol, int val) {
		arr[row * maxcol + col] = val;
	}
	
	private static int get2darray(int [] arr, int row, int col, int maxcol) {
		return arr[row * maxcol + col];
	}
	
	public static void main(String[] args) {
		System.out.println(distance("Soumen", "xxxx"));
	}

}
