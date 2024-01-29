package com.mycompany.macemecanica.entitys;

import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.entitys.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-24T20:52:37")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> nombreRazonSocial;
    public static volatile SingularAttribute<Empresa, String> mailEmpresa;
    public static volatile SingularAttribute<Empresa, TiposDoc> tipoDocumento;
    public static volatile SingularAttribute<Empresa, String> numDocumento;
    public static volatile SingularAttribute<Empresa, Integer> idempresa;
    public static volatile SingularAttribute<Empresa, String> direccionEmpresa;
    public static volatile ListAttribute<Empresa, Venta> ventaList;
    public static volatile SingularAttribute<Empresa, String> telEmpresa;

}