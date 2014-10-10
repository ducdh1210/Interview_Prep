package Design_Pattern.Pattern_Composite;

public class CompanyTestDrive {

	public static void main(String[] args) 
	{
		CompanyComponent acmeCompany = new Corporation("Acme Company", 500.3);		
		
		CompanyComponent USA = new Corporation("USA", 250.6);
		CompanyComponent GeneralManufactoring = new Franchise("GeneralManufactoring", 50.4);
		CompanyComponent Japan = new Corporation("Japan", 150.4);
		
		acmeCompany.add(USA);
		acmeCompany.add(GeneralManufactoring);
		acmeCompany.add(Japan);
		
		CompanyComponent Auto = new Franchise("Auto", 75.1);
		CompanyComponent Finance = new Corporation("Finance", 375.2);
		CompanyComponent Security = new Corporation("Security", 3.2);
		
		USA.add(Auto);
		USA.add(Finance);
		USA.add(Security);
		
		CompanyComponent Food = new Corporation("Food", 25.2);
		CompanyComponent Communication = new Corporation("Communication", 5.2);
		CompanyComponent Weapons = new Franchise("Weapons", 8.5);
		
		Japan.add(Food);
		Japan.add(Communication);
		Japan.add(Weapons);
		

		CompanyComponent GreenRUs = new Franchise("Green-R-Us", 175.2);
		CompanyComponent Bank = new Corporation("Bank", 285.2);
		CompanyComponent Surveillance = new Franchise("Surveillance", 7.3);
		
		Finance.add(GreenRUs);
		Finance.add(Bank);
		Finance.add(Surveillance);
		
		CompanyComponent Sushi = new Franchise("Shusi", 2.2);
		CompanyComponent Gencell = new Franchise("Gencell", 3.2);
		
		Food.add(Sushi);
		Communication.add(Gencell);
		
		CompanyComponent SavingAndLoan = new Franchise("Saving&Loan", 275.8);
		Bank.add(SavingAndLoan);		
		
		acmeCompany.print();
		
		System.out.println("Total Acme worth is " + acmeCompany.getAggreateSum() + " million");

		
		
	}

}
