package chapter3;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Random generator = new Random();
        SetOfStacks stackList = new SetOfStacks(5); //each stack can hold at most 5 items
        for(int i = 1; i < 45; i++) {
            stackList.push(generator.nextInt(i));
        }
        System.out.println(stackList);
        for(int i = 1; i < 3; i++) {
            stackList.pop();
        }
        System.out.println(stackList);
    }
}

class SetOfStacks {
    private ArrayList<Stack> stackList = new ArrayList<Stack>();
    private int capacity;
    
    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }
    
    public Stack getStackAt(int index) {
        if(index > stackList.size() || index < 0) throw new ArrayIndexOutOfBoundsException();
        return stackList.get(index);
    }
    
    public void push(int item) {
        if(isEmpty()) {
            Stack newStack = new Stack();
            newStack.push(item);
            stackList.add(newStack);
        } else {
            Stack last = this.getLastStack();
            if(last.size() >= capacity) {
                Stack newStack = new Stack();
                newStack.push(item);
                stackList.add(newStack);
            } else {
                last.push(item);
            }
        }
    }
    
    public int pop() {
        if(isEmpty()) throw new EmptyStackException();
        Stack last = this.getLastStack();
        int toReturn = (int) last.pop();
        if(last.isEmpty()) {
            stackList.remove(last);
        }
        return toReturn;
    }
    
    public Stack getLastStack() {
        return stackList.get(stackList.size() - 1);
    }
    
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    
    public String toString() {
        if(isEmpty()) return "";
        StringBuffer buffer = new StringBuffer();
        for(int i = stackList.size() - 1; i >=0; i--) {
            buffer.append("Stack number " + (i+1) + " from top to bottom: \n");
            Stack currentStack = (Stack) stackList.get(i).clone();
            while(!currentStack.isEmpty()) {
                buffer.append(" " + currentStack.pop() + " ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
