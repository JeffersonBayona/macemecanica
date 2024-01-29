package com.mycompany.macemecanica.models;

import com.mycompany.macemecanica.entitys.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "mace")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public long getTotalUsersByRol(String rol) {
        query = em.createQuery("SELECT COUNT(u) FROM Usuarios u WHERE u.rolIdrol.descripcionRol = :rol");
        query.setParameter("rol", rol);
        return (Long) query.getSingleResult();
    }
    
    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public List<Usuarios> login(String correo, String password){
        query = em.createQuery("SELECT u FROM Usuarios u WHERE u.emailUsuario = :email AND u.password = :password");
        query.setParameter("email", correo);
        query.setParameter("password", password);
        return query.getResultList();
    }
    
}
