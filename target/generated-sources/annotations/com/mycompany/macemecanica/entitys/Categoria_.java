package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile ListAttribute<Categoria, Productos> productosList;
    public static volatile SingularAttribute<Categoria, Integer> idcategoria;
    public static volatile SingularAttribute<Categoria, String> nomCategoria;

}