/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "TB_CINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cine.findAll", query = "SELECT c FROM Cine c")
    , @NamedQuery(name = "Cine.findByCineId", query = "SELECT c FROM Cine c WHERE c.cineId = :cineId")
    , @NamedQuery(name = "Cine.findByCineTelefono", query = "SELECT c FROM Cine c WHERE c.cineTelefono = :cineTelefono")
    , @NamedQuery(name = "Cine.findByCineCorreo", query = "SELECT c FROM Cine c WHERE c.cineCorreo = :cineCorreo")
    , @NamedQuery(name = "Cine.findByCineHoraInicio", query = "SELECT c FROM Cine c WHERE c.cineHoraInicio = :cineHoraInicio")
    , @NamedQuery(name = "Cine.findByCineHoraCierre", query = "SELECT c FROM Cine c WHERE c.cineHoraCierre = :cineHoraCierre")
    , @NamedQuery(name = "Cine.findByCineNombre", query = "SELECT c FROM Cine c WHERE c.cineNombre = :cineNombre")})
public class Cine implements Serializable {

    @Basic(optional = false)
    //@NotNull
    @Column(name = "CINE_TELEFONO")
    private Long cineTelefono;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "CINE_ID")
    private Long cineId;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 70)
    @Column(name = "CINE_CORREO")
    private String cineCorreo;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "CINE_HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cineHoraInicio;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "CINE_HORA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cineHoraCierre;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 40)
    @Column(name = "CINE_NOMBRE")
    private String cineNombre;
    @OneToMany(mappedBy = "fkPeliculasCineId", fetch = FetchType.LAZY)
    private List<Peliculas> peliculasList;
    @OneToMany(mappedBy = "fkReportesCineId", fetch = FetchType.LAZY)
    private List<Reportes> reportesList;
    @OneToMany(mappedBy = "fkSalasCineId", fetch = FetchType.LAZY)
    private List<Salas> salasList;
    @OneToMany(mappedBy = "fkUsuariosCineId", fetch = FetchType.LAZY)
    private List<Usuarios> usuariosList;

    public Cine() {
        
    }

    public Cine(Long cineId) {
        this.cineId = cineId;
    }

    public Cine(Long cineId, Long cineTelefono, String cineCorreo, Date cineHoraInicio, Date cineHoraCierre, String cineNombre) {
        this.cineId = cineId;
        this.cineTelefono = cineTelefono;
        this.cineCorreo = cineCorreo;
        this.cineHoraInicio = cineHoraInicio;
        this.cineHoraCierre = cineHoraCierre;
        this.cineNombre = cineNombre;
    }

    public Long getCineId() {
        return cineId;
    }

    public void setCineId(Long cineId) {
        this.cineId = cineId;
    }

    public Long getCineTelefono() {
        return cineTelefono;
    }

    public void setCineTelefono(Long cineTelefono) {
        this.cineTelefono = cineTelefono;
    }

    public String getCineCorreo() {
        return cineCorreo;
    }

    public void setCineCorreo(String cineCorreo) {
        this.cineCorreo = cineCorreo;
    }

    public Date getCineHoraInicio() {
        return cineHoraInicio;
    }

    public void setCineHoraInicio(Date cineHoraInicio) {
        this.cineHoraInicio = cineHoraInicio;
    }

    public Date getCineHoraCierre() {
        return cineHoraCierre;
    }

    public void setCineHoraCierre(Date cineHoraCierre) {
        this.cineHoraCierre = cineHoraCierre;
    }

    public String getCineNombre() {
        return cineNombre;
    }

    public void setCineNombre(String cineNombre) {
        this.cineNombre = cineNombre;
    }

    @XmlTransient
    public List<Peliculas> getPeliculasList() {
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
    }

    @XmlTransient
    public List<Reportes> getReportesList() {
        return reportesList;
    }

    public void setReportesList(List<Reportes> reportesList) {
        this.reportesList = reportesList;
    }

    @XmlTransient
    public List<Salas> getSalasList() {
        return salasList;
    }

    public void setSalasList(List<Salas> salasList) {
        this.salasList = salasList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cineId != null ? cineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cine)) {
            return false;
        }
        Cine other = (Cine) object;
        if ((this.cineId == null && other.cineId != null) || (this.cineId != null && !this.cineId.equals(other.cineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Cine[ cineId=" + cineId + " ]";
    }

    
    
}
