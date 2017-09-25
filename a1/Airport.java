
import java.util.ArrayList;

public class Airport {
	private String name;
	private ArrayList<Flight> flights;

	public Airport(String name) {
		this.name = name;
		this.flights = new ArrayList<>();
	}

	public boolean wasVisitedBy(Flight flight) {
		return this.flights.contains(flight);
	}

	public boolean onSameFlight(Airport other){
		for (int i = 0; i< this.flights.size(); i++ ){
			if (other.flights.contains(this.flights.get(i))){
				return true;
			}
		}return false;
	}

	public void addFlight(Flight flight) {
		this.flights.add(flight);
		if (!(flight.getAirports().contains(this))){
			flight.addAirport(this);
		}
	}

	public boolean equals(Object otherAirport) {
		if (otherAirport instanceof Airport) {
			Airport otherAirport2 = (Airport)otherAirport;
			if (this.flights.size() != otherAirport2.flights.size()){
				return false;
			}
			if (this.flights.size() == 0){
				return this.getName().equals(otherAirport2.getName());
			}
			else{
				boolean bool = false;
				for (int i = 0; i < this.flights.size(); i++){
					bool =  otherAirport2.wasVisitedBy(this.flights.get(i));
				}
				return bool;
			}
		}
		return false;
	}

	public String getName(){
		return this.name;
	}

	public String toString() {

		if (this.flights.size() == 0){
			return this.getName() + " ()";
		}
		else{
			String flights = "";
			for (int i = 0; i < this.flights.size(); i++) {
				flights += this.flights.get(i).getName() + ", ";
			}
			return this.getName() + " (" + flights.substring(0, flights.length()-2) + ")";}
	}


}
