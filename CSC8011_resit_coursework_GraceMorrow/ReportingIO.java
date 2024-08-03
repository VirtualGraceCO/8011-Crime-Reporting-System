
import java.util.List;
import java.util.Scanner;
/** The ReportingIO class holds the input and output of the commands for the reporting system*/
public class ReportingIO {

    /** This method starts the program/application**/
    public static void main(String[] args) {
        Reporting app = new Reporting();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the CrimeReporting System");

        /*Allows the system to loop continuously until the user decides to exit the system */
        while (true) {
            printMenu();
            String userResponse = scanner.next();

            // switch statements that allows user input
            switch (userResponse) {
                case "1": //1. Enter the district data (name & area)
                    enterDistrictData(scanner, app);
                    break;
                case "2": //2. Enter the incident data (value,postcode,date month& year0
                    enterIncidentData(scanner, app);
                    break;
                case "3"://3. Prints out the reporting statistics(highest value incident,highest incident ever reported, all incidents with value greater than given amount)
                    printStatistics(scanner, app);
                    break;
                case "4":// or exit
                    System.exit(0);
                    break;
                default: // Invaild option
                    //prints out Invalid,Please try again
                    System.out.println("Invalid, Please try again");
            }

        }
    }


    /** (console)This method prints out all the menu options
     * **/
    private static void printMenu() {
        System.out.println("Menu: Please choose one of the options below");
        System.out.println("1. Enter District data");
        System.out.println("2. Enter Incident data");
        System.out.println("3. Provide reporting statistics");
        System.out.println("4. Exit");
    }

    /** This method helps with entering the district data
     *@param scanner scanner object allows the user input to be read
     * @param reporting reporting object stores the districts data*/
    private static void enterDistrictData(Scanner scanner, Reporting reporting) {
        System.out.println("Enter the district name here:");
        String districtName = scanner.next();
        System.out.println("Enter the district area (in square kilometres");
        double districtArea = scanner.nextDouble();
        District district = new District(districtName, districtArea);
        reporting.addDistrict(district);
        System.out.println("The District data has been entered successfully ");

    }


    /** Method that helps to enter incident data
     *@param scanner scanner object allows the user input to be read
     * @param reporting reporting object stores the incidents data*/
    private static void enterIncidentData(Scanner scanner, Reporting reporting) {
        System.out.println("Enter the district name: ");
        String districtName = scanner.next();
        District district = reporting.getDistrictByName(districtName);
        System.out.println("Enter incident value here:");
        double value = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter postcode of the incident here ");
        String postcode = scanner.nextLine();
        System.out.println("Enter month of the incident here ");
        int month = scanner.nextInt();
        System.out.println("Enter year of the incident here ");
        int year = scanner.nextInt();

        Incident newIncident = new Incident(value, postcode, month, year);
        if (district != null) {
            district.addIncident(newIncident);
        } else {
            System.out.println("The District is not found, try another name");
        }
    }
    /** Method prints out the statistics of to the console and menu options.
     *@param scanner scanner object allows the user input to be read
     * @param reporting reporting object to get the statistics*/
    private static void printStatistics(Scanner scanner, Reporting reporting) {
        System.out.println("Select an option below: ");
        System.out.println("1. Highest Value Incident in a district");
        System.out.println("2. Highest  value ever recorded");
        System.out.println("3. Incidents with value greater then a given amount");

        String userResponse = scanner.next();

        // switch statements that allows user input
        switch (userResponse) {
            case "1":
                System.out.println("Please Enter the district name: ");
                String name = scanner.next();
                District district = reporting.getDistrictByName(name);
                if (district == null) {
                    System.out.println("Wrong input, please try again");
                } else {
                    System.out.println("The highest incident: ");
                    System.out.println(district.getHighestValueIncident());
                }
                break;
            case "2":
                System.out.println("The highest values incident ever recorded: ");
                System.out.println(reporting.getLargestValueIncidentEverRecorded());
                break;
            case "3":
                System.out.println("Enter the amount: ");
                double amount = scanner.nextDouble();

                List<Incident> incidentList = reporting.getIncidentsWithValueGreatThan(amount);
                if (incidentList.isEmpty())
                    System.out.println("No incident with value greater than " + amount);
                else {
                    System.out.println("Incidents with value greater than " + amount);
                    for (Incident incident : incidentList)
                        System.out.println(incident);
                }
                break;
            default:
                System.out.println("Wrong option chosen");

        }
        scanner.nextLine();

    }
}






