package com.cesarleyva.demo.repositories;

// importamos el objeto persona para su uso
import com.cesarleyva.demo.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// creamos la interfaz PersonaRepository para el uso con la base de datos
@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findByIdentificacion(String identificacion);
    List<Persona> deleteByIdentificacion(String identificacion);
}

