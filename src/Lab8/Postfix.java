package Lab8;

import java.io.IOException;
import java.util.StringTokenizer;

public class Postfix {
	private StackAsList<String> stack = new StackAsList<>();
	
	public static void main(String[] args) {
//	String[] tokens = new String[] { "2", "1", "+", "3", "*" };
	Postfix p = new Postfix();
	String s = "21+3*";
	System.out.println(p.evaluate(s));
	}
	
	public int evaluate (String pfx) {
		String[] array = pfx.split("");
		String operators = "+-*/";	
		
		for (String s: array) {
			if (!operators.contains(s)) { //push to stack if it is a number
				stack.push(s);
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
	
	
	//https://www.mathblog.dk/tools/infix-postfix-converter/
	//https://www.mathblog.dk/reverse-polish-notation/
	//https://stackoverflow.com/questions/27083467/how-to-implement-an-interface-for-stack
}
