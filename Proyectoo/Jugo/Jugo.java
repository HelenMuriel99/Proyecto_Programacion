package Proyectoo.Jugo;

public class Jugo {
    private String sabor;
    private double precioBase;

    public Jugo(String sabor, double precioBase) {
        this.sabor = sabor;
        this.precioBase = precioBase;
    }

    public String getSabor() {
        return sabor;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public String toString() {
        return sabor + " (Precio base: Bs." + precioBase + ")";
    }

    public int getId() {
        return 0;
    }
}
