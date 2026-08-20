package Modelos;

import proyectofinal_equipo2.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shing
 */
public class UserDAO {

    public boolean realizarLogin(String usuario, String clave) {
        String sql = "SELECT * FROM usuarios WHERE nombre_Usuario = ? AND contrasena = ?";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, clave);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Devuelve todos los usuarios registrados.
     */
    public List<User> listar() {
        List<User> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    /**
     * Busca usuarios cuyo valor en "columna" contenga el texto dado.
     * La columna se valida contra una lista blanca para evitar inyeccion SQL,
     * ya que el nombre de columna no se puede parametrizar con "?".
     */
    public List<User> buscarPorColumna(String columna, String texto) {
        List<User> usuarios = new ArrayList<>();

        String columnaSql;
        switch (columna) {
            case "nombre_usuario":
                columnaSql = "nombre_Usuario";
                break;
            case "nombre_apellido":
                columnaSql = "nombre_apellido";
                break;
            case "documento":
                columnaSql = "documento_cedula_pasaporte";
                break;
            case "correo":
                columnaSql = "correo";
                break;
            case "telefono":
                columnaSql = "numero_telefonico";
                break;
            default:
                columnaSql = "nombre_Usuario";
        }

        String sql = "SELECT * FROM usuarios WHERE " + columnaSql + " LIKE ? ORDER BY id";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(mapearUsuario(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    /**
     * Busca en varias columnas a la vez (usado cuando el panel solo tiene
     * un campo de texto de busqueda, sin combo para elegir la columna).
     */
    public List<User> buscarGeneral(String texto) {
        List<User> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios "
                + "WHERE nombre_Usuario LIKE ? OR nombre_apellido LIKE ? "
                + "OR documento_cedula_pasaporte LIKE ? OR correo LIKE ? "
                + "ORDER BY id";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            String comodin = "%" + texto + "%";
            ps.setString(1, comodin);
            ps.setString(2, comodin);
            ps.setString(3, comodin);
            ps.setString(4, comodin);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(mapearUsuario(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public User buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Inserta un nuevo usuario. Devuelve 1 si tuvo exito, 0 si no.
     */
    public int agregar(User u) {
        String sql = "INSERT INTO usuarios "
                + "(nombre_Usuario, nombre_apellido, documento_cedula_pasaporte, correo, numero_telefonico, contrasena) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getNombreApellido());
            ps.setString(3, u.getDocumentoCedulaPasaporte());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getNumeroTelefonico());
            ps.setString(6, u.getContrasena());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    /**
     * Actualiza un usuario existente. Si la contrasena viene vacia, no la
     * toca (para permitir editar el resto de los datos sin forzar un cambio
     * de clave).
     */
    public int actualizar(User u) {
        boolean cambiaClave = u.getContrasena() != null && !u.getContrasena().trim().isEmpty();

        String sql = cambiaClave
                ? "UPDATE usuarios SET nombre_Usuario=?, nombre_apellido=?, documento_cedula_pasaporte=?, "
                    + "correo=?, numero_telefonico=?, contrasena=? WHERE id=?"
                : "UPDATE usuarios SET nombre_Usuario=?, nombre_apellido=?, documento_cedula_pasaporte=?, "
                    + "correo=?, numero_telefonico=? WHERE id=?";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getNombreApellido());
            ps.setString(3, u.getDocumentoCedulaPasaporte());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getNumeroTelefonico());

            if (cambiaClave) {
                ps.setString(6, u.getContrasena());
                ps.setInt(7, u.getId());
            } else {
                ps.setInt(6, u.getId());
            }

            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    // Busca y elimina en la base de datos con el id indicado
    public int eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection cn = ConexionDB.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    // Convierte la fila actual del ResultSet en un objeto User.
    
    private User mapearUsuario(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setNombreUsuario(rs.getString("nombre_Usuario"));
        u.setNombreApellido(rs.getString("nombre_apellido"));
        u.setDocumentoCedulaPasaporte(rs.getString("documento_cedula_pasaporte"));
        u.setCorreo(rs.getString("correo"));
        u.setNumeroTelefonico(rs.getString("numero_telefonico"));
        u.setContrasena(rs.getString("contrasena"));
        return u;
    }
}