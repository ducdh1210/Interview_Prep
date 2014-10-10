package Design_Pattern.Pattern_Composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class will contain all the companies that are a corporation. A corporation has children.
 * @author Duc Do, Hunter Giesfeldt, Michael Crowell, Austin Nelson, Christopher Koch, Susie Moua
 * @version 1.0
 */
public class Corporation extends CompanyComponent
{
	ArrayList companyComponents = new ArrayList();
	String name;
	double worth;
	
/**
 * This is the constructor for the Corporation class.  
 * @param name of the corporation.
 * @param worth of the corporation.
 */
	public Corporation(String name, double worth) 
	{
		this.name = name;
		this.worth = worth;
	}

/**
 * This is the add method to add a company component.
 * @param CompanyComponent to be added.
 */
	public void add(CompanyComponent CompanyComponent) {
		companyComponents.add(CompanyComponent);
	}
 
/**
 * This is the remove method to remove a company component.
 * @param CompanyComponent to be removed.
 */
	public void remove(CompanyComponent CompanyComponent) {
		companyComponents.remove(CompanyComponent);
	}
 
/**
 * This is the getChild method that will get the corporation below the parent.
 * @param i is the child.
 * @return i the child.
 */
	public CompanyComponent getChild(int i) {
		return (CompanyComponent) companyComponents.get(i);
	}
 
/**
 * This String method will get the name of the corporation.
 * @return name of the corporation.
 */
	public String getName() {
		return name;
	}

/**
 * This method will get the worth of the corporation.
 * @return worth of the corporation.
 */
	public double getWorth() {
		return worth;
	}
	
/**
 * This method will add up the total worth of all the corporations worth.
 * @return totalWorth of the corporations.
 */
	public double getAggreateSum(){
		double totalWorth = getWorth();
		Iterator iterator = companyComponents.iterator();
		while (iterator.hasNext()) {
			CompanyComponent companyComponent = (CompanyComponent)iterator.next();
			totalWorth += companyComponent.getAggreateSum();			
			}
			return totalWorth;
		}
	
/**
 * This method will print out the list of the corporation name and worth.
 */
	public void print() {
		Iterator iterator = companyComponents.iterator();
		System.out.print("CORPORATION, " );
		System.out.print("Name:" + getName());
		System.out.println(", worth " + getWorth() + " million");
  
		while (iterator.hasNext()) {
			CompanyComponent companyComponent = (CompanyComponent)iterator.next();
			companyComponent.print();
		}
	}

}

