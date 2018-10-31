/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_TANDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tandas.findAll", query = "SELECT t FROM Tandas t")
    , @NamedQuery(name = "Tandas.findByTandasId", query = "SELECT t FROM Tandas t WHERE t.tandasId = :tandasId")
    , @NamedQuery(name = "Tandas.findByTandasPrecio", query = "SELECT t FROM Tandas t WHERE t.tandasPrecio = :tandasPrecio")
    , @NamedQuery(name = "Tandas.findByTandasFechaInicio", query = "SELECT t FROM Tandas t WHERE t.tandasFechaInicio = :tandasFechaInicio")
    , @NamedQuery(name = "Tandas.findByTandasFechaFin", query = "SELECT t FROM Tandas t WHERE t.tandasFechaFin = :tandasFechaFin")
    , @NamedQuery(name = "Tandas.findByTandasHoraInicio", query = "SELECT t FROM Tandas t WHERE t.tandasHoraInicio = :tandasHoraInicio")
    , @NamedQuery(name = "Tandas.findByTandasHoraFin", query = "SELECT t FROM Tandas t WHERE t.tandasHoraFin = :tandasHoraFin")})
public class Tandas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANDAS_ID")
    private BigDecimal tandasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANDAS_PRECIO")
    private BigInteger tandasPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANDAS_FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tandasFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANDAS_FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tandasFechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANDAS_HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tandasHoraInicio;
    @Column(name = "TANDAS_HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tandasHoraFin;
    @OneToMany(mappedBy = "fkPeliculasTandasId", fetch = FetchType.LAZY)
    private List<Peliculas> peliculasList;
    @JoinColumn(name = "FK_TANDAS_SALAS_ID", referencedColumnName = "SALAS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Salas fkTandasSalasId;

    public Tandas() {
    }

    public Tandas(BigDecimal tandasId) {
        this.tandasId = tandasId;
    }

    public Tandas(BigDecimal tandasId, BigInteger tandasPrecio, Date tandasFechaInicio, Date tandasFechaFin, Date tandasHoraInicio) {
        this.tandasId = tandasId;
        this.tandasPrecio = tandasPrecio;
        this.tandasFechaInicio = tandasFechaInicio;
        this.tandasFechaFin = tandasFechaFin;
        this.tandasHoraInicio = tandasHoraInicio;
    }

    public BigDecimal getTandasId() {
        return tandasId;
    }

    public void setTandasId(BigDecimal tandasId) {
        this.tandasId = tandasId;
    }

    public BigInteger getTandasPrecio() {
        return tandasPrecio;
    }

    public void setTandasPrecio(BigInteger tandasPrecio) {
        this.tandasPrecio = tandasPrecio;
    }

    public Date getTandasFechaInicio() {
        return tandasFechaInicio;
    }

    public void setTandasFechaInicio(Date tandasFechaInicio) {
        this.tandasFechaInicio = tandasFechaInicio;
    }

    public Date getTandasFechaFin() {
        return tandasFechaFin;
    }

    public void setTandasFechaFin(Date tandasFechaFin) {
        this.tandasFechaFin = tandasFechaFin;
    }

    public Date getTandasHoraInicio() {
        return tandasHoraInicio;
    }

    public void setTandasHoraInicio(Date tandasHoraInicio) {
        this.tandasHoraInicio = tandasHoraInicio;
    }

    public Date getTandasHoraFin() {
        return tandasHoraFin;
    }

    public void setTandasHoraFin(Date tandasHoraFin) {
        this.tandasHoraFin = tandasHoraFin;
    }

    @XmlTransient
    public List<Peliculas> getPeliculasList() {
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
    }

    public Salas getFkTandasSalasId() {
        return fkTandasSalasId;
    }

    public void setFkTandasSalasId(Salas fkTandasSalasId) {
        this.fkTandasSalasId = fkTandasSalasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tandasId != null ? tandasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tandas)) {
            return false;
        }
        Tandas other = (Tandas) object;
        if ((this.tandasId == null && other.tandasId != null) || (this.tandasId != null && !this.tandasId.equals(other.tandasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Tandas[ tandasId=" + tandasId + " ]";
    }
    
}
