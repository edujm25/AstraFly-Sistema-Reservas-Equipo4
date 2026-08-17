package Modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Edwis Jimenez
 */
public class Vuelo {
 
    private int id;
    private String numeroVuelo;
    private String aerolinea;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private BigDecimal precio;
 
    public Vuelo() {
    }
 
    // Constructor
    public Vuelo(int id, String numeroVuelo, String aerolinea, String origen, String destino,
                 LocalDate fecha, LocalTime hora, BigDecimal precio) {
        this.id = id;
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
    }
    
    //Getters y Setters
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNumeroVuelo() {
        return numeroVuelo;
    }
 
    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }
 
    public String getAerolinea() {
        return aerolinea;
    }
 
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
 
    public String getOrigen() {
        return origen;
    }
 
    public void setOrigen(String origen) {
        this.origen = origen;
    }
 
    public String getDestino() {
        return destino;
    }
 
    public void setDestino(String destino) {
        this.destino = destino;
    }
 
    public LocalDate getFecha() {
        return fecha;
    }
 
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
 
    public LocalTime getHora() {
        return hora;
    }
 
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
 
    public BigDecimal getPrecio() {
        return precio;
    }
 
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
 
    @Override
    public String toString() {
        return numeroVuelo + " (" + origen + " -> " + destino + ")";
    }
}