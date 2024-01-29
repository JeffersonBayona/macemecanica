package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Productos;
import com.mycompany.macemecanica.entitys.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(VentaHasProductos.class)
public class VentaHasProductos_ { 

    public static volatile SingularAttribute<VentaHasProductos, Productos> productosIdproductos;
    public static volatile SingularAttribute<VentaHasProductos, Integer> cantidad;
    public static volatile SingularAttribute<VentaHasProductos, Venta> ventaIdventa;
    public static volatile SingularAttribute<VentaHasProductos, Integer> idventaHasProductoscol;

}