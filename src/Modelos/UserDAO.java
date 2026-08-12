/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinal_equipo2.BaseDeDatos.ConexionDB;
/**
 *
 * @author shing
 */
public class UserDAO {
    ConexionDB conectar = new ConexionDB();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;

    public boolean realizarLogin(String usuario, String clave) {
        try {
            cn = conectar.conectar();

            String sql = "select * from usuarios where usuario = ? and clave = ?";

        
            ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            while (rs.next()) {
                cn.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}

