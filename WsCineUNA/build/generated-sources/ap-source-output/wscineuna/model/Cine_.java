package wscineuna.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Peliculas;
import wscineuna.model.Reportes;
import wscineuna.model.Salas;
import wscineuna.model.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Cine.class)
public class Cine_ { 

    public static volatile SingularAttribute<Cine, Long> cineTelefono;
    public static volatile SingularAttribute<Cine, Date> cineHoraInicio;
    public static volatile ListAttribute<Cine, Salas> salasList;
    public static volatile ListAttribute<Cine, Usuarios> usuariosList;
    public static volatile SingularAttribute<Cine, Long> cineId;
    public static volatile SingularAttribute<Cine, String> cineCorreo;
    public static volatile ListAttribute<Cine, Peliculas> peliculasList;
    public static volatile SingularAttribute<Cine, Date> cineHoraCierre;
    public static volatile SingularAttribute<Cine, String> cineNombre;
    public static volatile ListAttribute<Cine, Reportes> reportesList;

}