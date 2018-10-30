/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "TB_SALAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s")
    , @NamedQuery(name = "Salas.findBySalasId", query = "SELECT s FROM Salas s WHERE s.salasId = :salasId")
    , @NamedQuery(name = "Salas.findBySalasNombreSala", query = "SELECT s FROM Salas s WHERE s.salasNombreSala = :salasNombreSala")})
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALAS_ID")
    private BigDecimal salasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "SALAS_NOMBRE_SALA")
    private String salasNombreSala;
    @OneToMany(mappedBy = "fkAsientoSalasId", fetch = FetchType.LAZY)
    private List<Asiento> asientoList;
    @JoinColumn(name = "FK_SALAS_CINE_ID", referencedColumnName = "CINE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cine fkSalasCineId;
    @OneToMany(mappedBy = "fkTandasSalasId", fetch = FetchType.LAZY)
    private List<Tandas> tandasList;

    public Salas() {
    }

    public Salas(BigDecimal salasId) {
        this.salasId = salasId;
    }

    public Salas(BigDecimal salasId, String salasNombreSala) {
        this.salasId = salasId;
        this.salasNombreSala = salasNombreSala;
    }

    public BigDecimal getSalasId() {
        return salasId;
    }

    public void setSalasId(BigDecimal salasId) {
        this.salasId = salasId;
    }

    public String getSalasNombreSala() {
        return salasNombreSala;
    }

    public void setSalasNombreSala(String salasNombreSala) {
        this.salasNombreSala = salasNombreSala;
    }

    @XmlTransient
    public List<Asiento> getAsientoList() {
        return asientoList;
    }

    public void setAsientoList(List<Asiento> asientoList) {
        this.asientoList = asientoList;
    }

    public Cine getFkSalasCineId() {
        return fkSalasCineId;
    }

    public void setFkSalasCineId(Cine fkSalasCineId) {
        this.fkSalasCineId = fkSalasCineId;
    }

    @XmlTransient
    public List<Tandas> getTandasList() {
        return tandasList;
    }

    public void setTandasList(List<Tandas> tandasList) {
        this.tandasList = tandasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salasId != null ? salasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.salasId == null && other.salasId != null) || (this.salasId != null && !this.salasId.equals(other.salasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Salas[ salasId=" + salasId + " ]";
    }
    
}
