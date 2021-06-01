package Lab8;

public interface Stack<T> {
	
	abstract void push(T element);
	
	default T pull() {
		return (T) "T";
	}
	
	abstract boolean isEmpty();
	
	abstract String toString();
}
