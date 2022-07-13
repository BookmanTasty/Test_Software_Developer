package com.cesarleyva.demo.restservices;

import com.cesarleyva.demo.models.Factura;
import com.cesarleyva.demo.models.Persona;
import com.cesarleyva.demo.restservices.objects.PersonaDeleteResponse;
import com.cesarleyva.demo.restservices.objects.PersonaPostResponse;
import com.cesarleyva.demo.services.DirectorioService;
import com.cesarleyva.demo.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorioRestService {
    // inyectamos el servicio para su uso en el controlador del servicio rest
    @Autowired
    private DirectorioService personaService;
    @Autowired
    private VentasService ventasService;
    // creamos los mapeos rest para entregar los datos
    @RequestMapping(value = "/directorio/personas", method = RequestMethod.GET)
    public List<Persona> findPersonas() {
        return personaService.findPersonas();
    }
    // el mapeo con metodo get sirve para obtener datos
    @RequestMapping(value = "/directorio/persona", method = RequestMethod.GET)
    public Persona findPersonaByIdentificacion(@RequestParam("identificacion") String identificacion) {
        return personaService.findPersonaByIdentificacion(identificacion);
    }
    // el mapeo con metodo post lo utilizamos para crear datos
    @RequestMapping(value = "/directorio/persona", method = RequestMethod.POST)
    public PersonaPostResponse storePersona(@RequestBody Persona persona) {
        PersonaPostResponse response = new PersonaPostResponse();
        // verificamos que los datos en persona no sean nulos o vacios
        if (persona.getIdentificacion() == null || persona.getIdentificacion().isEmpty() ||
                persona.getNombre() == null || persona.getNombre().isEmpty() ||
                persona.getApellidoPaterno() == null || persona.getApellidoPaterno().isEmpty()) {
            response.setCodigo(500);
            response.setMensaje("Los datos, Nombre, Apellido Paterno e Identificación, son obligatorios");
        }else {
            try {
                response.setCodigo(200);
                response.setMensaje("Persona creada con exito");
                response.setPersona(personaService.storePersona(persona));
            } catch (Exception e) {
                response.setCodigo(500);
                response.setMensaje("Error al crear persona identificacion en uso");
            }
        }
        return response;
    }
    //  mapeamos con el metodo delete para eliminar datos
    @RequestMapping(value = "/directorio/persona", method = RequestMethod.DELETE)
    public PersonaDeleteResponse deletePersonaByIdentificacion(@RequestParam("identificacion") String identificacion) {
        List<Factura> facturaList = ventasService.deleteFacturaByPersona(identificacion);
        List<Persona> personaList = personaService.deletePersonaByIdentificacion(identificacion);
        PersonaDeleteResponse response = new PersonaDeleteResponse();
        String mensaje = "Persona eliminada con exito";
        if (personaList.size() > 0) {
            response.setCodigo(200);
            if (facturaList.size() > 0) {
                mensaje = mensaje + " y " + facturaList.size() + " facturas eliminadas";
            }
            response.setMensaje(mensaje);
            response.setPersona(personaList.get(0));
        } else {
            response.setCodigo(500);
            response.setMensaje("Error al eliminar persona");
        }
        return response;
    }

}



