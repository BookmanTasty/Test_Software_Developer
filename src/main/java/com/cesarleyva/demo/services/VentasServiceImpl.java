package com.cesarleyva.demo.services;

import com.cesarleyva.demo.models.Factura;
import com.cesarleyva.demo.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ventasService")
public class VentasServiceImpl implements VentasService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findFacturasByPersona(String personaIdentificacion) {
        return facturaRepository.findByPersonaIdentificacion(personaIdentificacion);
    }

    @Override
    public Factura storeFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Transactional
    @Override
    public List<Factura> deleteFacturaByPersona(String personaIdentificacion) {
        return facturaRepository.deleteByPersonaIdentificacion(personaIdentificacion);
    }



}
