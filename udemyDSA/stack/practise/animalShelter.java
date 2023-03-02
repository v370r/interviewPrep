package udemyDSA.stack.practise;

import java.util.LinkedList;

public class animalShelter {

}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    // enqueue
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        }
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    // Dequeue dogs
    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Dog peekDogs() {
        return dogs.peek();
    }

    // Dequeue Cats
    public Cat dequeueCats() {
        return cats.poll();
    }

    public Cat peekCats() {
        return cats.peek();
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderAnmial(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Animal peek() {
        if (dogs.size() == 0) {
            return dogs.peek();
        } else if (cats.size() == 0) {
            return cats.peek();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderAnmial(cat)) {
            return dogs.peek();
        } else {
            return cats.peek();
        }
    }

}

/**
 * Animal class
 */
abstract class Animal {
    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String name();

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isOlderAnmial(Animal a) {
        return this.order < a.getOrder();
    }
}

/**
 * Cat class
 */
class Cat extends Animal {

    public Cat(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public String name() {
        // TODO Auto-generated method stub
        return "Cat : " + name;
    }

}

/**
 * Dog class
 */
class Dog extends Animal {

    public Dog(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public String name() {
        // TODO Auto-generated method stub
        return "Dog : " + name;
    }

}
