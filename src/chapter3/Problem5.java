package chapter3;

import java.util.Random;

public class Problem5 {
    public static void main(String[] args) {
        SortedStack<Integer> stack = new SortedStack<Integer>();
        Random generator = new Random();
        for(int i = 1; i < 11; i++) {
            stack.push(generator.nextInt(i));
        }
        System.out.println("The original stack is: ");
        System.out.println(stack);
        System.out.println("The sorted stack is: ");
        System.out.println(stack.getSortedStack());
    }
}

class SortedStack<T extends Comparable> extends MyStack<T> {
    
    public MyStack<T> getSortedStack() {
        MyStack<T> helper = new MyStack<T>();
        T temp;
        while(!this.isEmpty()) {
            temp = this.pop();
            while(!helper.isEmpty() && temp.compareTo(helper.peek()) > 0) {
                this.push(helper.pop());
            }
            helper.push(temp);
        }
        return helper;
    }
}