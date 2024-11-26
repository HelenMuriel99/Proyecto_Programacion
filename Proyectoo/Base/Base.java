package Proyectoo.Base;

public class Base {
    private String nombre;
    private double costo;

    public Base(String nombre, double costo){
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }
}