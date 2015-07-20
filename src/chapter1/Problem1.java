package chapter1;

import java.util.Scanner;

public class Problem1 {
    
    public static void main (String[] args) {
        String input = readInput();
        boolean result = isUniqueChars(input);
        System.out.println("The string " + input + " has all unique characters: " + result);
    }
    
    // helper method
    public static String readInput() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the string: ");
        return input.nextLine();
    }
    
    // main algorithm
    public static boolean isUniqueChars(String input) {
        boolean[] flags = new boolean[256]; // asume this is 8-bit string
        char[] listChar = input.toCharArray();
        for(char c : listChar) { 
            if(flags[Character.valueOf(c)]) return false;
            flags[Character.valueOf(c)] = true;
        }
        return true;
    }
}