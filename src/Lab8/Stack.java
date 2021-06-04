package Lab8;

/*
 * @author Milana Tran and Ruth Wenzel
 * @version 2021-06-03
 */

public interface Stack<T> {
	
	abstract void push(T element);
	
	abstract T pop();
	
	abstract T peek();
	
	abstract boolean isEmpty();
	
	abstract String toString();
}
