package Proyectoo.Pedido;

import Proyectoo.Base.Base;
import Proyectoo.BaseDeDatos;
import Proyectoo.Cliente.Cliente;
import Proyectoo.Jugo.Jugo;
import Proyectoo.Tamaño.Tamaño;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Pedido {
    private int id;
    private static int clienteId;
    private static int jugoId;
    private static String base;
    private static String tamaño;
    private static double precio;

    public Pedido(int id, int clienteId, int jugoId, String base, String tamaño, double precio) {
        this.id = id;
        this.clienteId = clienteId;
        this.jugoId = jugoId;
        this.base = base;
        this.tamaño = tamaño;
        this.precio = precio;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static int getClienteId() {
        return clienteId;
    }
    public static void setClienteId(int clienteId) {
        Pedido.clienteId = clienteId;
    }

    public static int getJugoId() {
        return jugoId;
    }
    public static void setJugoId(int jugoId) {
        Pedido.jugoId = jugoId;
    }

    public static String getBase() {
        return base;
    }
    public static void setBase(String base) {
        Pedido.base = base;
    }

    public static String getTamaño() {
        return tamaño;
    }
    public static void setTamaño(String tamaño) {
        Pedido.tamaño = tamaño;
    }

    public static double getPrecio() {
        return precio;
    }
    public static void setPrecio(double precio) {
        Pedido.precio = precio;
    }
}