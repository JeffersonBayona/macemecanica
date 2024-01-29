package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.models.UsuariosFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import com.mycompany.macemecanica.helpers.MessagesBean;
import javax.inject.Inject;
import com.mycompany.macemecanica.entitys.Usuarios;

@Named(value = "controller_mace")
@RequestScoped
public class Controller_mace {

    private String correo;
    private String password;
    @EJB
    private UsuariosFacade usuariosFacade;
    private String menssage1;
    @Inject
    private MessagesBean messageBean;

    public Controller_mace() {
    }

    public void login() throws IOException {
        List<Usuarios> usuarios = usuariosFacade.login(correo, password);
        if (usuarios.isEmpty() != true) {
            if (usuarios.get(0).getRolIdrol().getDescripcionRol().equals("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
                messageBean.setTitle("Bienvenido Administrador");
                messageBean.setIcono("success");
            } else if (usuarios.get(0).getRolIdrol().getDescripcionRol().equals("Colaborador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("incolab.xhtml");
                messageBean.setTitle("Bienvenido Colaborador");
                messageBean.setIcono("success");
            }
        } else {
            messageBean.setTitle("Usuario o contraseña invalidos");
            messageBean.setIcono("warning");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMenssage1() {
        return menssage1;
    }

    public void setMenssage1(String menssage) {
        this.menssage1 = menssage;
    }

    public MessagesBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessagesBean messageBean) {
        this.messageBean = messageBean;
    }

}
