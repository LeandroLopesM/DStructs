package com.stack;

final public class TestStack {
	
	public TestStack(String in) {
//		String polistNote = "5 6 + 9 - 10 +"; // ((5 + 6) - 9) + 10 = 12;
//		String polishNote = "9 3 * 2 + 10 - 1 - 2 /"; // ((((9 * 3) + 2) - 10) - 1) /2
		String polishNote = "5 10 * 2 / 13 - 8 *"; // (((5 * 10) / 2) - 13) * 8 = 96;
		
		if( in != null ) polishNote = in;
		
		Stack s = new Stack( polishNote.length() );
				
		for( String c : polishNote.split(" ") ) {
			if( isInt(c) ) {
				s.push(c);
			}
			else if( isOperator( c ) ) {
				int rhs = Integer.parseInt("" + s.pop());
				int lhs = Integer.parseInt("" + s.pop());				
				
				s.push( operate( lhs, rhs, c ) );
			}
		}
		System.out.println("GetPolishedNerd => " + s.pop());
	}
	
	public Integer operate( Integer lhs, Integer rhs, String op ) {
		switch( op ) {
			case "/": return lhs / rhs;
			case "*": return lhs * rhs;
			case "-": return lhs - rhs;
			case "+": return lhs + rhs;
			default: return 0;
		}
	}
	
	private boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch( NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean isOperator( String o ) { return o.matches("(\\+|-|\\*|\\/)"); }
}
