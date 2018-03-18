package movieTheater;

import java.io.File;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Simple movie database application
 * 
 * @author Ilayda Tunca
 * @version 1.0
 * @since 2017-11-30
 *
 */
public class ilayda_tunca {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("movies.txt");
		Scanner input = new Scanner(file);

		Scanner user = new Scanner(System.in);
		String choice = null;
		ArrayList<Movie> movies = new ArrayList<>();
		Movie movie = null;
		ArrayList<String> actors = new ArrayList<>();
		ArrayList<String> types = new ArrayList<>();
		ArrayList<Movie> watchList = new ArrayList<>();

		while (input.hasNextLine()) {

			String temp = input.next();
			String name = input.nextLine();
			name = name.trim(); // cut gaps in the beginning and end of the
			// movie name

			temp = input.next();
			String director = input.nextLine();
			director = director.trim(); // cut gaps in the beginning and end of
			// the director name

			temp = input.next();
			String cast = input.nextLine();
			cast = cast.trim();
			String[] actor = cast.split(",");// assign actors names in array
			for (int i = 0; i < actor.length; i++) {
				actor[i] = actor[i].trim(); // cut gaps in the beginning and end
				// of the actor name
			}

			actors = new ArrayList<String>(Arrays.asList(actor)); // adding actor array to actors ArrayList

			temp = input.next();
			String type = input.nextLine();
			type = type.trim();
			String[] categories = type.split(",");// assign types in array
			for (int i = 0; i < categories.length; i++)
				categories[i] = categories[i].trim();// cut gaps in the beginning and end
			// of the movie types

			types = new ArrayList<String>(Arrays.asList(categories));// adding categories array to types ArrayList

			temp = input.next();
			String day = input.nextLine();
			day = day.trim(); // cut gaps in the beginning and end movie days
			String[] days = day.split(" ");
			for (int i = 0; i < days.length; i++) {
				days[i] = days[i].trim();
			}

			temp = input.next();
			String time = input.nextLine();
			time = time.trim();// cut gaps in the beginning and end of the movie times
			String[] times = time.split(" ");  
			for (int i = 0; i < times.length; i++) {
				times[i] = times[i].trim(); 
			}

			temp = input.next();
			String metascore = input.nextLine();
			metascore = metascore.trim();// cut gaps in the beginning and end of the movie metascore
			Integer score = Integer.valueOf(metascore);

			movie = new Movie(name, director, actors, types, score);
			movies.add(movie);
		}

