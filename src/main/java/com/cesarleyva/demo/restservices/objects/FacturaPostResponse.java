package com.cesarleyva.demo.restservices.objects;

import com.cesarleyva.demo.models.Factura;

public class FacturaPostResponse {
    private String mensaje;
    private int codigo;
    private Factura factura;

    public FacturaPostResponse() {
        super();
    }

    public FacturaPostResponse(String mensaje, int codigo, Factura factura) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.factura = factura;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
