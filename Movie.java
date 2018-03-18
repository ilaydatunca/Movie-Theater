package movieTheater;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * 
 * @author Ilayda Tunca
 * @version 1.0
 * @since 2017-10-29
 */

public class Movie {

	String name;
	String director;
	public ArrayList<String> cast;
	public ArrayList<String> types;
	int metascore;
	ArrayList<Movie> watchList = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	/**
	 * Constructor for class Movie
	 * 
	 * @param name,director,cast,types and metascore.
	 *           
	 */
	public Movie(String name, String director, ArrayList<String> cast, ArrayList<String> types, int metascore) {
		this.name = name;
		this.director = director;
		this.cast = cast;
		this.types = types;
		this.metascore = metascore;
	}

	/**
	 * @return information we need to print about the movie
	 */
	@Override
	public String toString() {

		String s = ("Name:" + name + "\nDirector:" + director + "\nCast:" + cast.toString() + "\nTypes:"
				+ types.toString() + "\nMetascore:" + metascore + " \n");

		return s;
	}
}
