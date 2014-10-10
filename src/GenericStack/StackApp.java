package GenericStack;

public class StackApp {

	public static void main(String[] args) {
   	    LinkedStack <String> stk = new LinkedStack <String>();
		stk.push("4");
		stk.push("6");
		stk.push("2");
		stk.push("10");
		stk.push("14");
		stk.push("30");
		System.out.println("Before pop: " + stk);
		System.out.println("Top: " + stk.top() + " Rear: " + stk.peekRear());
		//stk.pop();
		//System.out.println("After pop: " + stk);
		//System.out.println("Number of elements: " + stk.getNumOfItems());
		//stk.toString();
		//System.out.println("Rear: " + stk.peekRear());
		//System.out.println(stk.inspect(1));
		//System.out.println("Num of items:  " + stk.getNumOfItems());
		//stk.popSome(2);
		//System.out.println("After pop: " + stk);
		stk.reverseStack3();
		System.out.println("After reverse");
		System.out.println("Top: " + stk.top());

		//System.out.println("Top: " + stk.top() + " Rear: " + stk.peekRear());
	//	System.out.println(stk);
		//System.out.println(stk.nextToTop());

		//System.out.println("After pop: " + stk);
		/*stk.reverseStack();		
		System.out.println(stk);*/
		
//		Animal cat1 = new Animal("Cat1");
//		System.out.println(cat1.getName());
//		
//		Animal dog1 = new Animal("Dog1");
//		System.out.println(dog1.getName());
//		
//		Animal dog2 = new Animal("Dog2");
//		System.out.println(dog2.getName());
//		
//		cat1 = dog1;
//		System.out.println(cat1.getName());
//
//		dog1 = dog2;
//		
//		System.out.println(dog1.getName());
//		System.out.println(cat1.getName());
		




		

	}
}

class Animal{
	private String animal_name;
	public Animal(String name){
		this.animal_name = name; 
	}
	
	public String getName(){
		return this.animal_name;
	}
	
	public void setName(String newName){
		this.animal_name = newName;
	}
}


