package com.nickboy.cc150.chapter3;
import java.util.Stack;


/**
 * An animal shelter holds only dogs and cats, and operates on a strictly
 * "first in, first out" basis. People must adopt either the "oldest" (based on
 * arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and will receive the oldest animal of that
 * type). They cannot select which specific animal they would like. Create the
 * data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the built-in
 * LinkedList data structure.
 * 
 */
// space: all O(1)
// time: enqueue O(1), dequeue O(1), dequeueCat O(n), dequeueDog O(n)

public class Question7 {

	public abstract class Animal {
		private int order;
		protected String name;
		
		public Animal(String n) {
			name = n;
		}

		public void setOrder(int ord) {
			order = ord;
		}

		public int getOrder() {
			return order;
		}

		public boolean is OlderThan(Animal a)
		{
			return this.order < a.order; 
		}
	}

	public class AnimalQueue { 
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0; //timestamp

		public void enqueue(Animal a) {
			//use order to determine the sequence
			a.setOrder(order);
			order++;

			if (a instanceof Dog) 
				dogs.addLast((Dog) a);
			else if (a instanceof Cat)
				cats.addList((Cat) a);
		}

		public Animal dequeueAny() {
			//if one of them is empty, poll another one.
			if (dogs.size() == 0) {
				return cats.poll();
			} else if (cats.size() == 0) {
				return dogs.poll();
			}

			Dog dog = dogs.peek();
			Cat cat = cats.peek();

			//check which one is oldest
			if (dog.isOlderThan(cat))
				return dog.poll();
			else
				return cat.poll();
		}

		public Dog dequeueDogs() {
			return dogs.getFirst();
		}

		public Cat dequeueCats() {
			return cats.getFirst();
		}

	}

	public class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}

	public class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}
}

