/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wscineuna.model.UsuarioDto;
import wscineuna.model.Usuarios;
import wscineuna.util.CodigoRespuesta;
import wscineuna.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
public class UsuarioService {
    private static final Logger LOG = Logger.getLogger(UsuarioService.class.getName());
    @PersistenceContext(unitName = "WsCineUNAPU")
    private EntityManager em;
    
    public Respuesta guardarUsuario(UsuarioDto usuarioDto) {
        try {
            Usuarios usuario; 
            if (usuarioDto.getUsuariosId() != null && usuarioDto.getUsuariosId() > 0) {
                
                usuario = em.find(Usuarios.class, usuarioDto.getUsuariosId());
                
                if (usuario == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el usuario a modificar.", "guardarUsuario NoResultException");
                }
                
                usuario.actualizar(usuarioDto);
                usuario = em.merge(usuario);
            
            } else {
                usuario = new Usuarios(usuarioDto);
                em.persist(usuario);
            }
            
            em.flush();
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Usuario", new UsuarioDto(usuario));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el usuario.", "guardarUsuario " + ex.getMessage());
        }
    }
}
