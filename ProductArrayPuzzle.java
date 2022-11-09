// Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
// such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
// Solve it without division operator in O(n) time.

// Example : 

// Input: arr[]  = {10, 3, 5, 6, 2}
// Output: prod[]  = {180, 600, 360, 300, 900}
// 3 * 5 * 6 * 2 product of other array 
// elements except 10 is 180
// 10 * 5 * 6 * 2 product of other array 
// elements except 3 is 600
// 10 * 3 * 6 * 2 product of other array 
// elements except 5 is 360
// 10 * 3 * 5 * 2 product of other array 
// elements except 6 is 300
// 10 * 3 * 6 * 5 product of other array 
// elements except 2 is 900

// Input: arr[]  = {1, 2, 3, 4, 5}
// Output: prod[]  = {120, 60, 40, 30, 24 }
// 2 * 3 * 4 * 5  product of other array 
// elements except 1 is 120
// 1 * 3 * 4 * 5  product of other array 
// elements except 2 is 60
// 1 * 2 * 4 * 5  product of other array 
// elements except 3 is 40
// 1 * 2 * 3 * 5  product of other array 
// elements except 4 is 30
// 1 * 2 * 3 * 4  product of other array 
// elements except 5 is 24

import java.io.*;

public class ProductArrayPuzzle {

    public static long[] productExceptSelf(int a[], int n) {
        long prod = 1;
        long flag = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                flag++;
            else
                prod *= a[i];
        }

        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            if (flag > 1) {
                arr[i] = 0;
            } else if (flag == 0)
                arr[i] = (prod / a[i]);
            else if (flag == 1 && a[i] != 0) {
                arr[i] = 0;
            } else
                arr[i] = prod;
        }
        return arr;
    }

    public static void main(String args[])
            throws IOException {
        int n = 5;
        int[] array = { 10, 3, 5, 6, 2 };

        ProductArrayPuzzle ob = new ProductArrayPuzzle();
        long[] ans = new long[n];
        ans = ob.productExceptSelf(array, n);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}