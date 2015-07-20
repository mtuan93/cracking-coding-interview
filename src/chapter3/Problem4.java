package chapter3;

public class Problem4 {
    public static void main(String[] args) {
        QueueByTwoStacks<Integer> queue = new QueueByTwoStacks<Integer>();
        for(int i = 1; i < 11; i++) {
           System.out.println("Add " + i + " to the queue");
            queue.add(i);
        }
        for(int i = 1; i < 6; i++) {
            System.out.println("Remove " + queue.remove() + " from the queue");
        }
        for(int i = 1; i < 6; i++) {
            System.out.println("Remove " + queue.remove() + " from the queue");
        }
    }
}

class QueueByTwoStacks<T> {
    private MyStack<T> toPushStack;
    private MyStack<T> toPeekStack;
    
    public QueueByTwoStacks(){
        toPushStack = new MyStack<T>();
        toPeekStack = new MyStack<T>();
    }
    
    public int size() {
        return toPushStack.size() + toPeekStack.size();
    }
    
    public void transferStack() {
        if(toPeekStack.isEmpty()) {
            while(!toPushStack.isEmpty()) {
                toPeekStack.push(toPushStack.pop());
            }
        }
    }
    
    public T remove() {
        this.transferStack();
        return toPeekStack.pop();
    }
    
    public void add(T item) {
        toPushStack.push(item);
    } 
}