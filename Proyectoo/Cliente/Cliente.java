package Proyectoo.Cliente;

import Proyectoo.BaseDeDatos;
import Proyectoo.Jugo.Jugo;
import Proyectoo.Pedido.Pedido;
import com.sun.source.tree.TryTree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String telefono;

    public Cliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese su número telefónico: ");
        this.telefono = scanner.nextLine();
        guardarCliente();
    }

    public void guardarCliente() {
        BaseDeDatos baseDeDatos = new BaseDeDatos();
        Connection conn = null;
        String sql = "INSERT INTO Clientes (nombre, telefono) VALUES (?, ?)";
        ResultSet rs = null;
        int idGenerado = -1;  // Variable para almacenar el ID generado

        try {
            conn = baseDeDatos.conectar();
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);  // Indicamos que queremos recuperar las claves generadas
                stmt.setString(1, nombre);
                stmt.setString(2, telefono);

                // Ejecutamos la actualización
                stmt.executeUpdate();

                // Recuperamos las claves generadas
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1);  // El ID generado es el primer valor en el conjunto de claves generadas
                    System.out.println("Cliente guardado en la base de datos con ID: " + idGenerado);
                } else {
                    System.out.println("No se pudo obtener el ID generado.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        } finally {
            // Cerramos los recursos en el bloque finally para evitar posibles fugas de memoria
            try {
                if (rs != null) {
                    ((ResultSet) rs).close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
            Pedido.setClienteId(idGenerado);
        }
    }


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return 0;
    }

}