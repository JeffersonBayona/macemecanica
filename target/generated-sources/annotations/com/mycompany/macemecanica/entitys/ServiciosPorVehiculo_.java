package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Servicios;
import com.mycompany.macemecanica.entitys.Vehiculo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(ServiciosPorVehiculo.class)
public class ServiciosPorVehiculo_ { 

    public static volatile SingularAttribute<ServiciosPorVehiculo, Servicios> serviciosidServicio;
    public static volatile SingularAttribute<ServiciosPorVehiculo, Date> fechaServicio;
    public static volatile SingularAttribute<ServiciosPorVehiculo, Vehiculo> vehiculoidVehiculo;
    public static volatile SingularAttribute<ServiciosPorVehiculo, BigDecimal> varorServicio;
    public static volatile SingularAttribute<ServiciosPorVehiculo, Integer> idServiciosporVehiculo;

}