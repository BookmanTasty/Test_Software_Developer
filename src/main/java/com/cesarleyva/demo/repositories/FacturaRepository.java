

package com.cesarleyva.demo.repositories;

// importamos el objeto factura para su uso
import com.cesarleyva.demo.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// creamos la interfaz FacturaRepository para el uso con la base de datos
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    // implementamos las cuncionalidades de la interfaz FacturaRepository
    List<Factura> findByPersonaIdentificacion(String personaIdentificacion);
    List<Factura> deleteByPersonaIdentificacion(String personaIdentificacion);

}