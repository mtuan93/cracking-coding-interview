package chapter3;

public class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack();
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("My stack from top to bottom is: " + stack);
        
        MyQueue<Integer> queue = new MyQueue();
        for(int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println("My queue from first to last is: " + queue);
    }
}
