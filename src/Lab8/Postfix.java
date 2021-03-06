package Lab8;

import java.util.Scanner;

/**
 * Class Postfix that takes postfix as a String and returns the evaluation.
 * https://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * 
 * @author Ruth Wenzel & Milana Tran
 * @version 2021-06-04
 */

public class Postfix {
	private StackAsList<String> stack = new StackAsList<>();
	private String operators = "+-*/()"; 
	
	public static void main(String[] args){
	Postfix p = new Postfix();
	//String s = "213*+";
	//System.out.println(p.evaluate(s));
	String s = p.infixToPostfix("(3-2*(4/2))+8");
	//String s = "12*3+";
	System.out.println("The solution is " + p.evaluate(s));
	//String s = p.infixToPostfix("(3-2*(4/2))+8");
	//String s = p.infixToPostfix("(3-2*(4/2))+");
	//System.out.println(s);
	//System.out.println(p.evaluate(s));
	System.out.println(p.evaluateInfix());
	
	}
	
	/**
	 * Evaluates a given postfix expression String.
	 * @param pfx
	 * @returns the result of the expression.
	 */
	public int evaluate (String pfx){
		String[] array = pfx.split("");

		// Possible operators
		String operators = "+-*/";	

		for (String s: array) {
			// If it is an operand push it to the stack
			if (!operators.contains(s)) { 
				stack.push(s);
			// If it is an operator pop two operandsS from the stack
			} else {
				int rhs = Integer.valueOf(stack.pop());
				int lhs = Integer.valueOf(stack.pop());
				Integer result = calculateResult(lhs, s, rhs);
				stack.push(result.toString());
			}	
		}
		return Integer.valueOf(stack.pop());
	}
	
	/**
	 * A method that takes an infix expression and converts
	 * it into a postfix expression.
	 * @param ifx
	 * @return The to postfix converted infix expression.
	 */
	public String infixToPostfix(String ifx) {
		StackAsList<String> ops = new StackAsList<>(); //stack for operators
		String r = "";
		String[] array = ifx.split("");
		
		if(ifx.contains(" ") || "+-*/".contains(array[0]) || "+-*/".contains(array[array.length -1]))
			throw new RuntimeException("Invalid input for String ifx");
		
		for(String s: array) {
			// If it is an operand 
			if (!operators.contains(s)) {
				r = r + s;
			} else if (s.equals("(")) {
				ops.push(s);
			} else if (s.equals(")")) {
				while(!ops.peek().equals("(")) {
					r = r + ops.pop();
				}
				ops.pop(); //remove the open parentheses in stack
			} else { //is an operator
				while(ops.isEmpty() == false && 
						(precedence(ops.peek()) > precedence(s) || 
								precedence(ops.peek()) == precedence(s))) {
					r = r + ops.pop();
				}
				ops.push(s);
			}
		}
		
		//Now add the rest of the operators at the end
		while(ops.isEmpty() == false) {
			r = r + ops.pop();
		}
		return r;
	}
	
	public int evaluateInfix(){
		StackAsList<Integer> nums = new StackAsList<>();
		StackAsList<String> ops = new StackAsList<>();
		Scanner in = new Scanner(System.in);
		String ifx = in.nextLine();
		String[] array = ifx.split("");
		
		for(String s : array) {
			if(!operators.contains(s)) {
				nums.push(Integer.valueOf(s));
			} else if(s.equals("(")) ops.push(s);
			
			else if(s.equals(")")) {
				while(!ops.peek().equals("(")) {
					int rhs = nums.pop();
					int lhs = nums.pop();
					String op = ops.pop();
					nums.push(calculateResult(lhs, op, rhs));
					
				}
				ops.pop(); //remove open parentheses
			} else { //is an operator
				while(ops.isEmpty() == false && (precedence(ops.peek()) >= precedence(s))) {
					int rhs = nums.pop();
					int lhs = nums.pop();
					String op = ops.pop();
					nums.push(calculateResult(lhs, op, rhs));
				}
				ops.push(s);
				
			}
		}
		while(ops.isEmpty() == false) {
			int rhs = nums.pop();
			int lhs = nums.pop();
			String op = ops.pop();
			nums.push(calculateResult(lhs, op, rhs));
		}
		return nums.pop();
	}
	
	private int precedence(String operator) {
		int p = 0;
		if(operator.equals("+") || operator.equals("-")) p = 1;
		else if (operator.equals("*") || operator.equals("/")) p = 2;
		else if (operator.equals("(")) p = 0;
		return p;
	}
	
	private int calculateResult(int lhs, String op, int rhs) {
		int r = 0;
		switch (op) {
		case "+":
			r = lhs + rhs;
			break;
		case "-":
			r = lhs - rhs;
			break;
		case "*":
			r = lhs * rhs;
			break;
		case "/":
			r = lhs / rhs;
			break;
		}
		return r;
	}
}
