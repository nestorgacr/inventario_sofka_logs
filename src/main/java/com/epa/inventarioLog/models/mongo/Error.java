package com.epa.inventarioLog.models.mongo;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document("Error")
public class Error {
    @Id
    private String id;
    private Date fecha;
    private String tipo;
    private Object data;

    private Error() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Error errorDto)) return false;
        return Objects.equals(id, errorDto.id) && Objects.equals(fecha, errorDto.fecha) && Objects.equals(tipo, errorDto.tipo) && Objects.equals(data, errorDto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, tipo, data);
    }
}
