package GenericStack;

public class ArrayStack <T>  //generic type
{
	private T[] stack;
	private int numItems;

	public ArrayStack(int initialSize) {
		//super();
		this.stack = ( T[] ) new Object[initialSize];  //we cannot instantiate T[initialSize] 
		this.numItems = 0;
		
	}

	public void push (T item){ //'cause we are working in array, we want to put it into the last, or the top
		if (numItems < stack.length){
			stack[numItems] = item;
		numItems++;
		}
		else throw new RuntimeException("Array is full...");
	}

	public void pop(){
		if (numItems > 0){
			stack[numItems-1]=null; //optional statement, use to entirely killing the element
			numItems--;
		}
		else throw new RuntimeException("Popping from an empty stack...");		
	}
	
	public T top(){
		if (numItems > 0){
			return stack[numItems-1];
		}
		else return null;
	}
	
	public boolean isEmpty(){
		return (numItems == 0); //make sure it is ==. not !=
	}
	
	public String toString(){
		String str = "";
		for (int i=0; i < numItems; i++){
			str += stack[i].toString() + " "; 
		}
		return str;
	}
	
	
	public static void main(String[] args)
	{
		ArrayStack<Integer> stk = new ArrayStack <Integer> (20); //if we want to change to type of stack, just change Integer to the type you like
		stk.push(5);
		stk.push(6);
		stk.push(2);
		stk.push(10);
		System.out.println(stk);
		stk.pop();		System.out.println(stk);

	}

}
