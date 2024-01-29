package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Productos;
import com.mycompany.macemecanica.entitys.Proveedor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fechaCompra;
    public static volatile SingularAttribute<Compras, Date> createdAt;
    public static volatile SingularAttribute<Compras, BigDecimal> valorProducto;
    public static volatile SingularAttribute<Compras, Integer> idCompra;
    public static volatile SingularAttribute<Compras, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Compras, Proveedor> proveedorIdproveedor;
    public static volatile SingularAttribute<Compras, Productos> productosIdproductos;
    public static volatile SingularAttribute<Compras, Integer> cantidad;
    public static volatile SingularAttribute<Compras, String> facturaCompra;
    public static volatile SingularAttribute<Compras, Date> updatedAt;

}