package chapter3;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        
        public QueueNode(T data) {
            this.data = data;
        }
    }
    
    private QueueNode<T> first;
    private QueueNode<T> last;
    
    public void add(T item) {
        QueueNode<T> newNode = new QueueNode(item);
        if(last != null) {
            last.next = newNode;
        }
        last = newNode;
        
        // when the queue is originally empty
        if(first == null) {
            first = last;
        }
    }
    
    public T remove() {
        if(isEmpty()) throw new NoSuchElementException();
        T toReturn = first.data;
        first = first.next;
        
        // when there is only 1 element in the queue
        if(isEmpty()) {
            last = null;
        }
        return toReturn;
    }
    
    public T peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return first.data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public String toString() {
        if(isEmpty()) return "";
        StringBuffer buffer = new StringBuffer();
        QueueNode<T> current = first;
        while(current != null && current != last) {
            buffer.append(current.data + " -> ");
            current = current.next;
        }
        buffer.append(current.data);
        return buffer.toString();
    }
}
