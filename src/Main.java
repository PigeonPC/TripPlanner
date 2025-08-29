import java.util.*;

public class Main {
    /*
    1. Create a Java project called TripPlanner in IntelliJ.
    2. Create a class called Trip with at least 4 fields, ex. country, duration etc.
    3. Create two subclasses to the Trip class called SkiTrip and BeachTrip.
       Each subclass should have some encapsulated fields of their own.
    4. Create a menu with the following options:
       - Create trip
       - List trip
       and make the methods for this functionality, (put the created trips in an ArrayList).
       Make it nice and working.
    5. Create a local Git Repository,
    6. Add version control to your code/project, and commit your code to your local repository.
    7. Share the project on GitHub
    8. Add a new method to your code that gives the user the option to find and alter a made trip.
    9. Push your changes to GitHub.
    */

    private static ArrayList<Trip> trips = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        menu(scanner);

        scanner.close();

    }

    public static void menu(Scanner scanner){
        while (true){
            System.out.println("\n======= TRIP PLANNER =======");
            System.out.println("1. Create Trip");
            System.out.println("2. List trip");
            System.out.println("3. Edit trip [Virker ikke!]");
            System.out.println("4. Exit");

            if (scanner.hasNextInt()){
                int choice = scanner.nextInt();
                scanner.nextLine(); //tømmer efterladt newLine?? right?

                switch(choice) {
                    case 1:
                        createTrip(scanner);
                        break;
                    case 2:
                        listTrip();
                        break;
                    case 3:
                        //editTrip(scanner);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("You have to pick a number between 1 and 4\n");
                        break;
                }
            } else {
                System.out.println("That is not a number! Try again.\n");
                scanner.next(); //Ryder forkert input
            }
        }
    }


    public static void createTrip(Scanner scanner){
        System.out.println("\nFirst, what country will you be travelling to?");
        String country = scanner.nextLine();

        int duration;
        while (true){
            System.out.println("\nHow many days will you be travelling?");
            if (scanner.hasNextInt()){
                duration = scanner.nextInt();
                scanner.nextLine(); //Rydder newline, men skal kun bruges efter et tal ikke string.
                break; //ud af loop igen.
            } else {
                System.out.println("That's not a number, try again!");
                scanner.next(); //Rydder det ugyldige input.
            }
        }

        int attendees;
        while (true){
            System.out.println("\nHow many people will be travelling?");
            if (scanner.hasNextInt()){
                attendees = scanner.nextInt();
                scanner.nextLine(); //Rydder newline, men skal kun bruges efter et tal ikke string.
                break; //ud af loop igen.
            } else {
                System.out.println("That's not a number, try again!");
                scanner.next(); //Rydder det ugyldige input.
            }
        }

        double price;
        while (true){
            System.out.println("\nWhat is the price of the trip? ex. 12,34");
            if (scanner.hasNextDouble()){
                price = scanner.nextDouble();
                scanner.nextLine(); //Rydder newline, men skal kun bruges efter et tal ikke string.
                break; //ud af loop igen.
            } else {
                System.out.println("That's not the correct number, try again!");
                scanner.next(); //Rydder det ugyldige input.
            }
        }

        int tripChoice = 0;
        while (tripChoice < 1 || tripChoice >3){
            System.out.println("\nWhat kind of trip will you be going on?");
            System.out.println("1. Normal trip");
            System.out.println("2. Ski trip");
            System.out.println("3. Beach trip");

            if (scanner.hasNextInt()){
                tripChoice = scanner.nextInt();
                scanner.nextLine(); //tømmer efterladt newLine?? right?

                switch(tripChoice){
                    case 1: //Normal trip
                        Trip trip = new Trip(country, duration, attendees, price);
                        System.out.println(trip);
                        trips.add(trip);

                        break;

                    case 2: //Ski trip
                        boolean skisRented = false;
                        skisRented = skisRented(scanner);

                        boolean liftCardRented = false;
                        liftCardRented = liftCardRented(scanner);

                        SkiTrip skiTrip = new SkiTrip(country, duration, attendees, price, skisRented, liftCardRented);
                        System.out.println(skiTrip);
                        trips.add(skiTrip);

                        break;

                    case 3: //Beach trip
                        int degreesCelsius = degreesCelsius(scanner);

                        boolean safeToSwim = safeToSwim(scanner);

                        BeachTrip beachTrip = new BeachTrip(country, duration, attendees, price, degreesCelsius, safeToSwim);
                        System.out.println(beachTrip);
                        trips.add(beachTrip);

                        break;

                    default:
                        System.out.println("You have to pick a number between 1 and 3.\n");
                        break;
                }
            } else {
                System.out.println("That is not a number! Try again.\n");
                scanner.next(); //Ryder forkert input
            }
        }

    }


    //Jeg burde have oprettet én metode, der returnerede true/false boolean på et yes/no svar,
    //og så genbruge metoden til både skisRented, liftCardRented og safeToSwim i stedet for at have tre unikke versioner
    public static boolean skisRented(Scanner scanner) {
        boolean skisRented;
        while (true) {
            System.out.println("\nHave the skis been rented?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            if (scanner.hasNextInt()) {
                int skiChoice = scanner.nextInt();
                scanner.nextLine();

                switch (skiChoice) {
                    case 1:
                        skisRented = true;
                        break;
                    case 2:
                        skisRented = false;
                        break;
                    default:
                        System.out.println("You must choose either 1 or 2.");
                        continue; //Hoppe tilbagge til while loop og spørger igen
                }
                break; //bryder ud af while loop
            } else {
                System.out.println("That's not a number, try again!");
                scanner.next();
            }
        }
        return skisRented;
    }

    public static boolean liftCardRented(Scanner scanner){
        boolean liftCardRented;
        while (true) {
            System.out.println("\nDo you have a lift card?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            if (scanner.hasNextInt()){
                int liftChoice = scanner.nextInt();
                scanner.nextLine();

                switch (liftChoice) {
                    case 1:
                        liftCardRented = true;
                        break;
                    case 2:
                        liftCardRented = false;
                        break;
                    default:
                        System.out.println("You must choose either 1 or 2.");
                        continue; //Hoppe tilbagge til while loop og spørger igen
                }
                break; //bryder ud af loop
            } else {
                System.out.println("That's not a number, try again!");
                scanner.next();
            }
        }
        return liftCardRented;
    }

    public static int degreesCelsius(Scanner scanner) {
        int degreesCelsius;
        while (true) {
            System.out.println("\nHow many degrees Celsius will it be at the beach??");
            if (scanner.hasNextInt()) {
                degreesCelsius = scanner.nextInt();
                scanner.nextLine(); //Rydder newline, men skal kun bruges efter et tal ikke string.
                break; //ud af loop igen.
            } else {
                System.out.println("That's not a temperature, try again!");
                scanner.next(); //Rydder det ugyldige input.
            }
        }
        return degreesCelsius;
    }

    public static boolean safeToSwim(Scanner scanner){
        boolean safeToSwim;
        while (true) {
            System.out.println("\nIs it safe to swim at the beach?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            if (scanner.hasNextInt()){
                int swimChoice = scanner.nextInt();
                scanner.nextLine();

                switch (swimChoice) {
                    case 1:
                        safeToSwim = true;
                        break;
                    case 2:
                        safeToSwim = false;
                        break;
                    default:
                        System.out.println("You must choose either 1 or 2.");
                        continue; //Hoppe tilbagge til while loop og spørger igen
                }
                break; //bryder ud af loop
            } else {
                System.out.println("That's not a number, try again!");
                scanner.next();
            }
        }
        return safeToSwim;
    }


    public static void listTrip() {
        System.out.println("\n======= TRIPS =======");
        if (trips.isEmpty()){
            System.out.println("You have no trips yet.");
            return;
        }

        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }



}
