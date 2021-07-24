package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E>{
	
	
	private ArrayList<E> stack;
	
	public ArrayListStack() {
		stack = new ArrayList<E>();
		
	}

	@Override
	public boolean empty() {
		return stack.size() == 0;
	}

	@Override
	public E peek() {
		if (empty())
			throw new EmptyStackException();
		return stack.get(stack.size() - 1);
	}

	@Override
	public E pop() {
		if(empty())
			throw new EmptyStackException();
		return stack.remove(stack.size() - 1);
	}

	@Override
	public E push(E obj) {
		stack.add(obj);
		return obj;
		
	} 
	
	
	
	






}
