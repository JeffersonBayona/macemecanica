package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.ServiciosPorVehiculo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile SingularAttribute<Servicios, String> descripcionServicio;
    public static volatile ListAttribute<Servicios, ServiciosPorVehiculo> serviciosPorVehiculoList;
    public static volatile SingularAttribute<Servicios, Integer> idservicios;
    public static volatile SingularAttribute<Servicios, BigDecimal> valor;

}