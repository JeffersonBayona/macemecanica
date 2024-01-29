/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.macemecanica.controllers;

import com.mycompany.macemecanica.entitys.Categoria;
import com.mycompany.macemecanica.entitys.Clientes;
import com.mycompany.macemecanica.entitys.Empresa;
import com.mycompany.macemecanica.entitys.MetodoPago;
import com.mycompany.macemecanica.entitys.Productos;
import com.mycompany.macemecanica.entitys.Venta;
import com.mycompany.macemecanica.entitys.VentaHasProductos;
import com.mycompany.macemecanica.helpers.MessagesBean;
import com.mycompany.macemecanica.models.CategoriaFacade;
import com.mycompany.macemecanica.models.ClientesFacade;
import com.mycompany.macemecanica.models.EmpresaFacade;
import com.mycompany.macemecanica.models.MetodoPagoFacade;
import com.mycompany.macemecanica.models.ProductosFacade;
import com.mycompany.macemecanica.models.VentaFacade;
import com.mycompany.macemecanica.models.VentaHasProductosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Jeffer
 */
@Named(value = "inventory")
@SessionScoped
public class inventory implements Serializable {

    @EJB
    private ProductosFacade productosfacade;
    private Integer productoselect;
    private Productos productos = new Productos();
    private List<VentaHasProductos> lista = new ArrayList<>();
    @EJB
    private CategoriaFacade categoriafacade;
    private Integer categoriaselect;
    @Inject
    private MessagesBean messagesBean;
    private Integer cantidadSelect = 0;
    private Venta venta = new Venta();
    @EJB
    private VentaFacade ventafacade;
    @EJB
    private VentaHasProductosFacade ventaHasProductosFacade;
    @EJB
    private ClientesFacade clientesFacade;
    private Integer clienteselect;
    @EJB
    private MetodoPagoFacade metodoPagoFacade;
    private Integer metodoPagoselect;
    @EJB
    private EmpresaFacade empresaFacade;
    private Integer empresaselect;

    public MessagesBean getMessagesBean() {
        return messagesBean;
    }

    public void setMessagesBean(MessagesBean messagesBean) {
        this.messagesBean = messagesBean;
    }

    /**
     * Creates a new instance of inventory
     */
    public inventory() {
    }

    public void buy() {
        if (getClienteselect() != null) {
            Clientes cliente = clientesFacade.findById(clienteselect);
            MetodoPago metodoPago = metodoPagoFacade.find(metodoPagoselect);
            Empresa empresa = empresaFacade.find(empresaselect);
            venta.setFechaVenta(new Date());
            venta.setValorTotalVenta(getTotalBuy());
            venta.setClientesidCliente(cliente);
            venta.setMetodoPagoIdmetodoPago(metodoPago);
            venta.setEmpresaIdempresa(empresa);
            ventafacade.create(venta);
            for (VentaHasProductos p : lista) {
                Productos producto = p.getProductosIdproductos();
                producto.setStock(producto.getStock() - p.getCantidad());
                productosfacade.edit(producto);
                p.setVentaIdventa(venta);
                ventaHasProductosFacade.create(p);
            }
            lista = new ArrayList<>();
            venta = new Venta();
            messagesBean.setTitle("Venta registrada");
            messagesBean.setIcono("success");
        } else {
            messagesBean.setTitle("Por favor ingrese la información del cliente!");
            messagesBean.setIcono("warning");
        }
    }

    public void selectProduct() {
        boolean com = true;
        if (productoselect != null) {
            Productos p = productosfacade.findById(productoselect);
            if (p != null) {
                if (p.getStock() < cantidadSelect) {
                    messagesBean.setIcono("warning");
                    messagesBean.setTitle("La cantidad seleccionada es mayor a la disponible!");
                    return;
                }
                if (cantidadSelect < 1) {
                    messagesBean.setTitle("La cantidad no es valida");
                    messagesBean.setIcono("warning");
                    return;
                }
                for (VentaHasProductos pro : lista) {
                    if (pro.getProductosIdproductos().getIdproductos() == p.getIdproductos()) {
                        int totalCantidad = pro.getCantidad() + cantidadSelect;
                        if (p.getStock() < totalCantidad) {
                            messagesBean.setIcono("warning");
                            messagesBean.setTitle("La cantidad seleccionada es mayor a la disponible!");
                            return;
                        }
                        com = false;
                        pro.setCantidad(totalCantidad);
                        messagesBean.setTitle("Agregado al carrito!");
                        messagesBean.setIcono("success");
                        break;
                    }
                }
                if (com) {
                    VentaHasProductos venta = new VentaHasProductos();
                    venta.setCantidad(cantidadSelect);
                    venta.setProductosIdproductos(p);
                    lista.add(venta);
                    messagesBean.setTitle("Agregado al carrito!");
                    messagesBean.setIcono("success");
                }

            }
        }
    }

