package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Compras;
import com.mycompany.macemecanica.entitys.TiposDoc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> nombreProveedor;
    public static volatile SingularAttribute<Proveedor, Integer> idproveedor;
    public static volatile SingularAttribute<Proveedor, TiposDoc> tipoDocumento;
    public static volatile SingularAttribute<Proveedor, Date> createdAt;
    public static volatile SingularAttribute<Proveedor, String> numIdentificacion;
    public static volatile ListAttribute<Proveedor, Compras> comprasList;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile SingularAttribute<Proveedor, String> emailProveedor;
    public static volatile SingularAttribute<Proveedor, String> telProveedor;
    public static volatile SingularAttribute<Proveedor, Date> updatedAt;

}