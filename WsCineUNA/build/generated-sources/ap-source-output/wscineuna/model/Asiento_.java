package wscineuna.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Salas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Asiento.class)
public class Asiento_ { 

    public static volatile SingularAttribute<Asiento, Salas> fkAsientoSalasId;
    public static volatile SingularAttribute<Asiento, String> asientoNumeroAsiento;
    public static volatile SingularAttribute<Asiento, String> asientoOcupado;
    public static volatile SingularAttribute<Asiento, BigDecimal> asientoId;
    public static volatile SingularAttribute<Asiento, String> asientoFila;

}