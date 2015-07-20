package chapter1;

import java.util.Scanner;

public class Problem10 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s1 = input.nextLine();
        System.out.println("Enter the second string: ");
        String s2 = input.nextLine();
        System.out.println("Is " + s1 + " and " + s2 + " one edit? " + 
                isOneEdit(s1,s2));
    }

    private static boolean isOneEdit(String s1, String s2) {
        if(s1.length() == s2.length()) {
            boolean foundDiff = false;
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    if(foundDiff) {
                        return false;
                    }
                    foundDiff = true;
                }
            }
            return true;
        } else {
            String shorter = s1.length() < s2.length() ? s1 : s2;
            String longer = s1.length() < s2.length() ? s2 : s1;
            if(longer.length() - shorter.length() > 1) {
                return false;
            }
            int index1 = 0, index2 = 0;
            while(index1 < shorter.length() && index2 < longer.length()) {
                if(shorter.charAt(index1) != longer.charAt(index2)) {
                    if(index1 != index2 || shorter.charAt(index1) != longer.charAt(index2+1)) {
                        return false;
                    }
                    index2++;
                }
                index1++;
                index2++;
            }
            return true;
        }
    }
}