public class AeropuetoPublico extends Aeropuerto {
    private double subvencion;

    public AeropuetoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuetoPublico(double subvencion, String nombre, String ciudad, String pais, Compañia c[], String e[]) {
        super(nombre, ciudad, pais, c);
        this.subvencion = subvencion;
    }

    public AeropuetoPublico(double subvencion, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }

    // Getter
    public double getSubvencion() {
        return this.subvencion;
    }
}
