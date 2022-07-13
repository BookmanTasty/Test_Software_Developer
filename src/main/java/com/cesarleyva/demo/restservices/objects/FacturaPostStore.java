package com.cesarleyva.demo.restservices.objects;

public class FacturaPostStore {

    private int monto;
    private String personaId;

    public FacturaPostStore() {
        super();
    }

    public FacturaPostStore(int monto, String personaId) {
        super();
        this.monto = monto;
        this.personaId = personaId;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }
}
