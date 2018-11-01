/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import wscineuna.model.CineDto;
import wscineuna.model.UsuarioDto;
import wscineuna.service.CineService;
import wscineuna.util.CodigoRespuesta;
import wscineuna.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Path("/cineController")
public class CineController {
    @EJB
    CineService cineService;
    
    @GET
    @Path("/cine/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCine(@PathParam("id") Long id) {
        
        try {
            Respuesta res = cineService.getCine(id);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok((CineDto) res.getResultado("Cine")).build();
        } catch (Exception ex) {
            Logger.getLogger(CineController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el empleado").build();
        }
    }
    @POST
    @Path("/guardarCine")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarUsuario(CineDto cine) {
        try {
            Respuesta respuesta = cineService.guardarCine(cine);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((UsuarioDto) respuesta.getResultado("Cine")).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando el Cine").build();
        }
    }
}
