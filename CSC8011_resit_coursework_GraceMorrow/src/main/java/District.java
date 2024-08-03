import java.util.ArrayList;
import java.util.List;
/**
* District class holds information of the district being the name, area, and the list of all incidents
* */
public class District {
    /**The private and appropriate fields are stored here that represent name, area, and a list of incidents in the district**/
    private String name;
    private double area;
    private List<Incident> incidents;
// A default constructor
    public District() {

    }

    /** This constructor initializes a district with a name and area, and create and empty list of incidents**/
    public District(String name, double area) {
        this.name = name;
        this.area = area;
        this.incidents = new ArrayList<>();
    }

    /** Getter Methods for name,area, and incident list and returns**/
    public String name() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }
/** This private method gets a list of all the incidents that happened  in a specific year.
 * @param year the year allows incidents to be arranged and filtered
 * @return a list of all the incidents that happened  in a specific year **/
    private List<Incident> getIncidentsByYear(int year) {
        List<Incident> incidentList = new ArrayList<>();
        for (Incident incident : incidents) {
            if (incident.getYear() == year)
                incidentList.add(incident);
        }

        return incidentList;
    }

    /** Setter Method adds incidents to the list of incidents of the districts
     *@param incident adds to the list **/
    public void addIncident(Incident incident) {
        incidents.add(incident);
    }

    /**This method finds and returns the incident with the highest value in a specific year**/
    public Incident getHighestValueIncident(int year) {
        List<Incident> incidentsByYear = getIncidentsByYear(year);
        Incident highestValueIncident = incidentsByYear.getFirst();
        for (Incident incident : incidentsByYear) {
            if (incident.getValue() > highestValueIncident.getValue())
                highestValueIncident = incident;
        }
        return highestValueIncident;
    }
/** This Method to finds and return the incident with the highest value across all years.**/
    public Incident getHighestValueIncident() {
        Incident highestValueIncident = incidents.getFirst();
        for (Incident incident : incidents) {
            if (incident.getValue() > highestValueIncident.getValue())
                highestValueIncident = incident;
        }

        return highestValueIncident;
    }

    /** This method calculate and return the average value of incidents in a specific year **/
    public double getAverageValueIncident(int year) {
        int sum = 0;
        int count = 0;
        double avgIncidentValue = 0.0;

        for (Incident incident : incidents) {
            if (incident.getYear() == year) {
                sum += incident.getValue();
                count++;
            }
        }
        if (count > 0) {
            avgIncidentValue = (double) sum / count;
        }
        return avgIncidentValue;
    }

    /**This method creates a list of incidents with a value greater than a specific value**/
    public List<Incident> getIncidentsWithValueGreaterThan(double value) {
        List<Incident> result = new ArrayList<>();
        for (Incident incident : incidents) {
            if (incident.getValue() > value) {
                result.add(incident);
            }
        }
        return result;
    }
}


