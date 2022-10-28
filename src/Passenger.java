public class Passenger {
    private String name;
    private String passport;
    private String nationality;

    // Constructor
    public Passenger(String name, String passport, String nationality) {
        this.name = name;
        this.passport = passport;
        this.nationality = nationality;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getNationality() {
        return this.nationality;
    }

}