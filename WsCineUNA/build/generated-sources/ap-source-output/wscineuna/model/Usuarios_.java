package wscineuna.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import wscineuna.model.Cine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-29T23:32:33")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> usuariosContraseñaTemp;
    public static volatile SingularAttribute<Usuarios, String> usuariosNombre;
    public static volatile SingularAttribute<Usuarios, Cine> fkUsuariosCineId;
    public static volatile SingularAttribute<Usuarios, String> usuariosContraseña;
    public static volatile SingularAttribute<Usuarios, String> usuariosTipoUsuario;
    public static volatile SingularAttribute<Usuarios, String> usuariosCorreo;
    public static volatile SingularAttribute<Usuarios, Long> usuariosId;
    public static volatile SingularAttribute<Usuarios, String> usuariosNombreUsuario;
    public static volatile SingularAttribute<Usuarios, String> usuariosApellidos;
    public static volatile SingularAttribute<Usuarios, String> usuariosActivo;

}