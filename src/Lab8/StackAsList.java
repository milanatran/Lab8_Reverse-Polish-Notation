package Lab8;

/*
 * @author Milana Tran
 * @version
 */

public class StackAsList<T> implements Stack<T> {
	private T topElem; //new element on the top of the stack
	private T secondElem; //element behind top element
	private T newSecond; //will replace second element after popping
	private StackAsList<T> oldStack; //stack underneath top and second element
	
	
	public StackAsList() {
		//empty constructor
	}
	
	public StackAsList(StackAsList<T> oldStack, T topElem) {
		this.oldStack = oldStack;
		this.topElem = topElem;
	}
	
	public static void main (String[] args) {
		StackAsList<String> s = new StackAsList();
		s.push("3");
		s.push("4");
		System.out.println(s.oldStack);
		System.out.println(s.toString());
		System.out.println(s.oldStack);
		System.out.println(s.toString());
	}

	//@Override
	//Pushes an element to the top of the stack 
	//A new stack is created with the element added to the old stack as well as the old stack. 
	/*public void push(T topElem) {
		if(this.topElem == null) {}
		//saving the current second element as new second element before adding it to oldStack
		this.newSecond = this.secondElem;
		//saving the second element into the old stack to make space for new element
		this.oldStack = new StackAsList(this.oldStack, this.secondElem);
		
		//saving the old top element as second element
		this.secondElem = this.topElem;
		//saving the new element as top element
		this.topElem = topElem;
	}*/
	
	@Override
	//Pushes an element to the top of the stack 
	//A new stack is created with the element added to the old stack as well as the old stack. 
	public void push(T topElem) {
		//adding the old top element into the old stack to make space for new element
		this.oldStack = new StackAsList(this.oldStack, this.topElem);
		
		//saving the new element as top element
		this.topElem = topElem;
	}

	@Override
	/**
	 * Removes the top element from the stack
	 * @return The element on the top of the stack 
	 */
	public T pop() {
		T top;
		if(isEmpty() == true) { //stack empty
			top = null;
		} else if (oldStack == null) { //only topElem
			top = this.topElem;
			this.topElem = null;
		} else {
			//saving the current top in a var
			top = this.topElem;
			//making the second element the new top element
			this.topElem = oldStack.pop();
		}
		return top;
		
	}
	
	@Override
	// @return The element on the top of the stack 
	public T peek() {
		//returns
		return this.topElem;
	}

	@Override
	//Checks whether the stack is empty or not
	public boolean isEmpty() {
		boolean empty = true;
		//when there is no top element, the stack is empty
		if(topElem != null && oldStack != null) empty = false;
		return empty;
	}

	/*
	@Override
	public String toString() {

		
		StackAsList<T> aStack = oldStack;
		String s = "";
		//only one element in the stack
		//if(aStack == null && topElem != null) return "[" + topElem + "]";
		//no element in the stack
	    if(aStack == null) return "[]";
		else {
			while (aStack.isEmpty() == false) { //there is at least a topElem
				//remove the elements from the stack and add them to string s
				T element = aStack.pop();
				s += element.toString() + ", ";
			}
			String str = topElem + ", " + s;
			return "[" + str.substring(0, str.length() -2) + "]";
			//return "[" + topElem + ", " + s + "]";
		}
	}
*/
	
	@Override
	public String toString() {
		StackAsList<T> refill = new StackAsList();
		String s = "";
		//no element in the stack
	    if(topElem == null) return "[]";
		else {
			while (oldStack.isEmpty() == false) { //there is at least a topElem
				//remove the elements from the stack and add them to string s
				T element = oldStack.pop();
				s += element.toString() + ", ";
				//as we popped off every element in oldStack, we add them to refill
				refill.push(element);
				
			}
			
			String str = topElem + ", " + s;
			//refill the popped off elements into oldStack
			refillOldStack(refill);
			//return the string separated with comma in brackets 
			//remove last space and comma
			return "[" + str.substring(0, str.length() -2) + "]";
		}
	}
	
	private void refillOldStack(StackAsList<T> refill) {
		while (refill.isEmpty() == false) { 
			T element = refill.pop();
			oldStack.push(element);
			
		}
	}
	
	
}
