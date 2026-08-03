package proyectofinal_equipo2;

import java.time.LocalDateTime;

public class Reserva {//CLASE
    private int idReserva;
    private int idUsuario;
    private int idVuelo;
    private int cantidadPasajeros;
    private LocalDateTime fechaReserva;
    private String estado;
    
    //CONSTRUCTOR\\
    public Reserva(int idReserva, int idUsuario, int idVuelo, int cantidadPasajeros,
                    LocalDateTime fechaReserva, String estado) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.cantidadPasajeros = cantidadPasajeros;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }
    
    //Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
