package com.cesarleyva.demo.services;

import com.cesarleyva.demo.models.Factura;

import java.util.List;

public interface VentasService {
    List<Factura> findFacturasByPersona(String personaIdentificacion);
    Factura storeFactura(Factura factura);
    List<Factura> deleteFacturaByPersona(String personaIdentificacion);
}
