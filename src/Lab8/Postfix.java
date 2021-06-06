package Lab8;

import java.io.IOException;
import java.util.StringTokenizer;

/*
 * Class Postfix that takes postfix as a String and returns the evaluation.
 * https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * 
 * @author Ruth Wenzel
 * @version 2021-06-04
 */

public class Postfix {
	private StackAsList<String> stack = new StackAsList<>();
	
	public static void main(String[] args) {
	Postfix p = new Postfix();
	String s = "21+3*";
	System.out.println(p.evaluate(s));
	}
	
	public int evaluate (String pfx) {
		String[] array = pfx.split("");
		// Possible operators
		String operators = "+-*/";	
		
		for (String s: array) {
			// If it is an operand push it to the stack
			if (!operators.contains(s)) { 
				stack.push(s);
			// If it is an operator pop it from the stack
			} else {
				int rhs = Integer.valueOf(stack.pop());
				int lhs = Integer.valueOf(stack.pop());
				switch (s) {
					case "+":
						stack.push(String.valueOf(lhs + rhs));
						break;
					case "-":
						stack.push(String.valueOf(lhs - rhs));
						break;
					case "*":
						stack.push(String.valueOf(lhs * rhs));
						break;
					case "/":
						stack.push(String.valueOf(lhs / rhs));
						break;
				}
			}	
		}
		return Integer.valueOf(stack.pop());
	}
}
