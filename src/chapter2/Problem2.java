package chapter2;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        SinglyLinkedList mockList = new SinglyLinkedList(10,50);
        System.out.println("The linked list is: ");
        System.out.println(mockList);
        System.out.println("Enter the k-th position to last: ");
        Scanner input = new Scanner(System.in);
        int position = input.nextInt();
        System.out.println("The data at " + position + " to last is: " + 
                mockList.getKthToLast(position));
    }
   
}