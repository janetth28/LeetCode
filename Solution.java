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

        Map<String, Integer> substrings = new HashMap<>();
        String subs = null;
        //finding all the substrings
        for (int i=0; i< s.length(); i++){

            for(int j=i+1; j<=s.length(); j++){

                subs = s.substring(i, j);
                if(substrings.containsKey(subs)){
                    substrings.put(subs, substrings.get(subs)+1);
                }
                else{
                    substrings.put(subs, 1);
                }

            }

        }


        int count = 0;
        for(String str : substrings.keySet()){

            if(validSubstring(str)){
                count += substrings.get(str);
            }

        }

        return count;

    }

    public static void main(String[] args){

        String s = "00110011";
        Solution solution = new Solution();

        System.out.println(solution.countBinarySubstrings(s));
    }


    public  boolean validSubstring(String str){
        //base case
        if(str.length() % 2 != 0)
            return false;

        int half = str.length() /2 ;
        String str1 = str.substring(0, half);
        String str2 = str.substring(half);

        return sameAmount(str1, str2);

    }

    public boolean sameAmount(String str1, String str2){
        String x = String.valueOf(str1.charAt(0));
        String y = String.valueOf(str2.charAt(0));
        //lenghts are not the same or 1 substring contains something from the other.
        if(str1.length() != str2.length() || str1.contains(y) || str2.contains(x))
            return false;
        else
            return true;
    }
}
