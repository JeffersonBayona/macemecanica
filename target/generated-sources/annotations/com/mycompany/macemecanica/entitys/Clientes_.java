package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.entitys.Vehiculo;
import com.mycompany.macemecanica.entitys.Venta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> emailCliente;
    public static volatile SingularAttribute<Clientes, String> numDocumento;
    public static volatile SingularAttribute<Clientes, TiposDoc> tipoDocumento;
    public static volatile SingularAttribute<Clientes, Date> createdAt;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile SingularAttribute<Clientes, String> nombreCliente;
    public static volatile SingularAttribute<Clientes, String> apellidosCliente;
    public static volatile SingularAttribute<Clientes, String> telCliente;
    public static volatile ListAttribute<Clientes, Venta> ventaList;
    public static volatile SingularAttribute<Clientes, String> direccion;
    public static volatile ListAttribute<Clientes, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<Clientes, Date> updatedAt;

}