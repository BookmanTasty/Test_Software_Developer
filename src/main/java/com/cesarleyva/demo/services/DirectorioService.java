package com.cesarleyva.demo.services;

import com.cesarleyva.demo.models.Persona;

import java.util.List;

public interface DirectorioService {
    // implementamos las funciones requerias para el uso de la base de datos
    Persona findPersonaByIdentificacion(String identificacion);
    List<Persona> findPersonas();
    Persona storePersona(Persona persona);
    List<Persona> deletePersonaByIdentificacion(String identificacion);
}
