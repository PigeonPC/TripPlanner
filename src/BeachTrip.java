public class BeachTrip extends Trip {

    private int degreesCelsius;
    private boolean safeToSwim;

    public BeachTrip (String country, int duration, int attendees, double price, int degreesCelsius, boolean safeToSwim) {
        super(country, duration, attendees, price);
        this.degreesCelsius = degreesCelsius;
        this.safeToSwim = safeToSwim;
    }


    public int getDegreesCelsius() {
        return degreesCelsius;
    }

    public boolean isSafeToSwim() {
        return safeToSwim;
    }

    public void setDegreesCelsius(int degreesCelsius) {
        this.degreesCelsius = degreesCelsius;
    }

    public void setSafeToSwim(boolean safeToSwim) {
        this.safeToSwim = safeToSwim;
    }

    @Override
    public String toString(){
        return "\nBeach trip overview:\n" + "Country: " + country + "\nDuration: " + duration
                + " days" + "\nNumber of attendees: " + attendees + "\nPrice: " + price
                + "\nDegrees Celsius: " + degreesCelsius + "°C" + "\nSafe to swim: " + safeToSwim;
    }

}
