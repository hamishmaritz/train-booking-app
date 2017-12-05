package assignment2;

/**
 * ChooChoo is the SubClass of the Abstract Class TrainOperator The Class
 * reserves the Seating Arrangement for the ChooChoo Booking System This Class
 * Either Books In First Or Economy And Contains The Methods in which the
 * booking policies adhere to.
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public class ChooChoo extends TrainOperator {

	/**
	 * ChooChoo Calls the Super "ChooChoo"
	 * 
	 * @Author Hamish Maritz, 1383425
	 */
	public ChooChoo() {
		super("ChooChoo");
	}

	/**
	 * The Method finds a seat that matches the requested seat type If no such first
	 * class seat with the matching seat type Then book an entire row in economy If
	 * no seats can be booked then return null
	 * 
	 * @author Hamish Maritz, 1383425
	 *
	 */
	public Seat bookFirstClass(TrainJourney journey, SeatType type) {
		Seat attemptBooking = journey.floorGrid.queryAvailableFirstClass(type);
		Seat findSeat;
		Seat left;
		Seat right;
		Seat returnedSeat;
		if (attemptBooking != null) {
			return attemptBooking;
		}

		for (int x = journey.floorGrid.firstClassRow; x < journey.floorGrid.numberOfRows; x++) {
			for (int y = 0; y < journey.floorGrid.numberOfCols; y++) {
				findSeat = journey.floorGrid.seats[x][y];
				
				if (findSeat.seatType == SeatType.MIDDLE && findSeat.reserved == false) {
					// LEFT
					if (journey.floorGrid.getLeft(findSeat) != null) {
						left = journey.floorGrid.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
					
					if (journey.floorGrid.getRight(findSeat) != null) {
						right = journey.floorGrid.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

				}
				
				if (findSeat.seatType == SeatType.WINDOW && findSeat.reserved == false) {
					if (journey.floorGrid.getLeft(findSeat) != null) {
						left = journey.floorGrid.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

					if (journey.floorGrid.getRight(findSeat) != null) {
						right = journey.floorGrid.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}
				}

				if (findSeat.seatType == SeatType.AISLE && findSeat.reserved == false) {
					if (journey.floorGrid.getLeft(findSeat) != null) {
						left = journey.floorGrid.getLeft(findSeat);
						returnedSeat = findSeat;
						left.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

					if (journey.floorGrid.getRight(findSeat) != null) {
						right = journey.floorGrid.getRight(findSeat);
						returnedSeat = findSeat;
						right.reserved = true;
						returnedSeat.reserved = true;
						return returnedSeat;
					}

				}
			}

		}

		return null;
	}

	/**
	 * This method books a seat in the Economy Class If there are no seats that
	 * match any of the requirements then a booking cannot be made
	 * 
	 * @author Hamish Maritz, 1383425
	 */
	public Seat bookEconomyClass(TrainJourney journey, SeatType type) {
		Seat attemptBooking = journey.floorGrid.queryAvailableEconomyClass(type);

		if (attemptBooking != null) {
			return attemptBooking;
		}

		else {
			for (int x = journey.floorGrid.firstClassRow; x < journey.floorGrid.numberOfRows; x++) {
				for (int y = 0; y < journey.floorGrid.numberOfCols; y++) {
					if (journey.floorGrid.seats[x][y].reserved == false) {
						return journey.floorGrid.seats[x][y];
					}
				}
			}
		}
		return null;

	}

	public String toString() {
		return super.toString();
	}

}
