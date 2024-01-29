package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Clientes;
import com.mycompany.macemecanica.entitys.Empresa;
import com.mycompany.macemecanica.entitys.MetodoPago;
import com.mycompany.macemecanica.entitys.VentaHasProductos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Date> createdAt;
    public static volatile SingularAttribute<Venta, MetodoPago> metodoPagoIdmetodoPago;
    public static volatile SingularAttribute<Venta, Empresa> empresaIdempresa;
    public static volatile ListAttribute<Venta, VentaHasProductos> ventaHasProductosL;
    public static volatile SingularAttribute<Venta, Long> valorTotalVenta;
    public static volatile SingularAttribute<Venta, Clientes> clientesidCliente;
    public static volatile SingularAttribute<Venta, Date> fechaVenta;
    public static volatile SingularAttribute<Venta, Date> updatedAt;

}