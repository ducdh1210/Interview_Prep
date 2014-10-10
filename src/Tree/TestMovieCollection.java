package Tree;

import java.util.*;

public class TestMovieCollection 
{
	public static void main(String[] args) 
	{
		MovieCollection movieTree = new MovieCollection();
		
		String title, director, genre; 
		int boxOfficeTotal ;	
	
		String input = "1";
		while (input.equals("-1") == false)		
		{	
			Scanner scanner  = new Scanner (System.in);
			Scanner scannerN  = new Scanner (System.in);
			System.out.print("Title: ");	
			title = scanner.nextLine();
			System.out.print("Director: ");
			director = scanner.nextLine();
			System.out.print("Genre: ");
			genre = scanner.nextLine();
			System.out.print("Box Office Total: ");
			boxOfficeTotal = scanner.nextInt();	
			
			movieTree.addMovie(title, director, genre,boxOfficeTotal);	
			
			System.out.print("press -1 to end, otherwise new movie info will be entered: ");
			input = scannerN.nextLine();
			System.out.println();
		}
		
		movieTree.isListEmpty();		
		
		Scanner printer  = new Scanner (System.in);		
		movieTree.print();		
	
		// showing movies of same genre
	    System.out.print("Enter prefered genre: ");
		String preferedGenre = printer.nextLine();	    
		System.out.println(movieTree.getMoviesWithGenre(preferedGenre));		
		
		// enter movie title	and update the number total of the title
		System.out.print("Enter movie title for the update: ");
		String updatedTitle = printer.nextLine();
		System.out.print("Enter new office total for the title: ");
		int updatedTotal = printer.nextInt();		
		movieTree.updateBoxOfficeTotal(updatedTitle, updatedTotal);		
		movieTree.print();
		
		// see total number of all titles
		Scanner printerN1  = new Scanner (System.in);		
		System.out.println("Enter 'total' to see the total: ");
		String isTotal = printerN1.nextLine();
		if (isTotal.equalsIgnoreCase("total"))
		{
			System.out.println("Total movies is: " + movieTree.getBoxOfficeTotal());
		}
		
		// print the movie collection
		Scanner printerN2  = new Scanner (System.in);		
		System.out.println("Enter 'collection' to see the collection: ");
		String isCollection = printerN2.nextLine();
		if (isCollection.equalsIgnoreCase("Collection"))
		{
			movieTree.print();
		}		
		
	}	
}
