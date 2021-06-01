package ReversePolishNotation;

public interface Stack<T> {
	
	abstract void push(T element);
	
	default T pop() {
		return (T) "t";
	}
	
	//returns boolean if the Stack is empty or not (true/false)
	abstract boolean isEmpty();
	
	abstract T peek();
}
