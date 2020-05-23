/*
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of
0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.\


0
00
001
0011
00110
001100
0011001
00110011
0
01
011
0110
01100
011001
0110011
1
11
110
1100
11001
110011
1
10
100
1001
10011
0
00
001
0011
0
01
011
1
11
1

0011
01
1100
10
0011
01

 */
import java.util.*;


public class Solution {
    public int countBinarySubstrings(String s) {

        int startchar = 1;
        int flipchar = 0;
        int matches = 0;
        boolean flip = false;
        char start = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            char current = s.charAt(i);

            if(start == current && flip == false){
                startchar++;
                System.out.println("incrementing startchar" );
            }
            if(start !=current ){
                System.out.println("start not equal to current" );
                if(flip == false)
                    flip = true;
                System.out.println("incrementing flipchar" );
                flipchar++;
                if(flipchar <= startchar){
                    matches++;
                    System.out.println("match found" );
                }

            }
            if(start == current && flip == true){
                System.out.println("resetting ewjfnewfjsd" );
                startchar = flipchar;
                System.out.println("startchar val = " + startchar);
                flipchar = 1;
                matches++;
                start = s.charAt(i-1);
                System.out.println("start val = " + start);
            }



        }

        return matches;
    }

    public static void main(String[] args){

        String s = "10101";
        Solution solution = new Solution();

        System.out.println(solution.countBinarySubstrings(s));
    }


}
