package assignment2;

/**
 * TrainWay is the SubClass of the Abstract Class TrainOperator The Class
 * reserves the Seating Arrangement for the TrainWay Booking System
 * This Class Either Books In First Or Economy And Contains The 
 * Methods in which the booking policies adhere to
 * 
 * @author Hamish Maritz, 1383425
 *
 */
public class TrainWay extends TrainOperator {

	/**
	 * TrainWay Calls the Super "TrainWay"
	 * 
	 * @Author Hamish Maritz, 1383425
	 */
	public TrainWay() {
		super("TrainWay");
	}

	/**
	 * This Method Books A Seat In The First Class Finds a Seat In First Class That
	 * Matches User Request If No Seat Is Found Then Book Any In First Class If No
	 * Seat Is Found Then Book A Window Seat In Economy If No Seats Then A Booking
	 * Cannot Be Done
	 * 
	 * @author Hamish Maritz, 1383425
	 *
	 */

	public Seat bookFirstClass(TrainJourney journey, SeatType type) {
		Seat attemptBooking = journey.floorGrid.queryAvailableFirstClass(type);

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

			// Books A Seat In Economy, Window
			Seat findSeat;
			Seat returnSeat;

			for (int x = journey.floorGrid.firstClassRow; x < journey.floorGrid.numberOfRows; x++) {
				for (int y = 0; y < journey.floorGrid.numberOfCols; x++) {
					findSeat = journey.floorGrid.seats[x][y];

					if (findSeat.seatType == SeatType.WINDOW && findSeat.reserved == false) {
						returnSeat = findSeat;

						returnSeat.reserved = true;
						return returnSeat;
					}

				}
			}

		}
		return null;
	}

	/**
	 * This Method Books A Seat In The Economy Class Find A Seat In Economy Class If
	 * No Seat Is Found Then Find And Book Any Window Seat In First Class If No
	 * Seats Found Then Return Null
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

		// Book A Window Seat In First Class
		Seat findSeat;
		Seat returnSeat;
		for (int x = journey.floorGrid.firstClassRow; x < journey.floorGrid.numberOfRows; x++) {
			for (int y = 0; y < journey.floorGrid.numberOfCols; x++) {
				findSeat = journey.floorGrid.seats[x][y];

				if (findSeat.seatType == SeatType.WINDOW && findSeat.firstClass == false) {
					returnSeat = findSeat;

					returnSeat.firstClass = true;
					return returnSeat;
				}

			}
		}

		return null;

	}

	@Override

	public String toString() {
		return super.toString();
	}
}
