/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "TB_COMPROBANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c")
    , @NamedQuery(name = "Comprobante.findByComprobanteId", query = "SELECT c FROM Comprobante c WHERE c.comprobanteId = :comprobanteId")
    , @NamedQuery(name = "Comprobante.findByComprobanteCosto", query = "SELECT c FROM Comprobante c WHERE c.comprobanteCosto = :comprobanteCosto")})
public class Comprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPROBANTE_ID")
    private BigDecimal comprobanteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPROBANTE_COSTO")
    private BigInteger comprobanteCosto;
    @JoinColumn(name = "FK_COMPROBANTE_REPORTES_ID", referencedColumnName = "REPORTES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reportes fkComprobanteReportesId;

    public Comprobante() {
    }

    public Comprobante(BigDecimal comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public Comprobante(BigDecimal comprobanteId, BigInteger comprobanteCosto) {
        this.comprobanteId = comprobanteId;
        this.comprobanteCosto = comprobanteCosto;
    }

    public BigDecimal getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(BigDecimal comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public BigInteger getComprobanteCosto() {
        return comprobanteCosto;
    }

    public void setComprobanteCosto(BigInteger comprobanteCosto) {
        this.comprobanteCosto = comprobanteCosto;
    }

    public Reportes getFkComprobanteReportesId() {
        return fkComprobanteReportesId;
    }

    public void setFkComprobanteReportesId(Reportes fkComprobanteReportesId) {
        this.fkComprobanteReportesId = fkComprobanteReportesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comprobanteId != null ? comprobanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.comprobanteId == null && other.comprobanteId != null) || (this.comprobanteId != null && !this.comprobanteId.equals(other.comprobanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Comprobante[ comprobanteId=" + comprobanteId + " ]";
    }
    
}
