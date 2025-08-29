import java.util.Set;

public class Trip {

    protected String country;
    protected int duration;
    protected int attendees;
    protected double price;

    public Trip (String country, int duration, int attendees, double price){
        this.country = country;
        this.duration = duration;
        this.attendees = attendees;
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public int getDuration() {
        return duration;
    }

    public int getAttendees() {
        return attendees;
    }

    public double getPrice() {
        return price;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return "\nTrip overview:\n" + "Country: " + country + "\nDuration: " + duration + "\nNumber of attendees: " + attendees + "\nPrice: " + price;
    }
}
