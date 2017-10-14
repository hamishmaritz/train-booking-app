package assignment2;

/**
 * This Class Holds the seatPosition and where the Seat Is It also contains a
 * Switch which gives the GRID it's Char based Text Location
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public class SeatPosition {

	private int row;
	private char col;

	public SeatPosition(int row, int col) {
		setRow(row);
		setCol(col);
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row + 1;
	}

	public char getCol() {
		return this.col;

	}

	/**
	 * This Method sets the Columns up with it's char based identifiers
	 * 
	 * @author Hamish Maritz, 1383425
	 * @param col
	 */
	public void setCol(int col) {
		switch (col) {
		case 0:
			this.col = 'A';
			break;
		case 1:
			this.col = 'B';
			break;
		case 2:
			this.col = 'C';
			break;
		case 3:
			this.col = 'D';
			break;
		case 4:
			this.col = 'E';
			break;
		case 5:
			this.col = 'F';
			break;
		case 6:
			this.col = 'G';
		}
	}

	@Override

	public String toString() {
		return "" + row + col;
	}

}
