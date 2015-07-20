package chapter2;

public class Problem1 {
    public static void main(String[] args) {
        SinglyLinkedList mockList = new SinglyLinkedList(10,10);
        System.out.println("Original Linked list: ");
        System.out.println(mockList);
        System.out.println("List after remove duplicates: ");
        removeDuplicate(mockList);
        System.out.println(mockList);
    }

    private static void removeDuplicate(SinglyLinkedList mockList) {
        mockList.removeDuplicate();
    }
}