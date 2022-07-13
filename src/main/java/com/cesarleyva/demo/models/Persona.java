package com.cesarleyva.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

// definimos el objeto persona para el uso con la base de datos
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    // agregamos los atributos de la persona para el uso con la base de datos nombre apellidoPaterno apellidoMaterno identificacion.
    @NotNull
    private String nombre;
    @NotNull
    private String apellidoPaterno;
    private String apellidoMaterno;
    //el atributo string sera unico para asegurar la integridad de los datos
    @NotNull
    @Column(unique=true)
    private String identificacion;


    public Persona() {
        super();
    }

    public Persona(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.identificacion = identificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
