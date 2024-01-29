package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Clientes;
import com.mycompany.macemecanica.entitys.ServiciosPorVehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile ListAttribute<Vehiculo, ServiciosPorVehiculo> serviciosPorVehiculoList;
    public static volatile SingularAttribute<Vehiculo, Integer> idVehiculo;
    public static volatile SingularAttribute<Vehiculo, Clientes> clienteidCliente;
    public static volatile SingularAttribute<Vehiculo, String> tipoVehiculo;
    public static volatile SingularAttribute<Vehiculo, String> numeroPlaca;

}