package DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

Sample Input:
2
abba
abcd

Sample Output:
4
0
 */
public class SherlockAndAnagram {

    public static int sherlockAndAnagrams(String s){
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                int count = 1;
                char[] chars = s.substring(i, j+1).toCharArray();
                Arrays.sort(chars);
                String value = new String(chars);
                if(map.containsKey(value)){
                    count++;
                    map.put(value, count);
                }
                map.put(value, count);
            }
        }

        int pairs = 0;
        for(Map.Entry<String, Integer> mp: map.entrySet()){
            int currentCount = mp.getValue();
            pairs += (currentCount *(currentCount-1))/2;
        }
        return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = sherlockAndAnagrams(s);

        }

        bufferedReader.close();
    }

}