		while (choice != "q") {
			System.out.println("============================");
			System.out.println("[1] List All Movies");
			System.out.println("[2] Find Movie");
			System.out.println("[3] Highest Rated Movies");
			System.out.println("[4] Movies in Three Hours");
			System.out.println("[5] Add to Watchlist");
			System.out.println("[6] Display Watchlist");
			System.out.println("[q] Quit");
			System.out.println("============================");
			System.out.println("ENTER YOUR CHOICE >");
			choice = user.nextLine();

			switch (choice) {
			case "1":
				System.out.println("Listing Movies");
				for (int i = 0; i < movies.size(); i++) {
					System.out.println(movies.get(i).toString());
				}
				break;

			case "2":
				String selected = null;

				while (selected != "b") {
					System.out.println("============================");
					System.out.println("[1]Find by name");
					System.out.println("[2]Find by director");
					System.out.println("[3]Find by cast");
					System.out.println("[4]Find by type");
					System.out.println("[b]Back to the Main Menu");
					System.out.println("============================");
					System.out.println("ENTER YOUR CHOICE >");
					selected = user.nextLine();

					if (selected.equals("1")) {
						System.out.println("Find by movie name.Enter at least three characters.");

						System.out.println("ENTER MOVIE NAME >");
						String mName = user.next();
						for (int i = 0; i < movies.size(); i++) {
							if (movies.get(i).name.contains(mName)) {
								System.out.println("Name:" + movies.get(i).name + "\nDirector:" + movies.get(i).director
										+ "\nCast:" + movies.get(i).cast.toString() + "\nTypes:"
										+ movies.get(i).types.toString() + "\nMetascore:" + movies.get(i).metascore
										+ " \n");
							}

						}
					} else if (selected.equals("2")) {
						System.out.println("Find by director name.Enter at least three characters.");
						System.out.println("ENTER DIRECTOR NAME > ");
						String dName = user.next();
						for (int i = 0; i < movies.size(); i++) {
							if (movies.get(i).director.contains(dName)) {
								System.out.println("Name:" + movies.get(i).name + "\nDirector:" + movies.get(i).director
										+ "\nCast:" + movies.get(i).cast.toString() + "\nTypes:"
										+ movies.get(i).types.toString() + "\nMetascore:" + movies.get(i).metascore
										+ " \n");
							}

						}

					} else if (selected.equals("3")) {
						System.out.println("Find by cast.Enter at least three characters.");
						String cName = user.next();
						String.format("ENTER CAST > %s", cName);
						for (int i = 0; i < movies.size(); i++) {
							if (movies.get(i).cast.contains(cName)) {
								System.out.println("Name:" + movies.get(i).name + "\nDirector:" + movies.get(i).director
										+ "\nCast:" + movies.get(i).cast.toString() + "\nTypes:"
										+ movies.get(i).types.toString() + "\nMetascore:" + movies.get(i).metascore
										+ " \n");
							}

						}

					}

					else if (selected.equals("4")) {
						System.out.println("Find by type.Enter at least three characters.");
						String tName = user.next();
						String.format("ENTER TYPE> %s", tName);
						for (int i = 0; i < movies.size(); i++) {
							if (movies.get(i).cast.contains(tName)) {
								System.out.println("Name:" + movies.get(i).name + "\nDirector:" + movies.get(i).director
										+ "\nCast:" + movies.get(i).cast.toString() + "\nTypes:"
										+ movies.get(i).types.toString() + "\nMetascore:" + movies.get(i).metascore
										+ " \n");
							}

						}
					} else if (selected.equals("b")) {
						break;
					}
				}

				break;

			case "3":
				System.out.println("Listing Highest Scored Movies");
				System.out.println(String.format("ENTER MINIMUM METASCORE > "));
				int highest = user.nextInt();
				for (int i = 0; i < movies.size(); i++) {

					if (movies.get(i).metascore > highest) {
						System.out.println("Name:" + movies.get(i).name + "\nDirector:" + movies.get(i).director
								+ "\nCast:" + movies.get(i).cast.toString() + "\nTypes:"
								+ movies.get(i).types.toString() + "\nMetascore:" + movies.get(i).metascore + " \n");
					}
				}
				break;
			case "4":
				SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
				Date date = new Date();
				date.getTime();
				break;

			case "5":
				System.out.println("Select from the list:");
				System.out.println("0. The Other Side of Hope");
				System.out.println("1. Le Havre");
				System.out.println("2. The Square");
				System.out.println("3. Murder on the Orient Express");
				System.out.println("4. Volver");
				System.out.println("5. Sin City A Dame to Kill For");
				System.out.println("6. The Dreamers");
				System.out.println("7. Julieta");
				System.out.println("8. Sin City");
				System.out.println("9. You Were Never Really Here");
				System.out.println("ENTER SELECTION >");
				int selection = user.nextInt();
				for (int i = 0; i < movies.size(); i++) {
					if (selection == 0) {
						System.out.println("The Other Side of Hope is added to your watchlist");
						watchList.add(movies.get(0));
					} else if (selection == 1) {
						System.out.println("Le Havre is added to your watchlist");
						watchList.add(movies.get(1));
					} else if (selection == 2) {
						System.out.println("The Square is added to your watchlist");
						watchList.add(movies.get(2));
					} else if (selection == 3) {
						System.out.println("Murder on the Orient Express is added to your watchlist");
						watchList.add(movies.get(3));
					} else if (selection == 4) {
						System.out.println("Volver is added to your watchlist");
						watchList.add(movies.get(4));
					}

					else if (selection == 5) {
						System.out.println("Sin City A Dame to Kill For is added to your watchlist");
						watchList.add(movies.get(5));
					}

					else if (selection == 6) {
						System.out.println("The Dreamers is added to your watchlist");
						watchList.add(movies.get(6));
					} else if (selection == 7) {
						System.out.println("The Dreamers is added to your watchlist");
						watchList.add(movies.get(7));
					} else if (selection == 8) {
						System.out.println("Sin City is added to your watchlist");
						watchList.add(movies.get(8));
					} else if (selection == 9) {
						System.out.println("You Were Never Really Here is added to your watchlist");
						watchList.add(movies.get(9));
					} else {
						System.out.println("You made the wrong choice.");
						break;
					}

					break;
				}

			case "6":
				for (int i = 0; i < watchList.size(); i++) {
					System.out.println(watchList.get(i).toString());
				}
				break;

			case "q":
				return;
			}
		}
	}

}
