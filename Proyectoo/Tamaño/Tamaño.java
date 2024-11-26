package Proyectoo.Tamaño;

public class Tamaño {
    private String nombre;
    private double costoAdicional;

    public Tamaño(String nombre, double costoAdicional) {
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }
}
