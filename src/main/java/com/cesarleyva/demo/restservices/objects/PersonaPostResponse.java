package com.cesarleyva.demo.restservices.objects;

import com.cesarleyva.demo.models.Persona;

public class PersonaPostResponse {
    private String mensaje;
    private int codigo;
    private Persona persona;

    public PersonaPostResponse() {
        super();
    }

    public PersonaPostResponse(String mensaje, int codigo, Persona persona) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.persona = persona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

