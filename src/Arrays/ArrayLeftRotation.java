package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
A left rotation operation on an array shifts each of the array's elements  unit to the left.
For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array a of n integers and a number,d, perform d left rotations on the array.
Return the updated array to be printed as a single line of space-separated integers.
 */

public class ArrayLeftRotation {

    public static List<Integer> rotateLeft(List<Integer> list, int d){
        List<Integer> newList = new ArrayList<>();

        //starting at d(rotation amount) instead of 0, to add the nums at d and after into the new arraylist
        for(int i=d; i < list.size(); i++){
            newList.add(list.get(i));
        }

        //after starting at d, need to start at 0 to add nums before d into new arraylist
        for(int i=0; i<d; i++){
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        List<Integer> result = rotateLeft(a, d);
        System.out.println(result);
        bufferedReader.close();
    }

}
