package com.utils;

import java.util.Random;

import com.stack.Stack;

public class Structs {
	
	public static String format( Stack s ) {
		String ret = s.getClass().getSimpleName() + '\n';
		
		for( Object o : s.toArray() ) {
			if( o == null ) break;
			ret += "|%-3.3s%s%-3.3s|\n".formatted( " ", o, " " );
		}
		
		return ret;
	}
	
		public void populate( Stack s, int[] range ) {
			if( s.isDynamic() ) throw new UnsupportedOperationException("For dynamic stacks use populate(Stack s, int[] range, int size)");
			Random r = new Random();
			while(!s.isFull()) {
				s.push(r.nextInt(range[0], range[1]));
			}
		}
	
	public static int getWidth( Object p ) {
		if( p instanceof Integer ) {
			int c = 0;
			Integer o = (Integer)p;
			
			
			while( o > 0 ) {
				o /= 10;
				c++;
			}
			return c;
		}
		
		return 0;
	}
	
	public static int getLargest( Stack s ) {
		int curr = 0;
		for( Object o : s.toArray() ) {
			if( getWidth(o) > curr ) {
				curr = getWidth(o);
			}
		}
		return curr;
	}
}
