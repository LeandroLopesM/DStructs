package com;

import com.stack.Stack;

public class Main {
	
	public Main() {
		Stack s = new Stack();
		
		s.push(1).push(2).push(3).push(4).push(5).push(6);
		
		
		
		System.out.println( s + "  SIZE: " + s.size() );
	}
	
	public static void main( String...args ) {
		new Main();
	}
}
