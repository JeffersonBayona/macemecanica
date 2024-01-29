/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jeffer
 */
@Entity
@Table(name = "venta_has_productos")
@NamedQueries({
    @NamedQuery(name = "VentaHasProductos.findAll", query = "SELECT v FROM VentaHasProductos v"),
    @NamedQuery(name = "VentaHasProductos.findByIdventaHasProductoscol", query = "SELECT v FROM VentaHasProductos v WHERE v.idventaHasProductoscol = :idventaHasProductoscol"),
    @NamedQuery(name = "VentaHasProductos.findByCantidad", query = "SELECT v FROM VentaHasProductos v WHERE v.cantidad = :cantidad")})
public class VentaHasProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa_has_productoscol")
    private Integer idventaHasProductoscol;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "productos_idproductos", referencedColumnName = "idproductos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos productosIdproductos;
    @JoinColumn(name = "venta_idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta ventaIdventa;

    public VentaHasProductos() {
    }

    public VentaHasProductos(Integer idventaHasProductoscol) {
        this.idventaHasProductoscol = idventaHasProductoscol;
    }

    public Integer getIdventaHasProductoscol() {
        return idventaHasProductoscol;
    }

    public void setIdventaHasProductoscol(Integer idventaHasProductoscol) {
        this.idventaHasProductoscol = idventaHasProductoscol;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductosIdproductos() {
        return productosIdproductos;
    }

    public void setProductosIdproductos(Productos productosIdproductos) {
        this.productosIdproductos = productosIdproductos;
    }

    public Venta getVentaIdventa() {
        return ventaIdventa;
    }

    public void setVentaIdventa(Venta ventaIdventa) {
        this.ventaIdventa = ventaIdventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventaHasProductoscol != null ? idventaHasProductoscol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaHasProductos)) {
            return false;
        }
        VentaHasProductos other = (VentaHasProductos) object;
        if ((this.idventaHasProductoscol == null && other.idventaHasProductoscol != null) || (this.idventaHasProductoscol != null && !this.idventaHasProductoscol.equals(other.idventaHasProductoscol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.VentaHasProductos[ idventaHasProductoscol=" + idventaHasProductoscol + " ]";
    }
    
}
