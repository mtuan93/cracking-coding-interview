package chapter1;

//New problem in the 6th edition

import java.util.Scanner;

//Check if a string can be permutated to be a palindrome
public class Problem9{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string to check: ");
        String data = input.nextLine();
        if(hasPalindromePermutation(data)) {
            System.out.println(data + " has a palindrome permutation"); 
        } else {
            System.out.println(data + " does not have a palindrome permutation");
        }
    }

    private static boolean hasPalindromePermutation(String data) {
        //assume the string is 8-bit
        int[] count = new int[256];
        for(char c : data.toCharArray()) {
            int value = c;
            int min1 = 'a';
            int max1 = 'z';
            int min2 = 'A';
            int max2 = 'Z';
            if((min1 <= value && value <= max1) ||
                    (min2 <= value && value <= max2)) {
                count[Character.valueOf(c)]++;
            }
        }
        int numberOfOddCount = 0;
        for(int i : count) {
            if(i % 2 == 1) {
                numberOfOddCount++;
            }
            if(numberOfOddCount > 1) {
                return false;
            }
        }
        return true;
    }
}