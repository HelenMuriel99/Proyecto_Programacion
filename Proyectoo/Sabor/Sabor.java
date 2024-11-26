package Proyectoo.Sabor;

public class Sabor {
    private String sabor;
    private double precioBase;

    public Sabor(String sabor, double precioBase) {
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
