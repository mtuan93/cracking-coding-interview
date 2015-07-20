package chapter2;

public class Problem7 {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list1.createMockIntersection(list2);
        System.out.println(list1 + " and " + list2 + " intersect at " + list1.getIntersection(list2));
    }
}
