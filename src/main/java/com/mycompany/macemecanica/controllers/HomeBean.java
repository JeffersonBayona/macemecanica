/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.models.CategoriaFacade;
import com.mycompany.macemecanica.models.ClientesFacade;
import com.mycompany.macemecanica.models.ProductosFacade;
import com.mycompany.macemecanica.models.ProveedorFacade;
import com.mycompany.macemecanica.models.UsuariosFacade;
import com.mycompany.macemecanica.models.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Aprendiz
 */
@Named(value = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {

    private long totalAdmins = 0L;
    private long totalClients = 0L;
    private long totalProviders = 0L;
    private long totalCategories = 0L;
    private long totalProducts = 0L;
    private long totalSales = 0L;
    @EJB
    private UsuariosFacade usuariosFacade;
    @EJB
    private ClientesFacade clientesFacade;
    @EJB
    private ProveedorFacade proveedorFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private ProductosFacade productosFacade;
    @EJB
    private VentaFacade ventaFacade;

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
    }

    public void initData() {
        totalAdmins = usuariosFacade.getTotalUsersByRol("Administrador");
        totalClients = clientesFacade.getTotalClientesById();
        totalProviders = proveedorFacade.getTotalProvidersById();
        totalCategories = categoriaFacade.getTotalCategoria();
        totalProducts = productosFacade.getTotalProduct();
        totalSales = ventaFacade.getTotalVentas();
    }

    public long getTotalAdmins() {
        return totalAdmins;
    }

    public void setTotalAdmins(long totalAdmins) {
        this.totalAdmins = totalAdmins;
    }

    public long getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(long totalClients) {
        this.totalClients = totalClients;
    }

    public long getTotalProviders() {
        return totalProviders;
    }

    public void setTotalProviders(long totalProvers) {
        this.totalProviders = totalProvers;
    }

    public long getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(long totalCategories) {
        this.totalCategories = totalCategories;
    }

    public long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(long totalSales) {
        this.totalSales = totalSales;
    }
}
