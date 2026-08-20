package proyectofinal_equipo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    // Credenciales para realizar conexion a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/Astrafly?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin";
    
    // Metodo para realizar conexion a la base de datos
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    // Main try/catch que verifica si se realizo la conexion correctamente
    public static void main(String[] args) {
        try (Connection cn = conectar()) {
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
