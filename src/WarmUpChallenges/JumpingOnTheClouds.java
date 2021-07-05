package WarmUpChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus.
The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
It is always possible to win the game.
 */

public class JumpingOnTheClouds {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] cTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cTemp[i]);
            c.add(cItem);
        }

        int result = jumpingOnTheClouds(c);
        System.out.println(result);
        bufferedReader.close();
    }

    public static int jumpingOnTheClouds(List<Integer> nums){

        int jump = 0;
        int currentLocation = 0;
        while(currentLocation < nums.size()-1){
            if(currentLocation + 2 < nums.size() && nums.get(currentLocation+2) == 0){
                currentLocation +=2;
            }else{
                currentLocation+=1;
            }
            jump+=1;
        }
        return jump;

    }
    
}
