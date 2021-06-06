package Lab8;

/*
 * The testing class for the Stack class.
 * 
 * @author Milana Tran
 * @version 2021-06-04
 */

public class TestStack {

	public static void main(String[] args) throws StackException {
		StackAsList<Integer> stack = new StackAsList();
		stack.push(2);
		System.out.println(stack.toString());
		stack.push(345);
		
		stack.push(67);
		
		stack.push(890);
		
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		
	}

}
