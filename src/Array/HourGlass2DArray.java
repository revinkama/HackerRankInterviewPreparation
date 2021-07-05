package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Given a 6x6 2D Array, arr:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

An hourglass in A is a subset of values with indices falling in this pattern in arr's graphical representation:
a b c
  d
e f g

There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum. The array will always be 6x6.

Example:
arr =
-9 -9 -9  1 1 1
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0

The 16 hourglass sums are:
-63, -34, -9, 12,
-10,   0, 28, 23,
-27, -11, -2, 10,
  9,  17, 25, 18

The highest hourglass sum is 28 from the hourglass beginning at row 1, column 2:
0 4 3
  1
8 6 6

Hence 28 would be printed/returned as highest sum
 */

public class HourGlass2DArray {

    public static int hourGlassSum(List<List<Integer>> arr){
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<arr.size()-2; i++){
            for(int j=0; j<arr.size()-2;j++){
                int sum = ((arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)) +
                        (arr.get(i+1).get(j+1)) +
                        (arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2)));
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        int result = hourGlassSum(arr);
        System.out.println(result);
        bufferedReader.close();
    }

}
