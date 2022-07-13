package com.cesarleyva.demo.restservices;


import com.cesarleyva.demo.models.Factura;
import com.cesarleyva.demo.models.Persona;
import com.cesarleyva.demo.restservices.objects.FacturaPostResponse;
import com.cesarleyva.demo.restservices.objects.FacturaPostStore;
import com.cesarleyva.demo.services.DirectorioService;
import com.cesarleyva.demo.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaRestService {
    @Autowired
    private VentasService ventasService;
    @Autowired
    private DirectorioService directorioService;

    // el mapeo con metodo delete lo utilizamos para eliminar datos
    @RequestMapping(value = "/ventas", method = RequestMethod.DELETE)
    public List<Factura> deleteVentas(@RequestParam("personaIdentificacion") String personaIdentificacion) {
        return ventasService.deleteFacturaByPersona(personaIdentificacion);
    }

    // el mapeo con metodo get lo utilizamos para obtener las facturas con el id de la persona
    @RequestMapping(value = "/ventas/facturas", method = RequestMethod.GET)
    public List<Factura> findFacturasByPersona(@RequestParam("personaIdentificacion") String personaIdentificacion) {
        return ventasService.findFacturasByPersona(personaIdentificacion);
    }

    // el mapeo post lo utilizamos para crear facturas con un objeto json en el body
    @RequestMapping(value = "/ventas/factura", method = RequestMethod.POST)
    public FacturaPostResponse storeFactura(@RequestBody FacturaPostStore facturaPostStore) {
        // creamos el objeto respuesta
        FacturaPostResponse facturaPostResponse = new FacturaPostResponse();
        try {
            Persona persona = directorioService.findPersonaByIdentificacion(facturaPostStore.getPersonaId());
            Factura factura = new Factura();
            factura.setMonto(facturaPostStore.getMonto());
            // obtenemos la fecha de timemillis
            Long timeMillis = System.currentTimeMillis();
            // convertimos la fecha a un objeto Date
            java.util.Date date = new java.util.Date(timeMillis);
            // convertimos el objeto Date a un string con formato dd-MM-yyyy
            String fecha = new java.text.SimpleDateFormat("dd-MM-yyyy").format(date);
            factura.setPersonaIdentificacion(persona.getIdentificacion());
            factura.setFecha(fecha);
            // verificamos que la persona exista
            if (persona != null) {
                // guardamos la factura
                factura = ventasService.storeFactura(factura);
                // seteamos los datos de la respuesta
                facturaPostResponse.setCodigo(200);
                facturaPostResponse.setMensaje("Factura creada con exito");
                facturaPostResponse.setFactura(factura);
            } else {
                // seteamos los datos de la respuesta
                facturaPostResponse.setCodigo(500);
                facturaPostResponse.setMensaje("Error al crear factura persona no existe");
            }

        } catch (Exception e) {
            facturaPostResponse.setCodigo(500);
            facturaPostResponse.setMensaje("Error al crear factura");
        }
        return facturaPostResponse;
    }

}
