package Tree;

import java.util.*;
//import week8_List_BookExample.ArraySortedList;


public class MovieCollection 
{
	MovieNode root;
	MovieNode currentMovieNode;
	int totalMovies;
	ArrayList<Movie> arrayStorage = new ArrayList<Movie>(100);
	
	
	public MovieCollection(){
		root = null;
		totalMovies = 0;
	}
	
	public void addMovie(String newTitle, String newDirector, String newGenre, int newBoxOfficeTotal)
	{
			Movie newMovie  = new Movie(newTitle, newDirector, newGenre, newBoxOfficeTotal);
			MovieNode newMovieNode = new MovieNode(newMovie);
			if (root == null)
			{
				root = newMovieNode; totalMovies++;
				return;
			}
			
			MovieNode cursor = root, precursor = null;
			while( cursor != null)
			{
				precursor = cursor;
				if( ((Comparable<Movie>)cursor.getMovie()).compareTo(newMovie) < 0 )
					cursor = cursor.getRight();
				else if( ((Comparable<Movie>)cursor.getMovie()).compareTo(newMovie) > 0 )
					cursor = cursor.getLeft();			
				else return;
			}
			
			if( ((Comparable<Movie>)precursor.getMovie()).compareTo(newMovie) > 0)
				precursor.setLeft(newMovieNode);
			else precursor.setRight(newMovieNode);
			totalMovies++;				
	}
	
	public boolean contains (String title){
		return recContains (title, root);
	}
	
	public boolean recContains (String title, MovieNode root)
	{
		MovieNode cursor = root;
		if (root == null)
			return false;
		else if (cursor.getMovie().getTitle().compareToIgnoreCase(title) > 0)
			return recContains(title, cursor.getLeft());
		else if (cursor.getMovie().getTitle().compareToIgnoreCase(title) < 0)
			return recContains(title, cursor.getRight());
		else 
			currentMovieNode = cursor;
			return true;
	}
	
	public void updateBoxOfficeTotal(String title, int newTotal)
	{
		if (contains(title) == true)
		{
			currentMovieNode.getMovie().setBoxOfficeTotal(newTotal);
		}
		else
			return;
	}
	
	private void postOrder(MovieNode tree)
	  // Initializes postOrderQueue with tree elements in postOrder order.
	  {
	    if (tree != null)
	    {
	      postOrder(tree.getLeft());
	      postOrder(tree.getRight());
	      arrayStorage.add(tree.getMovie());	      
	    }
	  }
	
	public boolean doesContainGenre(String genre)
	{		
			for(int i = 0; i < arrayStorage.size(); i++){
				if( arrayStorage.get(i).getGenre().compareToIgnoreCase(genre) ==0)
				{				
					return true;
				}
			}
			return false;		
	}	
	
	
	public boolean isListEmpty()
	{
		postOrder(root);	
		return arrayStorage.isEmpty();
	}

	
	public ArrayList<Movie> getMoviesWithGenre(String genre)
	{
		if (doesContainGenre(genre) == true)
		{
			ArrayList <Movie> arrayOfGenre = new ArrayList <Movie> (arrayStorage.size());			
			for(int i = 0; i < arrayStorage.size(); i++)
			{
				if( arrayStorage.get(i).getGenre().compareToIgnoreCase(genre) ==0)
				{
					arrayOfGenre.add(arrayStorage.get(i));
				}
			}
			arrayOfGenre.trimToSize();
			
			return arrayOfGenre;			
		}
		else return null;		
	}
	
	public int getBoxOfficeTotal()
	{
		
			int sum = 0;
			for(int i = 0; i < arrayStorage.size(); i++)
			{
				sum += arrayStorage.get(i).getBoxOfficeTotal();
			}
			return sum;		
	}
	
	private void recPrint(MovieNode cursor, int depth) 
	{
	    if(cursor != null){
	      recPrint(cursor.getRight(), depth+1);
		      for(int i = 1; i <= 10*depth; i++)
		        System.out.print(" ");
		      System.out.println(cursor.getMovie().toString());
	      recPrint(cursor.getLeft(), depth+1);
	    }
	}
	
	public void print()
	{
	    recPrint(root, 0);
	}	
	
	public String toString()
	{
	    String str = "List is: \n";
		for(int i = 0; i < arrayStorage.size(); i++)
		{
			str += arrayStorage.get(i).toString() + "  ";
		}
		return str;
	}
	
}

class MovieNode
{
	private Movie theMovie;
	private MovieNode left;
	private MovieNode right;
	
	public MovieNode(Movie newMovie)
	{
		theMovie = newMovie;
		left = right = null;
	}

	public Movie getMovie()
	{
		return theMovie;
	}

	public void setMovie(Movie newMovie)  
	{
		this.theMovie = newMovie;
	}

	public MovieNode getLeft() {
		return left;
	}

	public void setLeft(MovieNode left) {
		this.left = left;
	}

	public MovieNode getRight() {
		return right;
	}

	public void setRight(MovieNode right) {
		this.right = right;
	}
	
}
