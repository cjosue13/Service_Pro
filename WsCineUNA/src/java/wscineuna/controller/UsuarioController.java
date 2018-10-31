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

    @GET
    @Path("/usuario/{usuario}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("usuario") String usuario, @PathParam("clave") String clave) {
        try {
            Respuesta res = usuarioService.validarUsuario(usuario, clave);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok((UsuarioDto) res.getResultado("Usuario")).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo al usuario").build();
        }
    }

    @GET
    @Path("/activar/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response activarUsuario(@PathParam("usuario") String usuario) {
        try {
            Respuesta res = usuarioService.activarUsuario(usuario);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }

            ((UsuarioDto) res.getResultado("Usuario")).setUsuariosActivo("A");

            res = usuarioService.guardarUsuario(((UsuarioDto) res.getResultado("Usuario")));
            
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            
            return Response.ok((UsuarioDto) res.getResultado("Usuario")).build();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo al usuario").build();
        }
    }
}
