package chapter1;

import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String s1 = input.nextLine();
        System.out.print("Enter the second string: ");
        String s2 = input.nextLine();
        System.out.println("Is " + s2 + " a rotation of " + s1 + " : " + 
                isRotation(s1,s2));
    }
    
    public static boolean isSubString(String parent, String child) {
        return parent.indexOf(child) != -1;
    }
    
    // return true if s2 is a rotation of s1, false otherwise
    private static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) 
            return false;
        String catS1 = s1 + s1;
        return isSubString(catS1, s2);
    }
}