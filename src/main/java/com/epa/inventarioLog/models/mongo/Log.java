package com.epa.inventarioLog.models.mongo;

import com.epa.inventarioLog.models.dto.TransaccionDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document("Log")
public class Log {
    @Id
    private String id;
    private String idProducto;
    private Date fecha;
    private int cantidad;
    private double precio;

    private double descuento;
    private String tipo;

    public Log() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log log)) return false;
        return cantidad == log.cantidad && Double.compare(precio, log.precio) == 0 && Double.compare(descuento, log.descuento) == 0 && Objects.equals(id, log.id) && Objects.equals(idProducto, log.idProducto) && Objects.equals(fecha, log.fecha) && Objects.equals(tipo, log.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProducto, fecha, cantidad, precio, descuento, tipo);
    }
}
