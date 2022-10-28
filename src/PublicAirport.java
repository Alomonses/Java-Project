public class PublicAirport extends Airport {
    private double subvencion;

    public PublicAirport(String name, String city, String country) {
        super(name, city, country);
    }

    public PublicAirport(double subvencion, String nombre, String city, String country, Company c[], String e[]) {
        super(nombre, city, country, c);
        this.subvencion = subvencion;
    }

    public PublicAirport(double subvencion, String name, String city, String country) {
        super(name, city, country);
        this.subvencion = subvencion;
    }

    // Getter
    public double getSubvencion() {
        return this.subvencion;
    }
}
