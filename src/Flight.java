public class Flight {
    private String idFlight;
    private String origen;
    private String destiny;
    private double price;
    private int numMaxPassengers;
    private int numActualPassengers;

    private Passenger listPassengers[];

    // Constructor
    public Flight(String idFlight, String origen, String destiny, double price, int numMaxPassengers) {
        this.idFlight = idFlight;
        this.origen = origen;
        this.destiny = destiny;
        this.price = price;
        this.numMaxPassengers = numMaxPassengers;
        this.numActualPassengers = 0;
        this.listPassengers = new Passenger[numMaxPassengers];
    }

    public void insertPassenger(Passenger pasajero) {
        listPassengers[numActualPassengers] = pasajero;
        numActualPassengers++;
    }

    public String getidFlight() {
        return this.idFlight;
    }

    public String getOrigen() {
        return this.origen;
    }

    public String getDestiny() {
        return this.destiny;
    }

    public double getPrice() {
        return this.price;
    }

    public int getnumMaxPassengers() {
        return this.numMaxPassengers;
    }

    public int getnumActualPassengers() {
        return this.numActualPassengers;
    }

    public Passenger getPassenger(int i) {
        return listPassengers[i];
    }

    public Passenger getPassenger(String passport) {
        boolean find = false;
        int i = 0;
        Passenger pas = null;
        while ((!find) && (i < listPassengers.length)) {
            if (passport.equals(listPassengers[i].getPassport())) {
                find = true;
                pas = listPassengers[i];
            }
            i++;
        }
        return pas;
    }

}
