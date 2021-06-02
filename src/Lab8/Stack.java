package Lab8;

public interface Stack<T> {
	
	abstract void push(T element);
	
	abstract T pop();
	
	abstract T peek();
	
	abstract boolean isEmpty();
	
	abstract String toString();
}
