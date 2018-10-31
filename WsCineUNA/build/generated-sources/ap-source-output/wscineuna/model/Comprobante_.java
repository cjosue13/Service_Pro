package wscineuna.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Reportes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Comprobante.class)
public class Comprobante_ { 

    public static volatile SingularAttribute<Comprobante, BigDecimal> comprobanteId;
    public static volatile SingularAttribute<Comprobante, Reportes> fkComprobanteReportesId;
    public static volatile SingularAttribute<Comprobante, BigInteger> comprobanteCosto;

}