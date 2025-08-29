public class SkiTrip extends Trip{

    private boolean skisRented;
    private boolean liftCardRented;

    public SkiTrip(String country, int duration, int attendees, double price, boolean skisRented, boolean liftCardRented) {
        super(country, duration, attendees, price);
        this.skisRented = skisRented;
        this.liftCardRented = liftCardRented;
    }

    public boolean isSkisRented(){
        return skisRented;
    }

    public boolean isLiftCardRented(){
        return liftCardRented;
    }

    public void setSkisRented(boolean skisRented){
        this.skisRented = skisRented;
    }

    public void setLiftCardRented(boolean liftCardRented){
        this.liftCardRented = liftCardRented;
    }

    @Override
    public String toString(){
        return "\nSki trip overview:\n" + "Country: " + country + "\nDuration: " + duration
                + " days" + "\nNumber of attendees: " + attendees + "\nPrice: " + price
                + "\nSkis rented: " + skisRented + "\nLift card rented: " + liftCardRented;
    }

}
