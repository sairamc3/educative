import java.util.*;
import java.util.stream.*;

/**
 * This isn't the right approach
 * I did not understand the problem right. But the code is doing what I have expected it to do.
 * So need to rework on why the problem is different, with pleasent mind
 */
public class ShortCommonSuperSeq {

    public static void main(String[] args) {
        
        String s1 = "abcdz";
        String s2 = "bdcf";

        System.out.println("s1 -> " + s1);
        System.out.println("s2 -> " + s2);

        String s3 = findShortCommonSuperSeq(s1, s2);
        System.out.println("Result String is -> " + s3);
        System.out.println(s3.length());
    }

    /** 
     * This method just finds the distinct values in the both the strings and gives them as a string. 
     */
    private static String findShortCommonSuperSeq(String s1, String s2) {

        String result ="";
        Set<Character> set1 =new HashSet<>();

        for(char c1: s1.toCharArray()){
            set1.add(c1);
        }
        for(char c2: s2.toCharArray()){
            set1.add(c2);
        }
        for(char c3: set1){
            result += c3;
        }

        return result;
    }
}