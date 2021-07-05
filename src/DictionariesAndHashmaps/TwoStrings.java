package DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
Given two strings, determine if they share a common substring. A substring may be as small as one character.

Example:
s1 = "and"
s2 = "art"

Common substring is 'a', hence "YES" is returned

Example:
s1 = "cat"
s2 = "be"

No common substring, hence "NO" is returned
 */
public class TwoStrings {

    public static String twoStrings(String s1, String s2){

        Map<Character, Integer> mapOne = new HashMap<>();
        Map<Character, Integer> mapTwo = new HashMap<>();

        //adding all the values in S1 into map, by characters
        for(int i=0; i<s1.length(); i++){
            int count = 0;
            if(mapOne.containsKey(s1.charAt(i))){
                count++;
                mapOne.put(s1.charAt(i), count);
            }else mapOne.put(s1.charAt(i), 1);
        }

        //adding all the values in S2 into map, by characters
        for(int i=0; i<s2.length(); i++){
            int count = 0;
            if(mapTwo.containsKey(s2.charAt(i))){
                count++;
                mapTwo.put(s2.charAt(i), count);
            }else mapTwo.put(s2.charAt(i), 1);
        }

        //checking every entry in mapOne, to see if same entry in mapTwo
        for(Map.Entry<Character, Integer> mp: mapOne.entrySet()){
            if(mapTwo.containsKey(mp.getKey())){
                return "YES";
            }
        }

        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = bufferedReader.readLine();

            String s2 = bufferedReader.readLine();

            String result = twoStrings(s1, s2);

        }

        bufferedReader.close();
    }

}
