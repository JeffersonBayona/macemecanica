package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Empresa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }
    
}
