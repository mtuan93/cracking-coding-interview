package chapter2;

public class Problem5 {
    public static void main(String[] args) {
        SinglyLinkedList mockList1 = new SinglyLinkedList(5,10);
        SinglyLinkedList mockList2 = new SinglyLinkedList(3,10);
        System.out.println(mockList1 + " add reversely " + mockList2 + " is:");
        System.out.println(mockList1.reversedAdd(mockList2));
        
        SinglyLinkedList mockList3 = new SinglyLinkedList(10,10);
        SinglyLinkedList mockList4 = new SinglyLinkedList(5,10);
        System.out.println(mockList3 + " add forwardly " + mockList4 + " is:");
        System.out.println(mockList3.forwardAdd(mockList4));
    }
}