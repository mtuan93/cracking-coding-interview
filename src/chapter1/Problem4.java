package chapter1;

import java.util.Scanner;

public class Problem4 {
    
    public static void main (String[] args) {
        char[] input = readInput().toCharArray();
        replace(input);
    }
    
    // helper method
    public static String readInput() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the string: ");
        return input.nextLine();
    }
    
    // main algorithm
    public static void replace(char[] input) {
        int whiteSpaceCount = 0;
        for(char c: input) {
            if(c == ' ') {
                whiteSpaceCount++;
            }
        }
        int resultLength = input.length + 2 * whiteSpaceCount;
        int current = input.length - 1, past = resultLength;
        input = (new String(input) + "                                           "
                + "                                                            "
                + "                                                            ").toCharArray();
        while(current != 0) {
            if (input[current] == ' ') {
                input[past-1] = '0';
                input[past-2] = '2';
                input[past-3] = '%';
                past = past - 3;
            } else {
                input[past-1] = input[current];
                past--;
            }
            current--;
        }
        System.out.println("The replaced string is " + new String(input));
    }
}