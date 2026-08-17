package Modelos;

import proyectofinal_equipo2.ConexionDB;
import Modelos.Vuelo;
import java.sql.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Edwis Jimenez
 */
public class VueloDAO {
 
    Connection        con;
    PreparedStatement ps;
    ResultSet         rs;
 
   //Filtrado para buscar vuelo por una columna
    public List<Vuelo> buscarPorColumna(String columna, String valorBuscar) {
 
        String columnaSql;
        switch (columna) {
            case "numero":
                columnaSql = "numero_vuelo";
                break;
            case "aerolinea":
                columnaSql = "aerolinea";
                break;
            case "origen":
                columnaSql = "origen";
                break;
            case "destino":
                columnaSql = "destino";
                break;
            default:
                System.out.println("Columna de busqueda no valida: " + columna);
                return new ArrayList<>();
        }
 
        String sql = "SELECT * FROM Vuelos WHERE " + columnaSql + " LIKE ?";
 
        List<Vuelo> datos = new ArrayList<>();
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valorBuscar + "%");
 
            rs = ps.executeQuery();
 
            while (rs.next()) {
                datos.add(mapearVuelo(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar vuelos: " + ex);
        }
        return datos;
    }
 
    /**
     * Lista todos los vuelos registrados.
     */
    public List<Vuelo> listar() {
        String sql = "SELECT * FROM Vuelos ORDER BY fecha, hora";
        List<Vuelo> datos = new ArrayList<>();
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
 
            while (rs.next()) {
                datos.add(mapearVuelo(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los vuelos: " + ex);
        }
        return datos;
    }
 
    /**
     * Busca un vuelo por su id.
     */
    public Vuelo buscarPorId(int id) {
        String sql = "SELECT * FROM Vuelos WHERE id = ?";
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
 
            if (rs.next()) {
                return mapearVuelo(rs);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar vuelo: " + ex);
        }
        return null;
    }
 
    /**
     * Registra un nuevo vuelo.
     * Devuelve 1 si se realizo con exito la insercion, 0 si fallo.
     */
    public int agregar(Vuelo v) {
 
        int r = 0;
        String sql = "INSERT INTO Vuelos (numero_vuelo, aerolinea, origen, destino, fecha, hora, precio) "
                + "VALUES (?,?,?,?,?,?,?)";
 
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setDate(5, Date.valueOf(v.getFecha()));
            ps.setTime(6, Time.valueOf(v.getHora()));
            ps.setBigDecimal(7, v.getPrecio());
 
            r = ps.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("Error al tratar de insertar datos: " + e);
        }
        return (r == 1) ? 1 : 0;
    }
 
    /**
     * Actualiza un vuelo existente, buscandolo por su id.
     */
    public int actualizar(Vuelo v) {
 
        int r = 0;
        String sql = "UPDATE Vuelos SET numero_vuelo=?, aerolinea=?, origen=?, destino=?, "
                + "fecha=?, hora=?, precio=? WHERE id=?";
 
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setDate(5, Date.valueOf(v.getFecha()));
            ps.setTime(6, Time.valueOf(v.getHora()));
            ps.setBigDecimal(7, v.getPrecio());
            ps.setInt(8, v.getId());
 
            r = ps.executeUpdate();
 
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
 
        } catch (SQLException e) {
            System.out.println("Error al tratar de actualizar datos: " + e);
        }
        return r;
    }
 
    /**
     * Elimina el vuelo con el id indicado.
     */
    public int eliminar(int id) {
 
        int r = 0;
        String sql = "DELETE FROM Vuelos WHERE id=?";
 
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
 
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al tratar de borrar datos: " + e);
        }
        return r;
    }
 
    // Convierte la fila actual del ResultSet en un objeto Vuelo.
    private Vuelo mapearVuelo(ResultSet rs) throws SQLException {
        Vuelo v = new Vuelo();
        v.setId(rs.getInt("id"));
        v.setNumeroVuelo(rs.getString("numero_vuelo"));
        v.setAerolinea(rs.getString("aerolinea"));
        v.setOrigen(rs.getString("origen"));
        v.setDestino(rs.getString("destino"));
        v.setFecha(rs.getDate("fecha").toLocalDate());
        v.setHora(rs.getTime("hora").toLocalTime());
        v.setPrecio(rs.getBigDecimal("precio"));
        return v;
    }
}