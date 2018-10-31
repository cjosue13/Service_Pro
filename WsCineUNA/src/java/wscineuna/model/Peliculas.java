/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wscineuna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "TB_PELICULAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p")
    , @NamedQuery(name = "Peliculas.findByPeliculasId", query = "SELECT p FROM Peliculas p WHERE p.peliculasId = :peliculasId")
    , @NamedQuery(name = "Peliculas.findByPeliculasNombre", query = "SELECT p FROM Peliculas p WHERE p.peliculasNombre = :peliculasNombre")
    , @NamedQuery(name = "Peliculas.findByPeliculasRese\u00f1a", query = "SELECT p FROM Peliculas p WHERE p.peliculasRese\u00f1a = :peliculasRese\u00f1a")
    , @NamedQuery(name = "Peliculas.findByPeliculasLinkTrailer", query = "SELECT p FROM Peliculas p WHERE p.peliculasLinkTrailer = :peliculasLinkTrailer")
    , @NamedQuery(name = "Peliculas.findByPeliculasLinkImagen", query = "SELECT p FROM Peliculas p WHERE p.peliculasLinkImagen = :peliculasLinkImagen")
    , @NamedQuery(name = "Peliculas.findByPeliculasEstreno", query = "SELECT p FROM Peliculas p WHERE p.peliculasEstreno = :peliculasEstreno")
    , @NamedQuery(name = "Peliculas.findByPeliculasEstado", query = "SELECT p FROM Peliculas p WHERE p.peliculasEstado = :peliculasEstado")
    , @NamedQuery(name = "Peliculas.findByPeliculasIdioma", query = "SELECT p FROM Peliculas p WHERE p.peliculasIdioma = :peliculasIdioma")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PELICULAS_ID")
    private BigDecimal peliculasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PELICULAS_NOMBRE")
    private String peliculasNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1500)
    @Column(name = "PELICULAS_RESE\u00d1A")
    private String peliculasReseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PELICULAS_LINK_TRAILER")
    private String peliculasLinkTrailer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PELICULAS_LINK_IMAGEN")
    private String peliculasLinkImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PELICULAS_ESTRENO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date peliculasEstreno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PELICULAS_ESTADO")
    private String peliculasEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PELICULAS_IDIOMA")
    private String peliculasIdioma;
    @JoinColumn(name = "FK_PELICULAS_CINE_ID", referencedColumnName = "CINE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cine fkPeliculasCineId;
    @JoinColumn(name = "FK_PELICULAS_TANDAS_ID", referencedColumnName = "TANDAS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tandas fkPeliculasTandasId;

    public Peliculas() {
    }

    public Peliculas(BigDecimal peliculasId) {
        this.peliculasId = peliculasId;
    }

    public Peliculas(BigDecimal peliculasId, String peliculasNombre, String peliculasReseña, String peliculasLinkTrailer, String peliculasLinkImagen, Date peliculasEstreno, String peliculasEstado, String peliculasIdioma) {
        this.peliculasId = peliculasId;
        this.peliculasNombre = peliculasNombre;
        this.peliculasReseña = peliculasReseña;
        this.peliculasLinkTrailer = peliculasLinkTrailer;
        this.peliculasLinkImagen = peliculasLinkImagen;
        this.peliculasEstreno = peliculasEstreno;
        this.peliculasEstado = peliculasEstado;
        this.peliculasIdioma = peliculasIdioma;
    }

    public BigDecimal getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(BigDecimal peliculasId) {
        this.peliculasId = peliculasId;
    }

    public String getPeliculasNombre() {
        return peliculasNombre;
    }

    public void setPeliculasNombre(String peliculasNombre) {
        this.peliculasNombre = peliculasNombre;
    }

    public String getPeliculasReseña() {
        return peliculasReseña;
    }

    public void setPeliculasReseña(String peliculasReseña) {
        this.peliculasReseña = peliculasReseña;
    }

    public String getPeliculasLinkTrailer() {
        return peliculasLinkTrailer;
    }

    public void setPeliculasLinkTrailer(String peliculasLinkTrailer) {
        this.peliculasLinkTrailer = peliculasLinkTrailer;
    }

    public String getPeliculasLinkImagen() {
        return peliculasLinkImagen;
    }

    public void setPeliculasLinkImagen(String peliculasLinkImagen) {
        this.peliculasLinkImagen = peliculasLinkImagen;
    }

    public Date getPeliculasEstreno() {
        return peliculasEstreno;
    }

    public void setPeliculasEstreno(Date peliculasEstreno) {
        this.peliculasEstreno = peliculasEstreno;
    }

    public String getPeliculasEstado() {
        return peliculasEstado;
    }

    public void setPeliculasEstado(String peliculasEstado) {
        this.peliculasEstado = peliculasEstado;
    }

    public String getPeliculasIdioma() {
        return peliculasIdioma;
    }

    public void setPeliculasIdioma(String peliculasIdioma) {
        this.peliculasIdioma = peliculasIdioma;
    }

    public Cine getFkPeliculasCineId() {
        return fkPeliculasCineId;
    }

    public void setFkPeliculasCineId(Cine fkPeliculasCineId) {
        this.fkPeliculasCineId = fkPeliculasCineId;
    }

    public Tandas getFkPeliculasTandasId() {
        return fkPeliculasTandasId;
    }

    public void setFkPeliculasTandasId(Tandas fkPeliculasTandasId) {
        this.fkPeliculasTandasId = fkPeliculasTandasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculasId != null ? peliculasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.peliculasId == null && other.peliculasId != null) || (this.peliculasId != null && !this.peliculasId.equals(other.peliculasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wscineuna.model.Peliculas[ peliculasId=" + peliculasId + " ]";
    }
    
}
