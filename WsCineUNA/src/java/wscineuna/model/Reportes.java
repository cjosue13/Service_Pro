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
@Table(name = "TB_REPORTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportes.findAll", query = "SELECT r FROM Reportes r")
    , @NamedQuery(name = "Reportes.findByReportesId", query = "SELECT r FROM Reportes r WHERE r.reportesId = :reportesId")
    , @NamedQuery(name = "Reportes.findByReportesCantPersonas", query = "SELECT r FROM Reportes r WHERE r.reportesCantPersonas = :reportesCantPersonas")
    , @NamedQuery(name = "Reportes.findByReportesFecha", query = "SELECT r FROM Reportes r WHERE r.reportesFecha = :reportesFecha")})
public class Reportes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORTES_ID")
    private BigDecimal reportesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORTES_CANT_PERSONAS")
    private BigInteger reportesCantPersonas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORTES_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportesFecha;
    @OneToMany(mappedBy = "fkComprobanteReportesId", fetch = FetchType.LAZY)
    private List<Comprobante> comprobanteList;
    @JoinColumn(name = "FK_REPORTES_CINE_ID", referencedColumnName = "CINE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cine fkReportesCineId;

    public Reportes() {
    }

    public Reportes(BigDecimal reportesId) {
        this.reportesId = reportesId;
    }

    public Reportes(BigDecimal reportesId, BigInteger reportesCantPersonas, Date reportesFecha) {
        this.reportesId = reportesId;
        this.reportesCantPersonas = reportesCantPersonas;
        this.reportesFecha = reportesFecha;
    }

    public BigDecimal getReportesId() {
        return reportesId;
    }

    public void setReportesId(BigDecimal reportesId) {
        this.reportesId = reportesId;
    }

    public BigInteger getReportesCantPersonas() {
        return reportesCantPersonas;
    }

    public void setReportesCantPersonas(BigInteger reportesCantPersonas) {
        this.reportesCantPersonas = reportesCantPersonas;
    }

    public Date getReportesFecha() {
        return reportesFecha;
    }

    public void setReportesFecha(Date reportesFecha) {
        this.reportesFecha = reportesFecha;
    }

    @XmlTransient
    public List<Comprobante> getComprobanteList() {
        return comprobanteList;
    }

    public void setComprobanteList(List<Comprobante> comprobanteList) {
        this.comprobanteList = comprobanteList;
    }

    public Cine getFkReportesCineId() {
        return fkReportesCineId;
    }

    public void setFkReportesCineId(Cine fkReportesCineId) {
        this.fkReportesCineId = fkReportesCineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportesId != null ? reportesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportes)) {
            return false;
        }
        Reportes other = (Reportes) object;
        if ((this.reportesId == null && other.reportesId != null) || (this.reportesId != null && !this.reportesId.equals(other.reportesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Reportes[ reportesId=" + reportesId + " ]";
    }
    
}
