package edu.miracosta.cs113;

public class Palindrome{
	
	private String input;
	
	private ArrayListStack<Character> charStack = new ArrayListStack<Character>();
	
	public Palindrome(String s) {
		input = s;
		fillStack();
	}

	private void fillStack() {
		for (int i = 0; i < input.length(); i++)
			charStack.push(input.charAt(i));
		
	}
	
	private String buildReverse() {
		StringBuilder result = new StringBuilder();
		while(!charStack.empty())
			result.append(charStack.pop());
		
		return result.toString();
	}
	
	public  boolean isPalindrome() {
		return input.equalsIgnoreCase(buildReverse());
	}


}




