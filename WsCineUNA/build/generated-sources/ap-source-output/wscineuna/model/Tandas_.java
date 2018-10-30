package wscineuna.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Peliculas;
import wscineuna.model.Salas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Tandas.class)
public class Tandas_ { 

    public static volatile SingularAttribute<Tandas, Date> tandasFechaInicio;
    public static volatile SingularAttribute<Tandas, BigInteger> tandasPrecio;
    public static volatile SingularAttribute<Tandas, Salas> fkTandasSalasId;
    public static volatile SingularAttribute<Tandas, Date> tandasHoraFin;
    public static volatile SingularAttribute<Tandas, BigDecimal> tandasId;
    public static volatile SingularAttribute<Tandas, Date> tandasHoraInicio;
    public static volatile SingularAttribute<Tandas, Date> tandasFechaFin;
    public static volatile ListAttribute<Tandas, Peliculas> peliculasList;

}