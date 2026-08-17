package Modelos;

/**
 *
 * @author shing
 */
public class User {

    private int id;
    private String nombreUsuario;
    private String nombreApellido;
    private String documentoCedulaPasaporte;
    private String correo;
    private String numeroTelefonico;
    private String contrasena;

    public User() {
    }

    //Constructor
    public User(int id, String nombreUsuario, String nombreApellido, String documentoCedulaPasaporte,
                String correo, String numeroTelefonico, String contrasena) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombreApellido = nombreApellido;
        this.documentoCedulaPasaporte = documentoCedulaPasaporte;
        this.correo = correo;
        this.numeroTelefonico = numeroTelefonico;
        this.contrasena = contrasena;
    }
    
    
    //Getter y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getDocumentoCedulaPasaporte() {
        return documentoCedulaPasaporte;
    }

    public void setDocumentoCedulaPasaporte(String documentoCedulaPasaporte) {
        this.documentoCedulaPasaporte = documentoCedulaPasaporte;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return nombreUsuario + " (" + nombreApellido + ")";
    }
}