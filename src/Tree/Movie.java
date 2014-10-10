package Tree;

public class Movie implements Comparable<Movie>
{
	String title, director, genre;
	int boxOfficeTotal;	
	
	public Movie()	{
	}

	public Movie(String title, String director, String genre, int boxOfficeTotal) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.boxOfficeTotal = boxOfficeTotal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getBoxOfficeTotal() {
		return boxOfficeTotal;
	}

	public void setBoxOfficeTotal(int boxOfficeTotal) {
		this.boxOfficeTotal = boxOfficeTotal;
	}
	
	public boolean equals(Object o){
		Movie m = (Movie) o;
		return title.equals(m.title);
	}

	@Override
//	public int compareTo(Movie m) {
//		return title.compareToIgnoreCase(m.title);
//	}
	public int compareTo(Movie m) {
		if (this.boxOfficeTotal < m.boxOfficeTotal) return -1;
		else if (this.boxOfficeTotal > m.boxOfficeTotal) return 1;
		else return 0;
		//return title.compareToIgnoreCase(m.title);
	}
	
	
	public String toString()
	{
		return title + " (" + boxOfficeTotal + ")";
	}

}
