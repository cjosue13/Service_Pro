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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import wscineuna.model.UsuarioDto;
import wscineuna.service.UsuarioService;
import wscineuna.util.CodigoRespuesta;
import wscineuna.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Path("/usuarioController")
public class UsuarioController {
    
    @EJB
    private UsuarioService usuarioService;
     @POST
    @Path("/guardarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarUsuario(UsuarioDto usuario) {
        try {
            Respuesta respuesta = usuarioService.guardarUsuario(usuario);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((UsuarioDto) respuesta.getResultado("Usuario")).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando al usuario").build();
        }
    }
}
