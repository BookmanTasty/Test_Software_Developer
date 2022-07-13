package com.cesarleyva.demo.services;

import com.cesarleyva.demo.models.Persona;
import com.cesarleyva.demo.repositories.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Slf4j
@Service("directorioService")
public class DirectorioServiceImpl implements DirectorioService {
    // inicializamos el logger slf4j
    private static final Logger logger = LoggerFactory.getLogger(DirectorioServiceImpl.class);
    // inyectamos el repositorio persona para su uso en el servicio
    @Autowired
    PersonaRepository personaRepository;
    // creamos las funciones publicas que se encargan de entregar los datos al controlador del servicio rest

    @Override
    public Persona findPersonaByIdentificacion(String identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }

    @Override
    public List<Persona> findPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona storePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    @Override
    public List<Persona> deletePersonaByIdentificacion(String identificacion) {
        return personaRepository.deleteByIdentificacion(identificacion);
    }
}

