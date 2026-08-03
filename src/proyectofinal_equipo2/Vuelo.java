package proyectofinal_equipo2;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Vuelo {//CLASE
    private int idVuelo;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private BigDecimal precio;
    private int asientosTotales;
    private int asientosDisponibles;
    private String estado;
    
    //CONSTRUCTOR\\
    public Vuelo(int idVuelo, String origen, String destino, LocalDateTime fechaSalida, BigDecimal precio,
                 int asientosTotales, int asientosDisponibles, String estado) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.asientosTotales = asientosTotales;
        this.asientosDisponibles = asientosDisponibles;
        this.estado = estado;
    }
    
    //Getters y Setters
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
