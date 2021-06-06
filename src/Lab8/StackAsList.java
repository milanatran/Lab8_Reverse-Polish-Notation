package Lab8;

/*
 * @author Milana Tran
 * @version
 */

public class StackAsList<T> implements Stack<T> {
	private T topElem; //new element on the top of the stack
	private StackAsList<T> oldStack; //stack underneath top and second element
	
	
	public StackAsList() {
		//empty constructor
	}

	public StackAsList(StackAsList<T> oldStack, T topElem) {
		this.oldStack = oldStack;
		this.topElem = topElem;
	}
	
	public static void main (String[] args) throws StackException {
		StackAsList<String> s = new StackAsList();
		//
	}

	@Override
	//Pushes an element to the top of the stack 
	//A new stack is created out of the element added to the old stack as well as the old stack. 
	public void push(T topElem) {
		//adding the old top element into the old stack to make space for new element
		oldStack = new StackAsList(oldStack, this.topElem);
		
		//saving the new element as top element
		this.topElem = topElem;
	}

	@Override
	/**
	 * Removes the top element from the stack
	 * @return The element on the top of the stack 
	 */
	public T pop(){
		T top;
		//if(isEmpty() == true) { //stack empty
		if(topElem == null) {
			top = null;
		} else if (oldStack == null) { //only topElem
			top = topElem;
			topElem = null;
		} else {
			//saving the current top in a var
			top = topElem;
			//making the second element the new top element
			topElem = oldStack.pop();
		}
		return top;
		
	}
	
	@Override
	/**
	 * @return The element on the top of the stack 
	 */
	public T peek() {
		//returns
		return topElem;
	}

	@Override
	//Checks whether the stack is empty or not
	public boolean isEmpty() {
		boolean empty = true;
		//when there is no top element, the stack is empty
		if(topElem != null ) empty = false;
		return empty;
	}
	
	@Override
	/**
	 * @return a String with all elements listed in the stack
	 */
	public String toString(){
		StackAsList<T> refill = new StackAsList();
		String s = "";
		//no element in the stack
	    if(topElem == null) return "[]";
		else {
			while (oldStack.isEmpty() == false) { //there is at least a topElem
				//remove the elements from the stack and add them to string s
				T element;
				
				element = oldStack.pop();
				
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
	
	private void refillOldStack(StackAsList<T> refill){
		while (refill.isEmpty() == false) { 
			T element = refill.pop();
			oldStack.push(element);
			
		}
	}
	
	
}