    public List<Productos> findAll() {
        return getProductosfacade().findAll();
    }

    public List<Productos> getAllProductos() {
        if (categoriaselect != null) {
            return productosfacade.filtro(categoriaselect);
        }
        return getProductosfacade().findAll();
    }

    public List<Categoria> getAllCategoria() {
        return getCategoriafacade().findAll();
    }

    public void save() {
        Categoria categoria = new Categoria();
        categoria.setIdcategoria(categoriaselect);
        productos.setCategoriaIdcategoria(categoria);
        if (productos.getIdproductos() != null) {
            productosfacade.edit(productos);
            messagesBean.setTitle("Datos actualizados correctamente");
            messagesBean.setIcono("success");
        } else {
            productosfacade.create(productos);
            messagesBean.setTitle("Producto creado correctamente");
            messagesBean.setIcono("success");
        }
        productos = new Productos();
    }

    public List<VentaHasProductos> getLista() {
        return lista;
    }

    public Long getTotalBuy() {
        Long total = 0L;
        for (VentaHasProductos p : lista) {
            total = total + (p.getProductosIdproductos().getValorProducto() * p.getCantidad());
        }
        return total;
    }

    public void setLista(List<VentaHasProductos> lista) {
        this.lista = lista;
    }

    public Integer getCantidadSelect() {
        return cantidadSelect;
    }

    public void setCantidadSelect(Integer cantidadSelect) {
        this.cantidadSelect = cantidadSelect;
    }

    public void delete() throws IOException {
        Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Productos producto = productosfacade.find(Integer.parseInt(parametros.get("productosId")));
        productosfacade.remove(producto);
        FacesContext.getCurrentInstance().getExternalContext().redirect("products.xhtml");
    }

    public void update(Productos productos) {
        this.productos = productos;
        this.categoriaselect = productos.getCategoriaIdcategoria().getIdcategoria();
    }

    public void clear() {
        setProductos(new Productos());
    }

    /**
     * @return the productos
     */
    public Productos getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    /**
     * @return the categoriaselect
     */
    public Integer getCategoriaselect() {
        return categoriaselect;
    }

    /**
     * @param categoriaselect the categoriaselect to set
     */
    public void setCategoriaselect(Integer categoriaselect) {
        this.categoriaselect = categoriaselect;
    }

    /**
     * @return the productoselect
     */
    public Integer getProductoselect() {
        return productoselect;
    }

    /**
     * @param productoselect the productoselect to set
     */
    public void setProductoselect(Integer productoselect) {
        this.productoselect = productoselect;
    }

    /**
     * @return the productosfacade
     */
    public ProductosFacade getProductosfacade() {
        return productosfacade;
    }

    /**
     * @param productosfacade the productosfacade to set
     */
    public void setProductosfacade(ProductosFacade productosfacade) {
        this.productosfacade = productosfacade;
    }

    /**
     * @return the categoriafacade
     */
    public CategoriaFacade getCategoriafacade() {
        return categoriafacade;
    }

    /**
     * @param categoriafacade the categoriafacade to set
     */
    public void setCategoriafacade(CategoriaFacade categoriafacade) {
        this.categoriafacade = categoriafacade;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Integer getClienteselect() {
        return clienteselect;
    }

    public void setClienteselect(Integer clienteselect) {
        this.clienteselect = clienteselect;
    }

    public Integer getMetodoPagoselect() {
        return metodoPagoselect;
    }

    public void setMetodoPagoselect(Integer metodoPagoselect) {
        this.metodoPagoselect = metodoPagoselect;
    }

    public Integer getEmpresaselect() {
        return empresaselect;
    }

    public void setEmpresaselect(Integer empresaselect) {
        this.empresaselect = empresaselect;
    }

}
