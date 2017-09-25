
import java.util.ArrayList;

public class Flight {
    private String name;
    private ArrayList<Airport> airports;
    private String date;

    public Flight(String name, String date) {
        this.name = name;
        this.date = date;
        this.airports = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String toString() {
        String nameDate = this.getName() +", " + this.getDate();
        if (this.airports.size() == 0){
            return nameDate ;
        }
        else{
            String flights = "";
            for (int i = 0; i < this.airports.size(); i++){
                flights += System.lineSeparator() + this.airports.get(i).getName();
            }
            return nameDate + flights;
        }

    }


    public void addAirport(Airport airport) {
        airports.add(airport);
        if (!airport.wasVisitedBy(this)) {
            airport.addFlight(this);
        }
    }


    public boolean equals(Flight other) {
        return this.getName().equals(other.getName()) &&
                this.getDate().equals(other.getDate());
    }

    public ArrayList getAirports() {
        return this.airports;
    }









}
