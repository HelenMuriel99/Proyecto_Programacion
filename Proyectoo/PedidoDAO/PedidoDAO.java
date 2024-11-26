package Proyectoo.PedidoDAO;

import Proyectoo.BaseDeDatos;
import Proyectoo.Pedido.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public static boolean guardarPedido() {
        System.out.println(Pedido.getClienteId());
        String sql = "INSERT INTO Pedidos(cliente_id, jugo_id, base, tamaño, precio_total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = BaseDeDatos.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, Pedido.getClienteId());
            ps.setInt(2, Pedido.getJugoId());
            ps.setString(3, Pedido.getBase());
            ps.setString(4, Pedido.getTamaño());
            ps.setDouble(5, Pedido.getPrecio());
            //System.out.println(pedido.getClienteId() + pedido.getJugoId() + pedido.getBase()+ pedido.getTamaño() + pedido.getPrecio());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido: " + e.getMessage());
            return false;
        }
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedidos";

        try (Connection conexion = BaseDeDatos.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getInt("jugo_id"),
                        rs.getString("base"),
                        rs.getString("tamaño"),
                        rs.getDouble("precio_total")
                );
                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los pedidos: " + e.getMessage());
        }

        return pedidos;
    }

    public Pedido buscarPedidoPorId(int id) {
        String sql = "SELECT * FROM Pedidos WHERE id = ?";
        try (Connection conexion = BaseDeDatos.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                            rs.getInt("id"),
                            rs.getInt("cliente_id"),
                            rs.getInt("jugo_id"),
                            rs.getString("base"),
                            rs.getString("tamaño"),
                            rs.getDouble("precio_total")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el pedido: " + e.getMessage());
        }

        return null;
    }

    public boolean eliminarPedido(int id) {
        String sql = "DELETE FROM Pedidos WHERE id = ?";
        try (Connection conexion = BaseDeDatos.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el pedido: " + e.getMessage());
            return false;
        }
    }
}
