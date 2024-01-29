package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(MetodoPago.class)
public class MetodoPago_ { 

    public static volatile SingularAttribute<MetodoPago, String> metodoPago;
    public static volatile SingularAttribute<MetodoPago, String> descripcion;
    public static volatile ListAttribute<MetodoPago, Venta> ventaList;
    public static volatile SingularAttribute<MetodoPago, Integer> idmetodoPago;

}