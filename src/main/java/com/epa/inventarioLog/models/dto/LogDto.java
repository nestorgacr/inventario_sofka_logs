package com.epa.inventarioLog.models.dto;


import java.util.Date;
import java.util.Objects;

public class LogDto {
    private String id;
    private Date fecha;
    private String idProducto;
    private String tipo;
    private TransaccionDto data;

    public LogDto() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TransaccionDto getData() {
        return data;
    }

    public void setData(TransaccionDto data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogDto logDto)) return false;
        return Objects.equals(id, logDto.id) && Objects.equals(fecha, logDto.fecha) && Objects.equals(idProducto, logDto.idProducto) && Objects.equals(tipo, logDto.tipo) && Objects.equals(data, logDto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, idProducto, tipo, data);
    }
}
