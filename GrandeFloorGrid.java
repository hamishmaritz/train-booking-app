package assignment2;

/**
 * The Class GrandeFloorGrid extends the Floor Grid and forms the First Train
 * Grid, The Class Has Pre-Defined Variables of Rows, Columns and First Class
 * Rows
 * 
 * @author Hamish
 *
 */
public class GrandeFloorGrid extends FloorGrid {

	/**
	 * The GrandeFloorGrid Method holds the instance Variables And Using A For Loop
	 * Instantiates the Seat Object Filling Every Seat
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public GrandeFloorGrid() {
		numberOfRows = 12;
		numberOfCols = 9;
		firstClassRow = 6;

		this.seats = new Seat[numberOfRows][numberOfCols];

		for (int x = 0; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfCols; y++) {
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

				if (y == 0 || y == 8) {
					this.seats[x][y].seatType = SeatType.WINDOW;
				} else if (y == 2 || y == 3 || y == 5 || y == 6) {
					this.seats[x][y].seatType = SeatType.AISLE;
				} else if (y == 1 || y == 4 || y == 7) {
					this.seats[x][y].seatType = SeatType.MIDDLE;
				}

			}
		}

	}

	public String toString() {
		return ("   A      B      C      D      E      F      G      H      I\n" + super.toString());
	}

}
