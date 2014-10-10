package Design_Pattern.Pattern_Composite;

/**
 * This CompanyComponent class is abstract. 
 * @author Duc Do, Hunter Giesfeldt, Michael Crowell, Austin Nelson, Christopher Koch, Susie Moua
 * @version 1.0
 */
public abstract class CompanyComponent 
{
/**
 *This method adds a company component.
 *@param companyComponent to be added. 
 */
		public void add(CompanyComponent companyComponent){};
		
/**
 *This method removes a company component.
 *@param companyComponent to be removed. 
 */
		public void remove(CompanyComponent companyComponent){};
		
/**
 *This method gets the child of the company.
 *@param i is the child.
 */
		public CompanyComponent getChild(int i){		
			throw new UnsupportedOperationException();
		}
		

/**
 * This method gets the name of the company.
 * @return name of the company.
 */
		public String getName() {
			throw new UnsupportedOperationException();
		}
		
/**
 * This method gets the worth of the company.
 * @return worth of the company.
 */
		public double getWorth() {
			throw new UnsupportedOperationException();
		}
		
/**
 * This method sums up the worth of the companies.
 * @return sum of all the companies worth.
 */
		public double getAggreateSum(){
			throw new UnsupportedOperationException();
		}
		
/**
 * This method prints out the companies names and worth.
 */
		public void print() {
			throw new UnsupportedOperationException();
		}
	

}
