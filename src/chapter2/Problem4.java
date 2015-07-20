package chapter2;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        SinglyLinkedList mockList = new SinglyLinkedList(10,10);
        System.out.println("The list is: ");
        System.out.println(mockList);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an int to partition the list: ");
        int partition = input.nextInt();
        mockList = mockList.partition(partition);
        System.out.println("List after partition is: ");
        System.out.println(mockList);
    }
}