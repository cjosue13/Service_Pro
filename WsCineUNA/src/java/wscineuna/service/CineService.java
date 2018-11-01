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
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wscineuna.model.Cine;
import wscineuna.model.CineDto;
import wscineuna.util.CodigoRespuesta;
import wscineuna.util.Respuesta;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
public class CineService {
private static final Logger LOG = Logger.getLogger(UsuarioService.class.getName());
    @PersistenceContext(unitName = "WsCineUNAPU")
    private EntityManager em;
    
    public Respuesta getCine(Long id) {
        try {
            
            Query qryEmpleado = em.createNamedQuery("Cine.findByCineId", Cine.class);
            qryEmpleado.setParameter("cineId", id);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Cine", new CineDto((Cine) qryEmpleado.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un Cine con el código ingresado.", "getCine NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el cine.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Cine.", "getCine NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

    public Respuesta guardarCine(CineDto cineDto) {
        try {
            Cine cine;
            if (cineDto.getCineId() != null && cineDto.getCineId() > 0) {
                
                cine = em.find(Cine.class, cineDto.getCineId());
                
                if (cine == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el cine a modificar.", "guardarCine NoResultException");
                }
                
                cine.actualizar(cineDto);
                cine = em.merge(cine);
            
            } else {
                cine = new Cine(cineDto);
                em.persist(cine);
            }
            
            em.flush();
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Cine", new CineDto(cine));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Cine.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Cine.", "guardarCine " + ex.getMessage());
        }
    }
}
