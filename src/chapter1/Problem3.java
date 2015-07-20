package chapter1;

import java.util.Scanner;

public class Problem3 {
    
    public static void main (String[] args) {
        String s1 = readInput();
        String s2 = readInput();
        boolean result = isPermutation(s1, s2);
        System.out.println("The string " + s1 + " and " + s2 + " are permutations: " + result);
    }
    
    // helper method
    public static String readInput() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the string: ");
        return input.nextLine();
    }
    
    // main algorithm
    public static boolean isPermutation(String s1, String s2) {
        
        if(s1.length() != s2.length()) return false;
        
        int[] count = new int[256]; // assume s1 and s2 are 8-bit strings
        for(char c: s1.toCharArray()) {
            count[Character.valueOf(c)]++;
        }
        for(char c: s2.toCharArray()) {
            if(count[Character.valueOf(c)] == 0) return false;
            count[Character.valueOf(c)]--;
        }
        return true;
    }
}