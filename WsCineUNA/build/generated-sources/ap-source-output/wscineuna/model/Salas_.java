package wscineuna.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Asiento;
import wscineuna.model.Cine;
import wscineuna.model.Tandas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Salas.class)
public class Salas_ { 

    public static volatile ListAttribute<Salas, Asiento> asientoList;
    public static volatile SingularAttribute<Salas, String> salasNombreSala;
    public static volatile ListAttribute<Salas, Tandas> tandasList;
    public static volatile SingularAttribute<Salas, Cine> fkSalasCineId;
    public static volatile SingularAttribute<Salas, BigDecimal> salasId;

}