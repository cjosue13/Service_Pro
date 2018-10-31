/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TB_ASIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asiento.findAll", query = "SELECT a FROM Asiento a")
    , @NamedQuery(name = "Asiento.findByAsientoId", query = "SELECT a FROM Asiento a WHERE a.asientoId = :asientoId")
    , @NamedQuery(name = "Asiento.findByAsientoFila", query = "SELECT a FROM Asiento a WHERE a.asientoFila = :asientoFila")
    , @NamedQuery(name = "Asiento.findByAsientoNumeroAsiento", query = "SELECT a FROM Asiento a WHERE a.asientoNumeroAsiento = :asientoNumeroAsiento")
    , @NamedQuery(name = "Asiento.findByAsientoOcupado", query = "SELECT a FROM Asiento a WHERE a.asientoOcupado = :asientoOcupado")})
public class Asiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIENTO_ID")
    private BigDecimal asientoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ASIENTO_FILA")
    private String asientoFila;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ASIENTO_NUMERO_ASIENTO")
    private String asientoNumeroAsiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ASIENTO_OCUPADO")
    private String asientoOcupado;
    @JoinColumn(name = "FK_ASIENTO_SALAS_ID", referencedColumnName = "SALAS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Salas fkAsientoSalasId;

    public Asiento() {
    }

    public Asiento(BigDecimal asientoId) {
        this.asientoId = asientoId;
    }

    public Asiento(BigDecimal asientoId, String asientoFila, String asientoNumeroAsiento, String asientoOcupado) {
        this.asientoId = asientoId;
        this.asientoFila = asientoFila;
        this.asientoNumeroAsiento = asientoNumeroAsiento;
        this.asientoOcupado = asientoOcupado;
    }

    public BigDecimal getAsientoId() {
        return asientoId;
    }

    public void setAsientoId(BigDecimal asientoId) {
        this.asientoId = asientoId;
    }

    public String getAsientoFila() {
        return asientoFila;
    }

    public void setAsientoFila(String asientoFila) {
        this.asientoFila = asientoFila;
    }

    public String getAsientoNumeroAsiento() {
        return asientoNumeroAsiento;
    }

    public void setAsientoNumeroAsiento(String asientoNumeroAsiento) {
        this.asientoNumeroAsiento = asientoNumeroAsiento;
    }

    public String getAsientoOcupado() {
        return asientoOcupado;
    }

    public void setAsientoOcupado(String asientoOcupado) {
        this.asientoOcupado = asientoOcupado;
    }

    public Salas getFkAsientoSalasId() {
        return fkAsientoSalasId;
    }

    public void setFkAsientoSalasId(Salas fkAsientoSalasId) {
        this.fkAsientoSalasId = fkAsientoSalasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asientoId != null ? asientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asiento)) {
            return false;
        }
        Asiento other = (Asiento) object;
        if ((this.asientoId == null && other.asientoId != null) || (this.asientoId != null && !this.asientoId.equals(other.asientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Asiento[ asientoId=" + asientoId + " ]";
    }
    
}
