package assignment2;

/**
 * This Class Holds Details If The Seat Is Reserved Or Not using Protected
 * Variables and Objects.
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public class Seat {
	// Seat Position
	protected int row;
	protected int col;
	protected boolean reserved;
	protected boolean firstClass;
	protected SeatPosition seatPosition;
	protected SeatType seatType;

	/**
	 * This Method Fills the seatPosition Object with the rows and columns
	 * 
	 * @param row
	 * @param col
	 * @author Hamish Maritz, 1383425
	 */
	public Seat(int row, int col) {
		this.row = row;
		this.col = col;

		seatPosition = new SeatPosition(row, col);

	}

	public String toString() {
		String representation = " ";
		String type = null;

		switch (seatType) {
		case AISLE:
			type = "A";
			break;

		case MIDDLE:
			type = "M";
			break;
		case WINDOW:
			type = "W";
			break;
		}
		if (firstClass == true) {
			type = type.toUpperCase();
		}

		if (reserved == true) {
			representation = (" [" + type + " X]");
		}

		else {
			representation = (" [" + type + "  ]");
		}

		return representation;
	}

	/**
	 * This Method Contains a text based description of the seat
	 * 
	 * @author Hamish Maritz, 1383425
	 * @return
	 */
	public String seatDesc() {
		String output = " ";

		if (firstClass = true) {
			output = ("First Class");
		}

		else {
			output = ("Economy Class");
		}

		switch (seatType) {

		case AISLE:
			output = ("AISLE SEAT AT: ");
			break;
		case MIDDLE:
			output = ("MIDDLE SEAT AT: ");
			break;
		case WINDOW:
			output = ("WINDOW SEAT AT: ");
			break;
		}

		if (reserved == true) {
			output = (output + seatPosition + " is Reserved");
		} else {
			output = (output + seatPosition + " is Not Reserved");
		}

		return output;
	}

}
