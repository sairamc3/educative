import java.util.*;
import java.util.stream.*;

public class LongestCommonSubString {

    public static void main (String[] args) {

        String str1 = "0abc321";
        String str2 = "123abcdef";
        String str3 = "";
        String str4 = "";

        System.out.println(str1);
        System.out.println(str2);

        int length = findLongestCommonSubString(str1, str2);

        System.out.println("Result -> " + length);

        int length2 = findLongestCommonSubStringMemoization(str1, str2);

        System.out.println(" Memoization -> " + length2);

        int length3 = tabulation(str1, str2);

        System.out.println("Tabulation approach -> " + length3);
    }

    /**
     * This is brute force approach
     * TimeComplexity: <b>O(2^(m+n))
     * @param str1
     * @param str2
     * @return
     */
    private static int findLongestCommonSubString(String str1, String str2){

        return findLongestCommonSubString(str1, str2, 0,0,0);
    }
    private static int findLongestCommonSubString(String str1, String str2, int i1, int i2, int count){

        // Stop logic for recursive function
        if(i1 == str1.length() || i2 == str2.length()) return count;

        if(str1.charAt(i1) == str2.charAt(i2)) {

            count = findLongestCommonSubString(str1, str2, i1+1, i2+1, count+1);
        }

        int c1 = findLongestCommonSubString(str1, str2, i1, i2+1, 0);
        int c2 = findLongestCommonSubString(str1, str2, i1+1, i2, 0);

        return Math.max(count, Math.max(c1,c2));
    }

    /**
     * <h1>Memoization Approach </h2>
     * Storing the information in the 3 dimenstional array 
     *  1. length of s1
     *  2. length of s2
     *  3. for storing the count, which might be max of s1, s2
     */

     public static int findLongestCommonSubStringMemoization(String str1, String str2){

        int max = Math.max(str1.length(), str2.length());

        int[][][] lookupTable = new int[str1.length()][str2.length()][max];

        for(int i=0; i<str1.length(); i++)
            for(int j=0; j<str2.length(); j++)
                for(int k=0; k<max; k++)
                    lookupTable[i][j][k] = -10;

        return findLongestCommonSubStringMemoization(str1, str2, 0, 0, 0, lookupTable);
     }

    private static int findLongestCommonSubStringMemoization(String str1, String str2, int i1, int i2, int count, int[][][] lookupTable){

        if(i1 == str1.length() || i2 == str2.length()) return count;

        if(lookupTable[i1][i2][count] == -10) {

            int cs = count;
            if(str1.charAt(i1) == str2.charAt(i2)){

                cs = findLongestCommonSubStringMemoization(str1, str2, i1+1, i2+1, count+1, lookupTable);

            }
            int c1 = findLongestCommonSubStringMemoization(str1, str2, i1, i2+1, 0, lookupTable);
            int c2 = findLongestCommonSubStringMemoization(str1, str2, i1+1, i2, 0, lookupTable);

            lookupTable[i1][i2][count] = Math.max(cs, Math.max(c1, c2));
        }
        return lookupTable[i1][i2][count];
    }
    
    public static int tabulation(String str1, String str2){

        int[][] lookupTable = new int[str1.length()+1][str2.length()+1];

        // Making all the elements in the lookup table as 0
        for(int i=0; i<= str1.length(); i++){
            for(int j=0; j<=str2.length(); j++) {
                lookupTable[i][j] = 0;
            }
        }

        int maxCount = 0;
        // start from index 1
        for(int i=1; i<=str1.length(); i++ ){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lookupTable[i][j] = 1 + lookupTable[i-1][j-1];
                }
                maxCount = Math.max(maxCount, lookupTable[i][j]);
            }
        }
        return maxCount;
    }
}