public class Incident {
    /**The private and appropriate fields are stored here of incident data**/
    private double value;
    private String postcode;
    private int month;
    private int year;

    //Appropriate constructor to establish the data
    public Incident(double value, String postcode, int month, int year) {
        /*Established fields and its preferred values*/
        this.value = value;
        this.postcode = postcode;
        this.month = month;
        this.year = year;
    }
    /** Method used here is called the Getter method that fetches all fields such as value, postcode, date(month & year) and also adds them all together to form string to strings**/
    public double getValue() {
        return value;
    }

    public String getPostcode() {
        return postcode;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return  year;
    }

    public String toString() {
        return postcode + ", " + value + ", " + month + ", " + year;
    }
}



