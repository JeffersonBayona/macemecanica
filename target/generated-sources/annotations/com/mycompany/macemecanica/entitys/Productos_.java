package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Categoria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Date> createdAt;
    public static volatile SingularAttribute<Productos, Categoria> categoriaIdcategoria;
    public static volatile SingularAttribute<Productos, String> codProducto;
    public static volatile SingularAttribute<Productos, Integer> idproductos;
    public static volatile SingularAttribute<Productos, Long> valorProducto;
    public static volatile SingularAttribute<Productos, Integer> stock;
    public static volatile SingularAttribute<Productos, String> referencia;
    public static volatile SingularAttribute<Productos, String> nombreProducto;
    public static volatile SingularAttribute<Productos, Date> updatedAt;

}