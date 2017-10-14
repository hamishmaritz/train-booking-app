package assignment2;

/**
 * This Class is an Abstract Class that contains the Methods of Last Row, Last
 * Column, Left Seat, Right Seat And the 2D Seating Array
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public abstract class FloorGrid {

	// Matrix And Number Of Rows
	protected int numberOfRows;
	protected int numberOfCols;
	protected int firstClassRow;

	// 2D Array of Seat Object
	protected Seat[][] seats;

	// Abstract Method
	abstract void initialiseFloorGrid();

	public int getLastRow() {
		return numberOfRows;
	}

	/**
	 * This Method returns the Last Column in the Seat Position
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public char getLastCol() {
		SeatPosition lastSeat = new SeatPosition(numberOfRows - 1, numberOfCols - 1);
		char lastCol;
		lastCol = lastSeat.getCol();

		return lastCol;
	}

	public Seat getSeat(int row, char col) {
		Seat theSeat = new Seat(row, col);
		return theSeat;
	}

	public Seat getLeft(Seat seatPos) {
		if (seatPos.col > 0) {
			Seat leftSeat = seats[seatPos.row][seatPos.col - 1];

			if (leftSeat.reserved == true || leftSeat.col == 0) {
				return null;
			} else {
				return leftSeat;
			}
		} else {
			return null;
		}
	}

	public Seat getRight(Seat seatPos) {
		if (seatPos.col < numberOfRows - 1) {
			Seat rightSeat = seats[seatPos.row][seatPos.col + 1];

			if (rightSeat.reserved == true || rightSeat.col == numberOfCols - 1) {
				return null;
			}

			else {
				return rightSeat;
			}
		} else {
			return null;
		}
	}

	/**
	 * This Method takes in a Seat Array And Iterates through the 2D Array The
	 * Method returns a Seat Location The Method Queries the Economy Class If The
	 * Seat Doesn't Match then any Economy Seat Is Picked If All Seats Are Booked
	 * Then Null Is Returned
	 * 
	 * @param type
	 * @return
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public Seat queryAvailableEconomyClass(SeatType type) {

		for (int x = firstClassRow; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				if (this.seats[x][y].seatType == type && this.seats[x][y].firstClass == false
						&& this.seats[x][y].reserved == false) {
					this.seats[x][y].reserved = true;
					return this.seats[x][y];
				}

			}
		}

		for (int x = firstClassRow; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				if (this.seats[x][y].firstClass == false && this.seats[x][y].reserved == false) {
					this.seats[x][y].reserved = true;
					return this.seats[x][y];
				}
			}
		}

		return null;
	}

	/**
	 * This Method takes in a Seat Array And Iterates through the 2D Array The
	 * Method returns a Seat Location The Method Queries the First Class If The Seat
	 * Doesn't Match then any Economy Seat Is Picked If All Seats Are Booked Then
	 * Null Is Returned
	 * 
	 * @param type
	 * @return
	 * 
	 * @author Hamish Maritz, 1383425
	 */

	public Seat queryAvailableFirstClass(SeatType type) {
		for (int x = 0; x < firstClassRow; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				if (this.seats[x][y].seatType == type && this.seats[x][y].firstClass == true
						&& this.seats[x][y].reserved == false) {
					this.seats[x][y].reserved = true;
					return this.seats[x][y];
				}
			}
		}

		for (int x = 0; x < firstClassRow; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				if (this.seats[x][y].firstClass == true && this.seats[x][y].reserved == false) {
					this.seats[x][y].reserved = true;
					return this.seats[x][y];
				}
			}
		}
		return null;
	}

	// Might Need Fixing
	@Override
	public String toString() {
		{
			String result = "";
			for (Seat[] rows : seats) {
				for (Seat s : rows) {
					result += s + " ";
				}
				result += "\n";
			}
			return result;
		}
	}

}
