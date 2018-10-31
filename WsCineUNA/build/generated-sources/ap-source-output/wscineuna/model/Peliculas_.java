package wscineuna.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Cine;
import wscineuna.model.Tandas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Peliculas.class)
public class Peliculas_ { 

    public static volatile SingularAttribute<Peliculas, BigDecimal> peliculasId;
    public static volatile SingularAttribute<Peliculas, Tandas> fkPeliculasTandasId;
    public static volatile SingularAttribute<Peliculas, String> peliculasLinkTrailer;
    public static volatile SingularAttribute<Peliculas, Cine> fkPeliculasCineId;
    public static volatile SingularAttribute<Peliculas, String> peliculasNombre;
    public static volatile SingularAttribute<Peliculas, String> peliculasIdioma;
    public static volatile SingularAttribute<Peliculas, String> peliculasReseña;
    public static volatile SingularAttribute<Peliculas, String> peliculasEstado;
    public static volatile SingularAttribute<Peliculas, String> peliculasLinkImagen;
    public static volatile SingularAttribute<Peliculas, Date> peliculasEstreno;

}