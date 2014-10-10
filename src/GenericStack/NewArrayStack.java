package GenericStack;

public class NewArrayStack<T> {
	private T[] stack;
	private int numItems;
	
	public NewArrayStack(int initialSize){
		this.stack = (T[]) new Object[initialSize];
		this.numItems = 0;
	}
	
	public void push(T item){
		if (numItems < stack.length){
			stack[numItems] = item;
			numItems++;
		}else throw new RuntimeException("Array is full...");
	}
	
	public void pop(){
		if (numItems > 0){
			stack[numItems - 1] = null;
			numItems --;
		}
		else throw new RuntimeException("popping empty stack...");
		
	}

}
