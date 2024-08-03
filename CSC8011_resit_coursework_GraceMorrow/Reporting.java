import java.util.ArrayList;
import java.util.List;
/**
* This class showcases districts and incidents represented within a reporting system that correlated the class ReportingIO
* */
public class Reporting {
   //Shows List of the Districts
    private List<District> districts;
/** Constructor that produces the list of districts**/
    public Reporting() {
        districts = new ArrayList<>();
    }
    /**
     * @param district the district to add to list
     * */
     public void addDistrict(District district) {
        districts.add(district);
     }
/**
 * Method that gets the name of a district
* @param name the name is grabbed of the district
 * @return a specific nameof a district or not found if empty or cannot locate
* */
     public District getDistrictByName(String name) {
        District d = new District();
        for (District district : districts) {
            if (district.name().equalsIgnoreCase(name))
                d = district;
        }
        return d;
     }

    /**
     * This method helps get the largest valued incident in a particular district
     * @return the district with the largest valued incident
     * */
    public District getDistrictWithLargestValueIncident() {
        District currentDistrict = districts.getFirst();

        for (District district : districts) {
            Incident highestIncident = currentDistrict.getHighestValueIncident();
            Incident temp = district.getHighestValueIncident();
            if (temp.getValue() > highestIncident.getValue())
                currentDistrict = district;
        }

        return currentDistrict;

    }
    /**
     * This method searches for the largest value incident recorded all over the districts in total*
     * @return the largest valued incident ever recorded
     * */
    public Incident getLargestValueIncidentEverRecorded() {
        District highestValueDistrict = getDistrictWithLargestValueIncident();
        return highestValueDistrict.getHighestValueIncident();
    }
    /**
     * This method to get incidents with a value greater than a specified value
     * @param value the minimum value for incidents will be included in the result
     * @return list of the incidents with a value greater than a specified value
     * */
    public List<Incident> getIncidentsWithValueGreatThan(double value) {
        List<Incident> result = new ArrayList<>();
        for (District district : districts) {
            result.addAll(district.getIncidentsWithValueGreaterThan(value));
        }
// This returns the list of incidents
        return result;
    }

}





