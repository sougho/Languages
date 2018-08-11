package codingpractice;

import java.util.Arrays;

import org.junit.Test;


public class InversionCounter {
	
	 public static class RetType {
         int [] retArr;
         long inversions;
     }
    
    
     public RetType countInvertion(int [] a)  {
                     if (a.length == 0) return null;
         if (a.length == 1) {
             RetType ret = new RetType();
             ret.inversions = 0;
             ret.retArr = a;
             return ret;
         }
        
         RetType retFirst = countInvertion(Arrays.copyOfRange(a, 0, a.length/2));
         RetType retSecond = countInvertion(Arrays.copyOfRange(a, a.length/2, a.length));
         RetType retInversionAcross =  countAndMergeSort(retFirst.retArr, retSecond.retArr);
         RetType retVal = new RetType();
         retVal.inversions = retFirst.inversions + retSecond.inversions + retInversionAcross.inversions;
         retVal.retArr = retInversionAcross.retArr;
         return retVal;
     }

     private RetType countAndMergeSort(int a[], int b[]) {
         int c [] = new int [a.length + b.length]; // Return Array
         int i = 0; // Counter on a
         int j = 0; // Counter on b
         int k = 0; // Counter on c
         int inversionCount = 0; // Inversion counter
        
         while (true) {
             if (i == a.length) {   
                 if (j == b.length) {   
                     break;
                 } else {
                     for (int l = j; l < b.length; l ++) {
                         c[k] = b[l];
                         k++;
                     }
                     break;
                 }
                
             }
             else if (j == b.length) {
                 for (int l = i; l < a.length; l++) {
                     c[k] = a[l];
                     k++;
                 }
                 break;
             }
            
             if (a[i] <= b[j]) {
                 c[k] = a[i];        
                 i++;
             } else {
                 c[k] = b[j];             
                 j++;
                 inversionCount += a.length - i;
             }
             k++;
         }
        
         RetType ret = new RetType();
         ret.inversions = inversionCount;
         ret.retArr = c;
         return ret;
        
     }
    
    
     @Test
     public void testNormal() {
                     int [] testArray = new int [] {500,-10 , 5, 3 , 1, -9, 246, 2};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testNormal1() {
                     int [] testArray = new int [] {1,3,2};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
    
     @Test
     public void testAscSortedEven() {
                     int [] testArray = new int [] {1,2,3,4,5,6};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testDescSortedEven() {
                     int [] testArray = new int [] {6,5,4,3,2,1};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testAscSortedOdd() {
                     int [] testArray = new int [] {1,2,3,4,5,6,7};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testDescSortedOdd() {
                     int [] testArray = new int [] {10,9,8,7,6,5,4,3,2,1};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testSingleton() {
                     int [] testArray = new int [] {1};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Sorted Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void testEmpty() {
                     int [] testArray = new int [] {};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Sorted Array : " + Arrays.toString(invs.retArr));
     }
     @Test
     public void test1() {
                     int [] testArray = new int [] {67,2,31,4,9,8,5,6,4,1,55};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Sorted Array : " + Arrays.toString(invs.retArr));
     }
    
     @Test
     public void testeq() {
                     int [] testArray = new int [] {1,1,1,1,1};
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
                     System.out.println("Sorted Array : " + Arrays.toString(invs.retArr));
     }
    
     @Test
     public void bigPerf (){
                     int [] testArray = new int [10000];
                     for (int i = 9999; i>=0; i--) {
                                     testArray[i] = 9999-i;
                     }
                     System.out.println(Arrays.toString(testArray));
                     RetType invs = new InversionCounter().countInvertion(testArray);
                     System.out.println("Total Inversions: " + invs.inversions);
     }


}
