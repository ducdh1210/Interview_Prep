package Design_Pattern.Pattern_Composite;

/**
 * This class contains the companies that are franchise. A franchise does not have children.
 * @author Duc Do, Hunter Giesfeldt, Michael Crowell, Austin Nelson, Christopher Koch, Susie Moua
 * @version 1.0
 */
public class Franchise extends CompanyComponent
{
		String name;
		double worth;		

/**
 * This is the constructor for the Franchise class.
 * @param name of the franchise.
 * @param worth of the franchise.
 */
		public Franchise(String name, double worth) 
		{ 
			this.name = name;
			this.worth = worth;			
		}
	  
/**
 * This String method will get the name of the franchise.
 * @return name of the franchise.
 */
		public String getName() {
			return name;
		}
	
/**
 * This method will get the worth of the franchise.
 * @return worth of the franchise.
 */
		public double getWorth() {
			return worth;
		}		
		
/**
 * This method will get the sum of the franchises.
 * @return 
 */
		public double getAggreateSum(){
			return getWorth();
		}
	  
/**
 * This method will print out the list of the franchises.
 */
		public void print() 
		{
			System.out.print("FRANCHISE, " );		
			System.out.print("Name:" + getName());			
			System.out.println(", " + getWorth() + " million");
			
		}
}
