/** A Flight Schedule class which takes in name of an Airport in Standard format and gives the flight schedule.
 *
 *
 */
// import important modules
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class FlightSchedule {

	public static void main(String[] args) throws IOException { //Start the main function

		File flightFile = new File("FlightList.txt"); // A flight list file to be read.
		Scanner scanner = new Scanner(flightFile); // Scanner object to scan the file
		ArrayList<Airport> airportsList = new ArrayList<>(); // An array list of Airport Objects.
		ArrayList<String> airportsList2 = new ArrayList<>(); // An array list to book keep the name of airports
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in)); // buffer reader to read the file

		while (scanner.hasNextLine()){ // a while loop that runs till last line of the given file to be read
			String line = scanner.nextLine();
			String[] fileLine = line.split("\\|");
			String[] flightDetail = fileLine[0].split(" ");
			Flight flight = new Flight(flightDetail[0].trim(), flightDetail[1].trim()); // Make flight object
			for (int i=1; i < fileLine.length; i++) {
				Airport tempAirport = new Airport(fileLine[i].trim());
				if (!(airportsList2.contains(fileLine[i].trim()))){
					airportsList2.add(fileLine[i].trim());
					airportsList.add(tempAirport);
					tempAirport.addFlight(flight);
				} // Check if the airport is already in the list then find it and add a flight to the airport.
				else{
					for (int j=0; j < airportsList.size(); j++){
						if (airportsList.get(j).getName().equals(fileLine[i].trim())){
							airportsList.get(j).addFlight(flight);
						}
					}
				}
			}
		}
		// User interface to get input of name of airports.
		System.out.println("Enter the name of an airport:");
		String input = kbd.readLine().trim(); // trim to avoid the white space errors in the input.

		while (!input.equals("exit")) { // Don't use != because compares memory addresses.
			boolean hasAirport = false; // A boolean to keep check on the output later.
			Airport outputAirport = null;
			for (int i =0; i < airportsList.size(); i ++) {
				if (airportsList.get(i).getName().equals(input)) {
					hasAirport = true;
					outputAirport = airportsList.get(i);
					break ;
				}
			}
			// check if the input matches the airport data set
			if (hasAirport){
				System.out.println(outputAirport);
			}
			else {
				System.out.println("Enter a valid name!!" + System.lineSeparator() + "Enter the name of an Airport:");
			}
			input = kbd.readLine();
		}
	}
}