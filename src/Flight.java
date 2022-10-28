public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int numMaxPasajeros;
    private int numActualPasajeros;

    private Pasajero listaPasajero[];

    // Constructor
    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros = 0;
        this.listaPasajero = new Pasajero[numMaxPasajeros];
    }

    public void insertarPasajero(Pasajero pasajero) {
        listaPasajero[numActualPasajeros] = pasajero;
        numActualPasajeros++;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public String getCiudadOrigen() {
        return this.ciudadOrigen;
    }

    public String getCiudadDestino() {
        return this.ciudadDestino;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getNumMaxPasajeros() {
        return this.numMaxPasajeros;
    }

    public int getNumActualPasajeros() {
        return this.numActualPasajeros;
    }

    public Pasajero getPasajero(int i) {
        return listaPasajero[i];
    }

    public Pasajero getPasajero(String pasaporte) {
        boolean encontrado = false;
        int i = 0;
        Pasajero pas = null;
        while ((!encontrado) && (i < listaPasajero.length)) {
            if (pasaporte.equals(listaPasajero[i].getPasaporte())) {
                encontrado = true;
                pas = listaPasajero[i];
            }
            i++;
        }
        return pas;
    }

}
