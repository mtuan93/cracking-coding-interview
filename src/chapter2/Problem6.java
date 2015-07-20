package chapter2;

import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        SinglyLinkedList emptyList = new SinglyLinkedList();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter elements for the list: ");
        String[] listInput = input.nextLine().split(" ");
        for(String s : listInput) {
            emptyList.addLast(Integer.parseInt(s));
        };
        System.out.println("The constructed list is " + emptyList);
        if(emptyList.isPalindrome()) {
            System.out.println("The list is a palindrome");
        } else {
            System.out.println("The list is not a palindrome");
        }
                
        System.out.println("Not using stack: ");
        if(emptyList.isPalineDromeNoStack()) {
            System.out.println("The list is a palindrome");
        } else {
            System.out.println("The list is not a palindrome");
        }
    }
}