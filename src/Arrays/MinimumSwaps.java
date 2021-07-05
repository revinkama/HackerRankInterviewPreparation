package Arrays;

import java.io.IOException;
import java.util.Scanner;

/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.

Example:
arr = [7, 1, 3, 2, 4, 5, 6]

i   arr                     swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
 */
public class MinimumSwaps {

    public static int minimumSwaps(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != i+1){
                count++;
                int currentValue = arr[i];
                arr[i] = arr[currentValue-1];
                arr[currentValue-1] = currentValue;
                i--;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int res = minimumSwaps(arr);
        scanner.close();
    }

}
