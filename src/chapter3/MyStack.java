package chapter3;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        
        public StackNode(T data) {
            this.data = data;
        }
    }
    
    private StackNode<T> top;
    private int size;
    
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T toReturn = this.top.data;
        this.top = this.top.next;
        this.size--;
        return toReturn;
    }
    
    public void push(T item) {
        StackNode<T> newTop = new StackNode(item);
        newTop.next = top;
        top = newTop;
        this.size++;
    }
    
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();
        return top.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return this.size;
    }
    
    public String toString() {
        if(isEmpty()) return "";
        StringBuffer buffer = new StringBuffer();
        StackNode<T> current = top;
        while(current != null && current.next != null) {
            buffer.append(current.data + " -> ");
            current = current.next;
        }
        buffer.append(current.data);
        return buffer.toString();
    }
}
