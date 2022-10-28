
public class Company {
    private String name;
    private Flight listFlights[] = new Flight[10];
    private int numFlight = 0;

    // Constructor
    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Flight v[]) {
        this.name = name;
        listFlights = v;
        numFlight = v.length;
    }

    public void insertFlight(Flight flight) {
        listFlights[numFlight] = flight;
        numFlight++;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getNumFlight() {
        return numFlight;
    }

    public Flight getFlight(int i) {
        return listFlights[i];
    }

    public Flight getFlight(String id) {
        boolean encontrado = false;
        int i = 0;
        Flight v = null;
        while ((!encontrado) && (i < listFlights.length)) {
            if (id.equals(listFlights[i].getidFlight())) {
                encontrado = true;
                v = listFlights[i];
            }
            i++;
        }
        return v;
    }

}
