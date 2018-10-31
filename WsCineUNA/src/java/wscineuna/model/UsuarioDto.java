/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */

@XmlRootElement( name= "UsuarioDto" )
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDto {
    
    private Long usuariosId;
    private String usuariosNombreUsuario;
    private String usuariosContraseña;
    private String usuariosContraseñaTemp;
    private String usuariosNombre;
    private String usuariosApellidos;
    private String usuariosTipoUsuario;
    private String usuariosCorreo;
    private String usuariosActivo;
    private CineDto fkUsuariosCineId;
    
    public UsuarioDto(Usuarios usuario){
        this.usuariosId = usuario.getUsuariosId();
        if(usuario.getFkUsuariosCineId()!=null)
        this.fkUsuariosCineId = new CineDto(usuario.getFkUsuariosCineId());
        actualizar(usuario);
    }
    public void actualizar(Usuarios usuario){
        this.usuariosActivo = usuario.getUsuariosActivo();
        this.usuariosApellidos = usuario.getUsuariosApellidos();
        this.usuariosContraseña = usuario.getUsuariosContraseña();
        this.usuariosContraseñaTemp = usuario.getUsuariosContraseñaTemp();
        this.usuariosCorreo = usuario.getUsuariosCorreo();
        this.usuariosTipoUsuario = usuario.getUsuariosTipoUsuario();     
    }
    public Long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Long usuariosId) {
        this.usuariosId = usuariosId;
    }

    public String getUsuariosNombreUsuario() {
        return usuariosNombreUsuario;
    }

    public void setUsuariosNombreUsuario(String usuariosNombreUsuario) {
        this.usuariosNombreUsuario = usuariosNombreUsuario;
    }

    public String getUsuariosContraseña() {
        return usuariosContraseña;
    }

    public void setUsuariosContraseña(String usuariosContraseña) {
        this.usuariosContraseña = usuariosContraseña;
    }

    public String getUsuariosContraseñaTemp() {
        return usuariosContraseñaTemp;
    }

    public void setUsuariosContraseñaTemp(String usuariosContraseñaTemp) {
        this.usuariosContraseñaTemp = usuariosContraseñaTemp;
    }

    public String getUsuariosNombre() {
        return usuariosNombre;
    }

    public void setUsuariosNombre(String usuariosNombre) {
        this.usuariosNombre = usuariosNombre;
    }

    public String getUsuariosApellidos() {
        return usuariosApellidos;
    }

    public void setUsuariosApellidos(String usuariosApellidos) {
        this.usuariosApellidos = usuariosApellidos;
    }

    public String getUsuariosTipoUsuario() {
        return usuariosTipoUsuario;
    }

    public void setUsuariosTipoUsuario(String usuariosTipoUsuario) {
        this.usuariosTipoUsuario = usuariosTipoUsuario;
    }

    public String getUsuariosCorreo() {
        return usuariosCorreo;
    }

    public void setUsuariosCorreo(String usuariosCorreo) {
        this.usuariosCorreo = usuariosCorreo;
    }

    public String getUsuariosActivo() {
        return usuariosActivo;
    }

    public void setUsuariosActivo(String usuariosActivo) {
        this.usuariosActivo = usuariosActivo;
    }

    public CineDto getFkUsuariosCineId() {
        return fkUsuariosCineId;
    }

    public void setFkUsuariosCineId(CineDto fkUsuariosCineId) {
        this.fkUsuariosCineId = fkUsuariosCineId;
    }
}
