package chapter2;

import java.util.Random;
import java.util.Stack;

public class SinglyLinkedList {

    private class Node {
        private int data;
        private Node next;
        
        public Node() {
        }
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        
        public Node getNext() {
            return next;
        }
        
        public void setNext(Node node) {
            this.next = node;
        }
        
        public int getData(){
            return this.data;
        }
        
        public void setData(int data) {
            this.data = data;
        }
        
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
    
    int size = 0;
    Node head;
    
    public SinglyLinkedList() {;
    }
    
    public SinglyLinkedList(int data) {
        size = 1;
        head = new Node(data);
    }
    
    public SinglyLinkedList(Node head) {
        if(head == null) {
            size = 0;
        } else {
            this.head = head;
            size = 1;
            Node pointer = head;
            while(pointer.next != null) {
                pointer = pointer.next;
                size++;
            }
        }
    }
    
    public void addLast(int data) {
        if(isEmpty()) {
            head = new Node(data);
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.setNext(new Node(data));
        }
        size++;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // this constructor generate a random mock linked list
    public SinglyLinkedList (int size, int limit) {
        this.size = 1;
        Random random = new Random();
        head = new Node(random.nextInt(limit));
        for(int i = 1; i < size; i++) {
            this.addLast(random.nextInt(limit));
        }
    }
    
    public int length() {
        return size;
    }
    
    @Override
    public String toString (){
        StringBuffer buffer = new StringBuffer();
        if(isEmpty()) {
            return "";
        }
        Node current = head;
        while(current != null) {
            if(current.next != null)
                buffer.append(current + " -> ");
            else
                buffer.append(current);
            current = current.next;
        }
        return buffer.toString();
    }
    
    public void removeDuplicate() {
        boolean[] flags = new boolean[(int)Math.pow(2,16)]; //assume data is 16-bit
        Node current = head;
        Node previous = head;
        while(current != null) {
            if(flags[current.getData()]) {
                previous.next = current.next;
            } else {
                flags[current.getData()] = true;
                previous = current;
            }
            current = current.next;
        }
    }
    
    public int getKthToLast(int position) {
        if(size < position) {
            return -1;
        }
        Node fast = head, slow = head;
        for(int stepDiff = 0; stepDiff < position - 1; stepDiff++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.getData();
    }
    
    public SinglyLinkedList partition(int index) {
        Node beforeHead = null;
        Node before = null;
        Node after = null;
        Node afterHead = null;
        Node current = head.next;
        if(head == null) return null;
        if(head.getData() < index) {
            before = head;
            beforeHead = head;
        } else {
            afterHead = head;
            after = head;
        }
        while(current != null) {
            if(current.getData() < index) {
                if(beforeHead == null) beforeHead = current;
                if(before == null) before = current;
                else {
                    before.next = current;
                    before = before.next;
                }
            } else {
                if(afterHead == null) afterHead = current;
                if(after == null) after = current;
                else {
                    after.next = current;
                    after = after.next;
                }
            }
            current = current.next;
        }
        after.next = null;
        if(before == null) {
            return new SinglyLinkedList(afterHead);
        }
        before.next = afterHead;
        return new SinglyLinkedList(beforeHead);
    }
    
    public SinglyLinkedList reversedAdd(SinglyLinkedList li) {
        SinglyLinkedList result = new SinglyLinkedList();
        boolean isOverTen = false;
        Node current1 = this.head;
        Node current2 = li.head;
        int sum = 0;
        while(current1 != null || current2 != null) {
            if(current1 != null) {
                sum += current1.getData();
                current1 = current1.next;
            }
            if(current2 != null) {
                sum += current2.getData();
                current2 = current2.next;
            }
            if(isOverTen) sum++;
            if(sum >= 10) {
                isOverTen = true;
                sum %= 10;
            } else isOverTen = false;
            result.addLast(sum);
            sum = 0;
        }
        if(isOverTen) result.addLast(1);
        return result;
    }
    
    public SinglyLinkedList forwardAdd(SinglyLinkedList li) {
        int padding;
        SinglyLinkedList current = this;
        if(this.size > li.length()) {
            li = li.padList(this.size - li.length());
        } else if(this.size < li.length()) {
            current = this.padList(li.length() - this.size);
        }
        WrapperSum sumList = current.forwardAddHelper(li);
        
        if(sumList.carrier == 0) {
            return sumList.list;
        } else {
            Node head = new Node(1);
            head.next = sumList.list.head;
            return new SinglyLinkedList(head);
        }
    }
    
    //assume li and current list have the same length
    public WrapperSum forwardAddHelper(SinglyLinkedList li) {
        if(li.head == null) {
            return new WrapperSum();
        }
        SinglyLinkedList subList1 = new SinglyLinkedList(this.head.next);
        SinglyLinkedList subList2 = new SinglyLinkedList(li.head.next);
        WrapperSum sum = subList1.forwardAddHelper(subList2);
        int val = sum.carrier + this.head.getData() + li.head.getData();
        SinglyLinkedList result;
        if(sum.list != null)
            result = new SinglyLinkedList(new Node(val % 10, sum.list.head));
        else {
            result = new SinglyLinkedList(val%10);
        }
        sum.carrier = val / 10;
        sum.list = result;
        return sum;
    }
    
    class WrapperSum {
        SinglyLinkedList list;
        int carrier;
    }
    
    public SinglyLinkedList padList(int count) {
        Node pointer;
        for(int i = 0; i < count; i++) {
            pointer = new Node(0);
            pointer.next = this.head;
            head = pointer;
        }
        return new SinglyLinkedList(head);
    }
    
    public boolean isPalindrome() {
        Stack stack = new Stack();
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            stack.push(slow.getData());
            fast = fast.next.next;
            slow = slow.next;
        }
        // list has odd length, skip the middle
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            if((int)stack.pop() != slow.getData()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    
    class PalindromeWrapper {
        Node head;
        boolean result;
        public PalindromeWrapper(Node head, boolean result) {
            this.head = head;
            this.result = result;
        }
    }
    
    public boolean isPalineDromeNoStack() {
        return isPalineDromeNoStackRecursive(this.head, this.length()).result;
    }
    
    public PalindromeWrapper isPalineDromeNoStackRecursive(Node headLi, int length) {
        if(headLi == null || length <= 0) {
            return new PalindromeWrapper(headLi, true);
        } else if (length == 1) {
            return new PalindromeWrapper(headLi.next, true);
        }
        
        PalindromeWrapper res = 
                (new SinglyLinkedList()).isPalineDromeNoStackRecursive(headLi.next, length - 2);
        if(!res.result || res.head == null) {
            return res;
        }
        
        res.result = (headLi.getData() == res.head.getData());
        res.head = res.head.next;
        return res;
    }
    
    public void createMockIntersection(SinglyLinkedList empty) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        
        a.next = b;
        b.next = c;
        c.next = f;
        
        d.next = e;
        e.next = f;
        
        f.next = g;
        
        this.head = a;
        this.size = 5;
        
        empty.head = d;
        empty.size = 4;
    }
    
    public int getIntersection(SinglyLinkedList li) {
        Stack st1 = this.constructStack();
        Stack st2 = li.constructStack();
        int result = -1;
        while(!st1.empty() && !st2.empty() && st1.peek() == st2.peek()) {
            st1.pop();
            result = ((Node)st2.pop()).getData();
        }
        return result; 
    }
    
    public Stack constructStack() {
        Stack result = new Stack();
        Node current = head;
        while(current != null) {
            result.push(current);
            current = current.next;
        }
        return result;
    }
}