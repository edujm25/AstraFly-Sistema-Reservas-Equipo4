package Modelos;

import proyectofinal_equipo2.ConexionDB;
import Modelos.Reservas;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Edwis Jimenez
 */
public class ReservasDAO {
    
    // Variables necesarias para la conexion con la base datos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    // Metodo con switch que corre dependiendo de la columna que requiera buscar el usuario
    public List<Reservas> buscarPorColumna(String columna, String valorBuscar) {
        String columnaSql;
        switch (columna) {
            case "codigo": columnaSql = "codigo_reserva"; break;
            case "pasajero": columnaSql = "nombre_pasajero"; break;
            case "estado": columnaSql = "estado"; break;
            default:
                System.out.println("Columna de busqueda no valida: " + columna);
                return new ArrayList<>();
        }
        String sql = "SELECT * FROM vueloreservas WHERE " + columnaSql + " LIKE ?";
        List<Reservas> datos = new ArrayList<>();
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valorBuscar + "%");
            rs = ps.executeQuery();
            while (rs.next()) datos.add(mapearReserva(rs));
        } catch (SQLException ex) {
            System.out.println("Error al buscar reservas: " + ex);
        }
        return datos;
    }
    
    // Metodo que lista todos los datos y los organiza para la tabla
    public List<Reservas> listar() {
        String sql = "SELECT * FROM vueloreservas ORDER BY fecha_reserva";
        List<Reservas> datos = new ArrayList();
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) datos.add(mapearReserva(rs));
        } catch (SQLException ex) {
            System.out.println("Error al listar las reservas: " + ex);
        }
        return datos;
    }
    
    // Metodo para buscar datos por Id
    public Reservas buscarPorId(int id) {
        String sql = "SELECT * FROM vueloreservas WHERE id = ?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) return mapearReserva(rs);
        } catch (SQLException ex) {
            System.out.println("Error al buscar reserva: " + ex);
        }
        return null;
    }
    
    // Metodo para insertar datos nuevos en la tabla de la base de datos tomando los datos de la vista como parametro
    public int agregar(Reservas r) {
        int res = 0;
        String sql = "INSERT INTO vueloreservas (usuario_id, vuelo_id, codigo_reserva, nombre_pasajero, "
                + "estado, precio_pagado) VALUES (?,?,?,?,?,?)";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdUsuario());
            ps.setInt(2, r.getIdVuelo());
            ps.setString(3, r.getCodigoReserva());
            ps.setString(4, r.getNombrePasajero());
            ps.setString(5, r.getEstado());
            ps.setBigDecimal(6, r.getPrecioPagado());
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al tratar de insertar datos: " + e);
        }
        return (res == 1) ? 1 : 0;
    }
    
    // Metodo para actualizar los datos en la tabla de la base de datos tomando los datos de la vista como parametro    
    public int actualizar(Reservas r) {
        int res = 0;
        String sql = "UPDATE vueloreservas SET usuario_id=?, vuelo_id=?, codigo_reserva=?, nombre_pasajero=?, "
                + "estado=?, precio_pagado=? WHERE id=?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdUsuario());
            ps.setInt(2, r.getIdVuelo());
            ps.setString(3, r.getCodigoReserva());
            ps.setString(4, r.getNombrePasajero());
            ps.setString(5, r.getEstado());
            ps.setBigDecimal(6, r.getPrecioPagado());
            ps.setInt(7, r.getId());
            res = ps.executeUpdate();
            return (res == 1) ? 1 : 0;
        } catch (SQLException e) {
            System.out.println("Error al tratar de actualizar datos: " + e);
        }
        return res;
    }
    
    // Busca y elimina en la base de datos con el id indicado
    public int eliminar(int id) {
        int res = 0;
        String sql = "DELETE FROM vueloreservas WHERE id=?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate();
            return (res == 1) ? 1 : 0;
        } catch (SQLException e) {
            System.out.println("Error al tratar de borrar datos: " + e);
        }
        return res;
    }
    
    // Convierte la fila actual del ResultSet en un objeto Reservas.
    private Reservas mapearReserva(ResultSet rs) throws SQLException {
        Reservas r = new Reservas();
        r.setId(rs.getInt("id"));
        r.setIdUsuario(rs.getInt("usuario_id"));
        r.setIdVuelo(rs.getInt("vuelo_id"));
        r.setCodigoReserva(rs.getString("codigo_reserva"));
        r.setNombrePasajero(rs.getString("nombre_pasajero"));
        r.setEstado(rs.getString("estado"));
        Timestamp ts = rs.getTimestamp("fecha_reserva");
        r.setFechaReserva(ts != null ? ts.toLocalDateTime() : null);
        r.setPrecioPagado(rs.getBigDecimal("precio_pagado"));
        return r;
    }
}
