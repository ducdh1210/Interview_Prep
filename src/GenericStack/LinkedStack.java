package GenericStack;

public class LinkedStack <T>  //generic type
{
	private StackNode <T> top;
	private int numItems;
	
	
	public LinkedStack() {
		//super();
		top = null;
		this.numItems = 0;
	}
	
	public T inspect(int position){
		if (position <= 0 || position > numItems) return null;
		if (isEmpty() == true) return null;
		int counter = 0;
		StackNode <T> cursor = top;
		while (cursor != null)
		{
			counter++;
			if (counter == position)
				break;
			else
			cursor = cursor.getLink();		
		}
		return cursor.getInfo();
	}

	public void push (T item){ 
		StackNode<T> newNode = new StackNode<T>(item);
		newNode.setLink(top);
		top = newNode;
		numItems++;
	}

	public void pop(){		
		if (numItems > 0){
			top =  top.getLink();
			numItems--;
		}
		else throw new RuntimeException("Popping from an empty stack...");
	}
	
	public T top(){
		if (numItems > 0){
			return top.getInfo();
		}
		else return null;
	}
	
	public T nextToTop(){
		if (numItems > 1){
			return top.getLink().getInfo();
		}
		else return null;
	}
	/**Start of assignment 5**/
	public int getNumOfItems(){
		return numItems;
	}
	
	public T peekRear(){
		//System.out.println("numItems: " + numItems);
		if(this.numItems == 0){
			throw new RuntimeException("The stack is empty...");
		}else{
			StackNode<T> cursor = top;
			for (int i = 1; i < numItems; i++){
			//	System.out.println("info:" + cursor.getInfo());
				cursor = cursor.getLink();
			}
			return cursor.getInfo();
		}
	}
	
	
	public void popSome(int count)
	{
		StackNode<T> cursor = top;
		int iteration = 0;
		if (count <= numItems && count >= 0)
		{
			while (cursor != null)
			{
				iteration++;
				if (iteration == count)
				{				
					 top = cursor.getLink();				
					 numItems = numItems - iteration; 
					 break;
				}
				cursor = cursor.getLink();		
			}	
		}
		else throw new RuntimeException("thowring invalid number of items");		
	}
	
	public void reverseStack()
	{
		if (numItems >= 2)
		{			
			StackNode<T> rear = top.getLink();
			StackNode<T> back = top;			
			while (rear != null)
			{			
				back = top;			
				back.setLink(rear.getLink());
				rear.setLink(top);
				top = rear;				
				rear = back.getLink();							
			}				
		}		
		else throw new RuntimeException("the list has only one element");		
	}
	
	public void reverseStack2(){

		if (numItems >= 2){
			StackNode<T> back = top;
			StackNode<T> rear = top.getLink();
			while (rear != null){
				StackNode<T> temp = null;
				if (rear.getLink() != null){	
					temp = rear.getLink();
					rear.setLink(back);
					//back.setLink(null);
					back = rear;
					top = rear;
					rear = temp;
				}else{
					rear.setLink(back);
				}
			}
		}
		System.out.println("done");
	}
	public void reverseStack3(){

		if (numItems >= 2){
			StackNode<T> back = top;
			StackNode<T> rear = top.getLink();
			int count = 0;
			StackNode<T> temp = null;
			while (rear != null){
				if (rear == null){
					rear.setLink(back);
				}else{
					temp = rear.getLink();
					rear.setLink(back);
				}
				if (count == 0){
					back.setLink(null);
				}
				back = rear; 
				top = rear;
				rear = temp;
				
				
			}
		}
		System.out.println("done");
	}
	
	/** End of assignment 5 **/
	public boolean isEmpty(){
		return (numItems == 0); //make sure it is ==. not !=
	}
	
	public String toString(){
		String str = "";
		StackNode<T> cursor = top;
		while(cursor != null){
			str += cursor.getInfo().toString() + "  ";
			cursor = cursor.getLink();
		}
		return str;
	}
}

class StackNode<T>
{
	private T info;
	private StackNode<T> link;
	
	public StackNode(T info) {
		link = null;
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public StackNode<T> getLink() {
		return link;
	}
	
	public void setLink(StackNode<T> link) {
		this.link = link;
	}

}