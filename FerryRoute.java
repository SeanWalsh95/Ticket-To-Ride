import java.util.*;

/**
 * Write a description of class FerryRoute here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FerryRoute extends Route {
	// number of locomotives required to take the route
	int locomotiveRequirement;

	/**
	 * Constructor that takes a string deliminated with the given deliminator to
	 * initlize the values of this class in the following format (example uses
	 * ";" as a deliminator) cityA;cityB;locomotiveRequiremnet;size
	 */
	public FerryRoute(String s, String delim) {
		// the following block of code breaks a single string into the
		// parameter values for the class storing them in local strings to be
		// parsed into values for the class
		StringTokenizer st = new StringTokenizer(s, delim);
		String cityAStr = st.nextToken();
		String cityBStr = st.nextToken();
		String locomotiveRequiremnetStr = st.nextToken();
		String trainRequirementStr = st.nextToken();

		// identifying message for this class
		String classMsg = "(ERR CONST FerryRoute)";

		// attempts to parse the values from the given string into the classes
		// values
		// if a parse fails it is caught and an error is printed
		try {
			cityA = CityName.valueOf(cityAStr.replace(" ", ""));
		} catch (Exception e) {
			System.err.println(classMsg + cityAStr + ": Invalid City name");
		}
		try {
			cityB = CityName.valueOf(cityBStr.replace(" ", ""));
		} catch (Exception e) {
			System.err.println(classMsg + cityBStr + ": Invalid City name");
		}
		try {
			trainRequirement = Integer.parseInt(trainRequirementStr);
		} catch (Exception e) {
			System.err.println(classMsg + locomotiveRequiremnetStr
					+ ": Cannot parse locomotiveRequiremnet to int");
		}
		try {
			trainRequirement = Integer.parseInt(trainRequirementStr);
		} catch (Exception e) {
			System.err.println(classMsg + trainRequirementStr
					+ ": Cannot parse trainRequirement to int");
		}
		// ferry routes do not have a color so its color value is always neutral
		color = RouteColor.NEUTRAL;
		// sets the ownerID to its default value of -1 awaiting a player to
		// capture it
		ownerID = -1;
	}

	public String toString() {
		return "FerryRoute: " + cityA + "\t" + cityB + "\t" + color + "\t"
				+ trainRequirement + "\t" + locomotiveRequirement;
	}
}
