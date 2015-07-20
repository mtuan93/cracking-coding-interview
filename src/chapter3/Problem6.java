package chapter3;

import java.util.LinkedList;

public class Problem6 {
    
    public static void main(String[] args) {
        AnimalQueue animalQueue = new AnimalQueue();
        Animal dog1 = new Dog("Dog 1");
        Animal dog2 = new Dog("Dog 2");
        Animal dog3 = new Dog("Dog 3");
        Animal dog4 = new Dog("Dog 4");
        Animal dog5 = new Dog("Dog 5");

        Animal cat1 = new Cat("Cat 1");
        Animal cat2 = new Cat("Cat 2");
        Animal cat3 = new Cat("Cat 3");
        Animal cat4 = new Cat("Cat 4");
        Animal cat5 = new Cat("Cat 5");

        animalQueue.enqueue(dog1);
        animalQueue.enqueue(dog2);
        animalQueue.enqueue(dog3);
        
        animalQueue.enqueue(cat1);
        animalQueue.enqueue(cat2);
        animalQueue.enqueue(cat3);
        animalQueue.enqueue(cat4);
        animalQueue.enqueue(cat5);
        
        animalQueue.enqueue(dog4);
        animalQueue.enqueue(dog5);
        System.out.println("Dequeue any of the queue is " + animalQueue.dequeueAny().getName());
        System.out.println("Dequeue any of the queue is " + animalQueue.dequeueAny().getName());        
        System.out.println("Dequeue dog of the queue is " + animalQueue.dequeueDog().getName());        
        System.out.println("Dequeue cat of the queue is " + animalQueue.dequeueCat().getName());
        System.out.println("Dequeue dog of the queue is " + animalQueue.dequeueDog().getName());        
        System.out.println("Dequeue cat of the queue is " + animalQueue.dequeueCat().getName());
        System.out.println("Dequeue dog of the queue is " + animalQueue.dequeueDog().getName());        
        System.out.println("Dequeue cat of the queue is " + animalQueue.dequeueCat().getName());
        System.out.println("Dequeue any of the queue is " + animalQueue.dequeueAny().getName());
        System.out.println("Dequeue any of the queue is " + animalQueue.dequeueAny().getName()); 


    }
}

class AnimalQueue {
    private LinkedList<Dog> dogQueue = new LinkedList<Dog>();
    private LinkedList<Cat> catQueue = new LinkedList<Cat>();
    private int order = 0; // a timestamp
    
    public void enqueue(Animal a) {
        order++;
        a.setOrder(order);
        if(a instanceof Dog) {
            dogQueue.addLast((Dog) a);
        } else if(a instanceof Cat) {
            catQueue.addLast((Cat) a);
        }
    }
    
    public Animal dequeueAny() {
        if(dogQueue.isEmpty()) return this.dequeueCat();
        if(catQueue.isEmpty()) return this.dequeueDog();
        if(dogQueue.peek().isOlderThan(catQueue.peek())) {
            return this.dequeueDog();
        } else {
            return this.dequeueCat();
        }
    }
    
    public Dog dequeueDog() {
        return this.dogQueue.poll();
    }
    
    public Cat dequeueCat() {
        return this.catQueue.poll();
    }
}

abstract class Animal {
    private String name;
    private int order;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    
    public int getOrder() {
        return this.order;
    }
    
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}