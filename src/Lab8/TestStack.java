package Lab8;

public class TestStack {

	public static void main(String[] args) {
		StackAsList<Integer> stack = new StackAsList();
		stack.push(2);
		
		stack.push(345);
		
		stack.push(67);
		
		stack.push(890);
		
		stack.push(1);
		//System.out.println(stack.pop());
		System.out.println(stack.toString());
		//System.out.println(stack.isEmpty());
		
	}

}
