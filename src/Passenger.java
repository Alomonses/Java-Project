public class Pasajero {
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    // Constructor
    public Pasajero(String nombre, String pasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getPasaporte() {
        return this.pasaporte;
    }

    public String getNacionalidad() {
        return this.nacionalidad;
    }

}