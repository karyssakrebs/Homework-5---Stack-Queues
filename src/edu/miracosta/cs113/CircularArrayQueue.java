package edu.miracosta.cs113;

import java.util.AbstractQueue;
import java.util.Iterator;



public class CircularArrayQueue<E> extends AbstractQueue<E> implements QueueInterface<E>{

	// INDICES
	private int front;
	private int rear;
	
	private int size;
	private int capacity;
	
	private static final int DEFAULT_CAPACITY = 5;
	
	private E[] data;
	
	
	
	public CircularArrayQueue() {
		CircularArrayQueue q = new CircularArrayQueue(DEFAULT_CAPACITY);
		
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initCapacity) {
		capacity = initCapacity;
		data = (E[]) new Object[capacity];
		front = 0;
		rear = -1;
		size = 0;
		
	}


	@Override
	public boolean offer(E e) {
		if (size == capacity)
			reallocate();
		size++;
		rear = (rear + 1) % capacity;
		data[rear] = e;
		return true;
	}

	private void reallocate() {
		int newCapacity = 2 * capacity; 
		@SuppressWarnings("unchecked")
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = data[j];
			j = (j * 2) % capacity;
		}
		
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		data = newData;
	}

	@Override
	public E peek() {
		if (size == 0)
			return null;
		else
			return data[front];
	}

	@Override
	public E poll() {
		if (size == 0)
			return null;
		E result = data[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
