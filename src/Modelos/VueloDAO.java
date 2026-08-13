package Modelos;

import proyectofinal_equipo2.BaseDeDatos.ConexionDB;
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
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    //Buscar Vuelo
    public List<Vuelo> listarRegistro(String valorBuscar) {
        
        String sql = "SELECT * FROM Vuelos "
                + "WHERE numero_vuelo LIKE ? OR aerolinea LIKE ? OR origen LIKE ? OR destino LIKE ?";
        
        List<Vuelo> datos = new ArrayList<>();
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            
            String comodin = "%" + valorBuscar + "%";
            ps.setString(1, comodin);
            ps.setString(2, comodin);
            ps.setString(3, comodin);
            ps.setString(4, comodin);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                datos.add(mapearVuelo(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los vuelos: " + ex); 
        }
        return datos;
    }
    
    //Listar Vuelo
    public List<Vuelo> listar() {
        String sql = "SELECT * FROM Vuelos ORDER BY fecha_salida";
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
    
    public int agregar(Vuelo v) {
        int r = 0;
        String sql = "INSERT INTO Vuelos (numero_vuelo, aerolinea, origen, destino, "
                + "fecha_salida, fecha_llegada, asientos_totales, asientos_disponibles, "
                + "precio, estado)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setTimestamp(5, Timestamp.valueOf(v.getFechaSalida()));
            ps.setTimestamp(6, Timestamp.valueOf(v.getFechaLlegada()));
            ps.setInt(7, v.getAsientosTotales());
            ps.setInt(8, v.getAsientosDisponibles());
            ps.setBigDecimal(9, v.getPrecio());
            ps.setString(10, v.getEstado());
            
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al tratar de insertar los datos");
        }
        
        if (r == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int actualizar(Vuelo v) {
        int r = 0;
        String sql = "UPDATE Vuelos SET numero_vuelo=?, aerolinea=?, origen=?, destino=?, "
                + "fecha_salida=?, fecha_llegada=?, asientos_totales=?, asientos_disponibles=?,"
                + "precio=?, estado=? WHERE id=?";
        
        try {
            con = ConexionDB.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNumeroVuelo());
            ps.setString(2, v.getAerolinea());
            ps.setString(3, v.getOrigen());
            ps.setString(4, v.getDestino());
            ps.setTimestamp(5, Timestamp.valueOf(v.getFechaSalida()));
            ps.setTimestamp(6, Timestamp.valueOf(v.getFechaLlegada()));
            ps.setInt(7, v.getAsientosTotales());
            ps.setInt(8, v.getAsientosDisponibles());
            ps.setBigDecimal(9, v.getPrecio());
            ps.setString(10, v.getEstado());
            ps.setInt(11, v.getId());
            
            r = ps.executeUpdate();
            
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar los datos: " + ex);
        }
        return r;
    }
    
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
            
        } catch (SQLException ex) {
            System.out.println("Error al tratar de borrar los datos " + ex);
        }
        return r;
    }
    
    private Vuelo mapearVuelo(ResultSet rs) throws SQLException {
        Vuelo v = new Vuelo();
        v.setId(rs.getInt("id"));
        v.setNumeroVuelo(rs.getString("numero_vuelo"));
        v.setOrigen(rs.getString("origen"));
        v.setDestino(rs.getString("destino"));
        v.setFechaSalida(rs.getTimestamp("fecha_salida").toLocalDateTime());
        v.setFechaLlegada(rs.getTimestamp("fecha_llegada").toLocalDateTime());
        v.setAsientosTotales(rs.getInt("asientos_totales"));
        v.setAsientosDisponibles(rs.getInt("asientos_disponibles"));
        v.setPrecio(rs.getBigDecimal("precio"));
        v.setEstado(rs.getString("estado"));
        return v;
    }
}
