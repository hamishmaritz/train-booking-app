package assignment2;

/**
 * The Class PetiteFloorGrid extends the Floor Grid and forms the Second Trains
 * Grid, The Class Has Pre-Defined Variables of Rows, Columns and First Class
 * Rows
 * 
 * @author Hamish Maritz, 1383425
 *
 */
public class PetiteFloorGrid extends FloorGrid {

	/**
	 * The PetiteFloorGrid Method holds the instance Variables And Using A For Loop
	 * Instantiates the Seat Object Filling Every Seat
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public PetiteFloorGrid() {
		this.numberOfRows = 10;
		this.numberOfCols = 7;
		this.firstClassRow = 4;
		this.seats = new Seat[numberOfRows][numberOfCols];

		for (int x = 0; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				// MIGHT NEED X, Y in Seat
				seats[x][y] = new Seat(x, y);
			}
		}
		initialiseFloorGrid();
	}

	/**
	 * This Method Populates the 2D Array And Determines if the Class is First Or
	 * Not First Class
	 * 
	 * @author Hamish Maritz
	 */

	public void initialiseFloorGrid() {

		for (int x = 0; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfCols; y++) {
				if (x < firstClassRow) {
					this.seats[x][y].firstClass = true;
				}

				else {
					this.seats[x][y].firstClass = false;
				}

				if (y == 0 || y == 6) {
					this.seats[x][y].seatType = SeatType.WINDOW;
				} else if (y == 1 || y == 2 || y == 4 || y == 5) {
					this.seats[x][y].seatType = SeatType.AISLE;
				} else if (y == 3) {
					this.seats[x][y].seatType = SeatType.MIDDLE;
				}

			}

		}

	}

	public String toString() {
		return ("   A      B      C      D      E      F      G\n" + super.toString());
	}
}
