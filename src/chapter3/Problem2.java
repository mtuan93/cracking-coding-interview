package chapter3;

import java.util.EmptyStackException;
import java.util.Random;

public class Problem2 {
    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack();
        Random random = new Random();
        for(int i = 1; i < 11; i++) {
            stack.push(random.nextInt(i*100) + 1);
        }
        while(!stack.isEmpty()) {
            System.out.println("Current stack starting from top: " + stack);
            System.out.println("Its minimum value is: " + stack.min());
            System.out.println();
            stack.pop();
        }
    }
}

class MinStack<T extends Comparable>{
    private static class MinStackNode<T> {
        private T data;
        private MinStackNode<T> next;
        private T min;
        
        public MinStackNode(T data, T min) {
            this.data = data;
            this.min = min;
        }
    }
    
    private MinStackNode<T> top;
    
    public void push(T item) {
        MinStackNode<T> newNode = new MinStackNode(item, item);
        if(isEmpty()) {
            top = newNode;
        } else {
            if(item.compareTo(top.min) > 0) {
                newNode.min = top.min;
            } else {
                newNode.min = newNode.data;
            }
            newNode.next = top;
            top = newNode;
        }
    }
    
    public T min() {
        if(isEmpty()) throw new EmptyStackException();
        return top.min;
    }
    
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T toReturn = top.data;
        top = top.next;
        return toReturn;
    }
    
    @Override
    public String toString() {
        if(isEmpty()) return "";
        StringBuffer buffer = new StringBuffer();
        MinStackNode<T> current = top;
        while(current != null && current.next != null) {
            buffer.append(current.data + " -> ");
            current = current.next;
        }
        buffer.append(current.data);
        return buffer.toString();
    }
    
    public boolean isEmpty() {
        return this.top == null;
    }
}
