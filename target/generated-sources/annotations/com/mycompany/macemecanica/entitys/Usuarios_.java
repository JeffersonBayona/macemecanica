package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Rol;
import com.mycompany.macemecanica.entitys.TiposDoc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> numDocumento;
    public static volatile SingularAttribute<Usuarios, Integer> idusuarios;
    public static volatile SingularAttribute<Usuarios, String> direccion;
    public static volatile SingularAttribute<Usuarios, String> telusuario;
    public static volatile SingularAttribute<Usuarios, String> confirmarPassword;
    public static volatile SingularAttribute<Usuarios, String> nombreusuario;
    public static volatile SingularAttribute<Usuarios, TiposDoc> tipoDocumento;
    public static volatile SingularAttribute<Usuarios, Date> createdAt;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> emailUsuario;
    public static volatile SingularAttribute<Usuarios, String> apellidosusuario;
    public static volatile SingularAttribute<Usuarios, Rol> rolIdrol;
    public static volatile SingularAttribute<Usuarios, Date> updatedAt;

}