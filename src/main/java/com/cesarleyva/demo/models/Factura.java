package com.cesarleyva.demo.models;

import javax.persistence.*;

//definimos el objeto factura para el uso con la base de datos
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // agregamos los atributos de la factura para el uso con la base de datos fecha, monto , persona_id
    private String fecha;
    private double monto;
    // Creamos la llave foranea para la tabla factura desde la tabla factura
    private String personaIdentificacion;

    public Factura() {
        super();
    }

    public Factura(int id, String fecha, double monto, String personaIdentificacion) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.personaIdentificacion = personaIdentificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getPersonaIdentificacion() {
        return personaIdentificacion;
    }

    public void setPersonaIdentificacion(String personaIdentificacion) {
        this.personaIdentificacion = personaIdentificacion;
    }
}
