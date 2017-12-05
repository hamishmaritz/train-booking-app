package assignment2;

/**
 * This Class contains the TrainJourney Storing the Start City, End Time,
 * Departure, Journey Number and storing the floorGrid Object Get and Set
 * Methods
 * 
 * @author Hamish Maritz, 1383425
 *
 */

public class TrainJourney {

	// Default Variables
	protected String startcity;
	protected String endcity;
	protected String departuretime;
	protected String journeynumber;
	protected FloorGrid floorGrid;

	// Floor Grid Object

	// Constructor
	public TrainJourney() {
		startcity = "";
		endcity = "";
		departuretime = "";
		journeynumber = "";
	}

	public TrainJourney(String startcity, String endcity, String departuretime, String journeynumber) {
		this.startcity = startcity;
		this.endcity = endcity;
		this.departuretime = departuretime;
		this.journeynumber = journeynumber;
	}

	public String getStartCity() {
		return startcity;
	}

	public String getEndCity() {
		return endcity;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public String getJourneynumber() {
		return journeynumber;
	}

	public FloorGrid getFloorGrid() {
		return this.floorGrid;
	}

	@Override

	public String toString() {
		return journeynumber + " from: " + startcity + " to: " + endcity + " at: " + departuretime;
	}
}
