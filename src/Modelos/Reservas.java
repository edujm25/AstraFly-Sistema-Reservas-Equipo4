package Modelos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Edwis Jimenez
 */
public class Reservas {
    
    private int id;
    private int idUsuario;
    private int idVuelo;
    private String codigoReserva;
    private String nombrePasajero;
    private String estado;
    private LocalDateTime fechaReserva;
    private BigDecimal precioPagado;
    
    public Reservas() {
    }
    
    public Reservas(int id, int idUsuario, int idVuelo, String codigoReserva,
                    String nombrePasajero, String estado, LocalDateTime fechaReserva, BigDecimal precioPagado) {
        
        this.id = id;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.codigoReserva = codigoReserva;
        this.nombrePasajero = nombrePasajero;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
        this.precioPagado = precioPagado;
    }
    
    //Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public String getCodigoReserva() {
        return codigoReserva;
    }
    
    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
    
    public String getNombrePasajero() {
        return nombrePasajero;
    }
    
    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }
    
    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    public BigDecimal getPrecioPagado() {
        return precioPagado;
    }
    
    public void setPrecioPagado(BigDecimal precioPagado) {
        this.precioPagado = precioPagado;
    }
    
    @Override
    public String toString() {
        return codigoReserva + " (" + nombrePasajero + " -> " + estado + ")";
    }
}
