/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "TB_USUSARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuariosId", query = "SELECT u FROM Usuarios u WHERE u.usuariosId = :usuariosId")
    , @NamedQuery(name = "Usuarios.findByUsuariosNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuariosNombreUsuario = :usuariosNombreUsuario")
    , @NamedQuery(name = "Usuarios.findByUsuariosContrasenna", query = "SELECT u FROM Usuarios u WHERE u.usuariosContrasenna = :usuariosContrasenna")
    , @NamedQuery(name = "Usuarios.findByUsuariosContrasennaTemp", query = "SELECT u FROM Usuarios u WHERE u.usuariosContrasennaTemp = :usuariosContrasennaTemp")
    , @NamedQuery(name = "Usuarios.findByUsuariosNombre", query = "SELECT u FROM Usuarios u WHERE u.usuariosNombre = :usuariosNombre")
    , @NamedQuery(name = "Usuarios.findByUsuariosApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuariosApellidos = :usuariosApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuariosTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuariosTipoUsuario = :usuariosTipoUsuario")
    , @NamedQuery(name = "Usuarios.findByUsuariosCorreo", query = "SELECT u FROM Usuarios u WHERE u.usuariosCorreo = :usuariosCorreo")
    , @NamedQuery(name = "Usuarios.findByUsuariosActivo", query = "SELECT u FROM Usuarios u WHERE u.usuariosActivo = :usuariosActivo")
    , @NamedQuery(name = "Usuarios.findByUsuClave", query = "SELECT u FROM Usuarios u WHERE u.usuariosContrasenna = :usuariosContrasenna AND u.usuariosNombreUsuario = :usuariosNombreUsuario")
    })
public class Usuarios implements Serializable {

    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 70)
    @Column(name = "USUARIOS_CONTRASENNA")
    private String usuariosContrasenna;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 70)
    @Column(name = "USUARIOS_CONTRASENNA_TEMP")
    private String usuariosContrasennaTemp;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "USUARIOS_ID")
    private Long usuariosId;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 70)
    @Column(name = "USUARIOS_NOMBRE_USUARIO")
    private String usuariosNombreUsuario;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 70)
    //@NotNull
    //@Size(min = 1, max = 70)
    @Column(name = "USUARIOS_NOMBRE")
    private String usuariosNombre;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "USUARIOS_APELLIDOS")
    private String usuariosApellidos;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 1)
    @Column(name = "USUARIOS_TIPO_USUARIO")
    private String usuariosTipoUsuario;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(name = "USUARIOS_CORREO")
    private String usuariosCorreo;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 1)
    @Column(name = "USUARIOS_ACTIVO")
    private String usuariosActivo;
    @JoinColumn(name = "FK_USUARIOS_CINE_ID", referencedColumnName = "CINE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cine fkUsuariosCineId;

    public Usuarios() {
    }
    public Usuarios(UsuarioDto usuario) {
        this.usuariosId = usuario.getUsuariosId();
        actualizar(usuario);
    }
    public void actualizar(UsuarioDto usuario){
        this.usuariosActivo = usuario.getUsuariosActivo();
        this.usuariosApellidos = usuario.getUsuariosApellidos();
        this.usuariosContrasenna = usuario.getUsuariosContraseña();
        this.usuariosContrasennaTemp= usuario.getUsuariosContraseñaTemp();
        this.usuariosCorreo = usuario.getUsuariosCorreo();
        this.usuariosNombre = usuario.getUsuariosNombre();
        this.usuariosNombreUsuario = usuario.getUsuariosNombreUsuario();
        this.usuariosTipoUsuario = usuario.getUsuariosTipoUsuario();
        
    }
    public Usuarios(Long usuariosId) {
        this.usuariosId = usuariosId;
    }
  
    public Usuarios(Long usuariosId, String usuariosNombreUsuario, String usuariosContraseña, String usuariosContraseñaTemp, String usuariosNombre, String usuariosApellidos, String usuariosTipoUsuario, String usuariosCorreo, String usuariosActivo) {
        this.usuariosId = usuariosId;
        this.usuariosNombreUsuario = usuariosNombreUsuario;
        this.usuariosContrasenna = usuariosContraseña;
        this.usuariosContrasennaTemp = usuariosContraseñaTemp;
        this.usuariosNombre = usuariosNombre;
        this.usuariosApellidos = usuariosApellidos;
        this.usuariosTipoUsuario = usuariosTipoUsuario;
        this.usuariosCorreo = usuariosCorreo;
        this.usuariosActivo = usuariosActivo;
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
        return usuariosContrasenna;
    }

    public void setUsuariosContraseña(String usuariosContraseña) {
        this.usuariosContrasenna = usuariosContraseña;
    }

    public String getUsuariosContraseñaTemp() {
        return usuariosContrasennaTemp;
    }

    public void setUsuariosContraseñaTemp(String usuariosContraseñaTemp) {
        this.usuariosContrasennaTemp = usuariosContraseñaTemp;
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

    public Cine getFkUsuariosCineId() {
        return fkUsuariosCineId;
    }

    public void setFkUsuariosCineId(Cine fkUsuariosCineId) {
        this.fkUsuariosCineId = fkUsuariosCineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosId != null ? usuariosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosId == null && other.usuariosId != null) || (this.usuariosId != null && !this.usuariosId.equals(other.usuariosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Usuarios[ usuariosId=" + usuariosId + " ]";
    }
}
