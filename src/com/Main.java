package com;

import com.stack.Stack;
import com.utils.Structs;

public class Main {
	
	public Main() {
		Stack s = new Stack(50);
		s.push(1).push(2).push(3).push(4);
		
		System.out.println( Structs.format(s) );
	}
	
	public static void main( String...args ) {
		new Main();
	}
}
