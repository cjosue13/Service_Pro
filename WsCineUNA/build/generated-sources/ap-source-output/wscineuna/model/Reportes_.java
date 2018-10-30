package wscineuna.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Cine;
import wscineuna.model.Comprobante;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Reportes.class)
public class Reportes_ { 

    public static volatile SingularAttribute<Reportes, BigInteger> reportesCantPersonas;
    public static volatile SingularAttribute<Reportes, Cine> fkReportesCineId;
    public static volatile SingularAttribute<Reportes, Date> reportesFecha;
    public static volatile SingularAttribute<Reportes, BigDecimal> reportesId;
    public static volatile ListAttribute<Reportes, Comprobante> comprobanteList;

}