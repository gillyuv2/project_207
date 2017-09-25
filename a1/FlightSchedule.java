import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class FlightSchedule {

	public static void main(String[] args) throws IOException {

		File flightFile = new File("FlightList.txt");
		Scanner scanner = new Scanner(flightFile);
		ArrayList<Airport> airportsList = new ArrayList<>();
		ArrayList<String> airportsList2 = new ArrayList<>();
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));

		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			String[] fileLine = line.split("\\|");
			String[] flightDetail = fileLine[0].split(" ");
			Flight flight = new Flight(flightDetail[0].trim(), flightDetail[1].trim());
			for (int i=1; i < fileLine.length; i++) {
				Airport tempAirport = new Airport(fileLine[i].trim());
				if (!(airportsList2.contains(fileLine[i].trim()))){
					airportsList2.add(fileLine[i].trim());
					airportsList.add(tempAirport);
					tempAirport.addFlight(flight);
				}
				else{
					for (int j=0; j < airportsList.size(); j++){
						if (airportsList.get(j).getName().equals(fileLine[i].trim())){
							airportsList.get(j).addFlight(flight);
						}
					}
				}
			}
		}

		System.out.println("Enter the name of an airport:");
		String input = kbd.readLine().trim();

		while (!input.equals("exit")) { // Don't use != because compares memory addresses.
			boolean hasAirport = false;
			Airport outputAirport = null;
			for (int i =0; i < airportsList.size(); i ++) {
				if (airportsList.get(i).getName().equals(input)) {
					hasAirport = true;
					outputAirport = airportsList.get(i);
					break ;
				}
			}

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