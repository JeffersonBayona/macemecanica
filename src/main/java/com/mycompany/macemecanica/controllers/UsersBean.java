package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Rol;
import com.mycompany.macemecanica.entitys.TiposDoc;
import com.mycompany.macemecanica.entitys.Usuarios;
import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.models.RolFacade;
import com.mycompany.macemecanica.models.UsuariosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usersBean")
@SessionScoped
public class UsersBean implements Serializable {

    @EJB
    private UsuariosFacade usuariosfacade;
    private String tipoDocSelect;
    private Usuarios usuarios = new Usuarios();
    @EJB
    private RolFacade rolfacade;
    private Integer rolselect;
    @Inject
    private MessagesBean messageBean;

    public UsersBean() {
    }

    public TiposDoc[] getTipoDocs() {
        return TiposDoc.values();
    }

    public List<Usuarios> findAll() {
        return usuariosfacade.findAll();
    }

    public void clean() {
        usuarios = new Usuarios();
    }

    public void save() {
        Rol rol = new Rol();
        rol.setIdrol(rolselect);
        usuarios.setRolIdrol(rol);
        usuarios.setTipoDocumento(TiposDoc.valueOf(tipoDocSelect));
        if (usuarios.getIdusuarios() != null) {
            usuariosfacade.edit(usuarios);
            messageBean.setTitle("Datos actualizados correctamente");
            messageBean.setIcono("success");
        } else {
            usuariosfacade.create(usuarios);
            messageBean.setTitle("Usuario creado correctamente");
            messageBean.setIcono("success");
        }
        usuarios = new Usuarios();
    }

    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Usuarios usuarios = usuariosfacade.find(Integer.parseInt(parametros.get("usuarioId")));
        usuariosfacade.remove(usuarios);
        FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
    }

    public void update(Usuarios usuarios) {
        this.usuarios = usuarios;
        this.rolselect = usuarios.getRolIdrol().getIdrol();
    }
    
    public List<Rol> getAllRol() {
        return rolfacade.findAll();
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getRolselect() {
        return rolselect;
    }

    public void setRolselect(Integer rolselect) {
        this.rolselect = rolselect;
    }

    public String getTipoDocSelect() {
        return tipoDocSelect;
    }

    public void setTipoDocSelect(String tipoDocSelect) {
        this.tipoDocSelect = tipoDocSelect;
    }

    public MessagesBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }
    
    
}
