package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Edwis Jimenez
 */
public class Vuelo {//Clase vuelo
    private int id;
    private String numeroVuelo;
    private String aerolinea;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private LocalDateTime fechaLlegada;
    private int asientosTotales;
    private int asientosDisponibles;
    private BigDecimal precio;
    private String estado;
    
    //Constructores
    public Vuelo(){
    }
    
    public Vuelo(int id, String numeroVuelo, String aerolinea, String origen, String destino,
                 LocalDateTime fechaSalida, LocalDateTime fechaLlegada,
                 int asientosTotales, int asientosDisponibles,
                 BigDecimal precio, String estado) {
        this.id = id;
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.asientosTotales = asientosTotales;
        this.asientosDisponibles = asientosDisponibles;
        this.precio = precio;
        this.estado = estado;
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
 
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
 
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
 
    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }
 
    public void setFechaLlegada(LocalDateTime fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
 
    public int getAsientosTotales() {
        return asientosTotales;
    }
 
    public void setAsientosTotales(int asientosTotales) {
        this.asientosTotales = asientosTotales;
    }
 
    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }
 
    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
 
    public BigDecimal getPrecio() {
        return precio;
    }
 
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
 
    public String getEstado() {
        return estado;
    }
 
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return numeroVuelo + " (" + origen + " -> " + destino + ")";
    }
}
