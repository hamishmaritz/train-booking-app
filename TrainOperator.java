package assignment2;

/**
 * TrainOperator is the Abstract Class in which the Train Operators details are
 * stored It also contains the public abstract objects of bookFirstClass and
 * bookEconomyClass
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public abstract class TrainOperator {

	// Instances/Variables
	protected String trainOperatorName;

	// Get And Set
	public String getTrainOperatorName() {
		return trainOperatorName;
	}

	public void setTrainOperatorName(String trainOperatorName) {
		this.trainOperatorName = trainOperatorName;
	}

	public TrainOperator(String trainOperatorName) {
		setTrainOperatorName(trainOperatorName);
	}

	// Abstract
	public abstract Seat bookFirstClass(TrainJourney journey, SeatType type);

	public abstract Seat bookEconomyClass(TrainJourney journey, SeatType type);

	@Override

	public String toString() {
		String desc;

		desc = ("Welcome to the " + trainOperatorName + " Booking System Which Journey Would You Like To Book on?");
		return desc;
	}

}
