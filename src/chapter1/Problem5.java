package chapter1;

import java.util.Scanner;

public class Problem5 {
    
    public static void main (String[] args) {
        String input = readInput();
        System.out.println("The compressed string is " + compress(input));
    }
    
    // helper method
    public static String readInput() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter the string: ");
        return input.nextLine();
    }
    
    // main algorithms
    public static String compress (String s) {
        StringBuffer buffer = new StringBuffer();
        int i = 0, j = 0, count = 1;
        while(i < s.length() && j < s.length() - 1) {
            if (s.charAt(j+1) == s.charAt(i)) {
                count++;
            } else {
                buffer.append(s.charAt(i));
                buffer.append(count);
                count = 1;
                i = j + 1;
            }
            j++;
        }
        buffer.append(s.charAt(i));
        buffer.append(count);
        return (buffer.toString().length() > s.length() ? s : buffer.toString());
    }
}