package assignment2;

import java.util.Scanner;

/**
 * The TrainSeatBookingApplication Program implements an application that is a
 * Seat Booking System for two different Train Services The
 * TrainSeatBookingApplication contains the main method And is where the user is
 * queried for their desired input The Booking System outputs the FloorGrid,
 * Seat And Journey
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public class TrainSeatBookingApplication {

	/**
	 * This Method prints the Seating Map In which queries the user for selection
	 * for the seat type they would like
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public static void printSeating() {
		System.out.println("Which Seat Type?");
		System.out.println("1.AISLE");
		System.out.println("2.MIDDLE");
		System.out.println("3.WINDOW");
	}

	/**
	 * This Methods prints the Menu for booking in either First, Economy Or
	 * Displaying the Floor Grid Or Exiting the Program
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public static void printMenu() {
		System.out.println("1. Book In First Class");
		System.out.println("2. Book In Economy Class");
		System.out.println("3. Show Floor Grid");
		System.out.println("4. Quit");
	}

	/**
	 * The main method serves as the point of interaction between the user and the
	 * program As well as calling all objects and functions
	 * 
	 * @param args
	 * @author Hamish Maritz, 1383425
	 */

	public static void main(String[] args) {
		String choice1 = "1";
		String choice2 = "2";
		String choice3 = "3";
		String choice4 = "4";

		TrainOperator the_Journey = null;
		FloorGrid seatingGrid = null;
		boolean exit = false;

		// The Journey
		TrainJourney newJourney = new TrainJourney();

		TrainJourney journey1 = new TrainJourney("St Moritz, Switzerland", "Tirano, Northen Italy", "4:00",
				"SWISS100, The Bernina Express");
		TrainJourney journey2 = new TrainJourney("Vancouver, Canada", "Calgary, Alberta", "8:00",
				"ROCKY58, The Rocky Mountaineer");

		System.out.println("Which Train Operator Would You Like To Travel With?");

		String userinput = " ";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("1. TrainWay");
		System.out.println("2. ChooChoo");
		userinput = keyboard.nextLine();

		// Maybe Don't use EqualsIgnoreCase
		if (userinput.equals(choice1)) {
			the_Journey = new TrainWay();
			System.out.println("Menu Item 1 Selected");
		}

		if (userinput.equals(choice2)) {
			the_Journey = new ChooChoo();
			System.out.println("Menu Item 2 Selected");
		}

		System.out.println(the_Journey);

		System.out.println("1." + journey1);
		System.out.println("2." + journey2);
		userinput = keyboard.nextLine();

		if (userinput.equals(choice1)) {
			System.out.println("Menu Item 1 Selected");
			newJourney = journey1;
			seatingGrid = new GrandeFloorGrid();
		}

		if (userinput.equals(choice2)) {

			newJourney = journey2;
			seatingGrid = new PetiteFloorGrid();
		}
		System.out.println(newJourney + "\n"); // remove n line
		System.out.println(seatingGrid);

		// FIX THIS
		newJourney.floorGrid = seatingGrid;

		while (exit == false) {

			SeatType type = SeatType.AISLE;
			printMenu();
			userinput = keyboard.nextLine();

			// IMPORTANT
			String uChoice = null;

			if (userinput.equals(choice1)) {
				uChoice = userinput;
			}

			else if (userinput.equals(choice2)) {
				uChoice = userinput;
			}

			else if (userinput.equals(choice3)) {
				uChoice = userinput;
				System.out.println(newJourney.floorGrid);
			}

			else if (userinput.equals(choice4)) {
				System.exit(0);
			}

			if (uChoice.equals(choice3) == false) {

				printSeating();
				userinput = keyboard.nextLine();

				if (userinput.equals(choice1)) {
					type = SeatType.AISLE;
				}

				else if (userinput.equals(choice2)) {
					type = SeatType.MIDDLE;
				}

				else if (userinput.equals(choice3)) {
					type = SeatType.WINDOW;
				}

				if (uChoice.equals(choice1)) {
					Seat bookSeat = the_Journey.bookFirstClass(newJourney, type);
					System.out.println(newJourney.floorGrid);
					System.out.println(bookSeat.seatDesc());
				}

				else if (uChoice.equals(choice2)) {
					Seat bookSeat = the_Journey.bookEconomyClass(newJourney, type);
					System.out.println(newJourney.floorGrid);
					System.out.println(bookSeat.seatDesc());
				}

				else if (uChoice.equals(choice3)) {
					System.out.println(newJourney.floorGrid);
				}

				else if (uChoice.equals(choice4)) {
					System.exit(0);
				}

			}
		}

	}

}
