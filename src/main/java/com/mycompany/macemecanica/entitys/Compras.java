/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jeffer
 */
@Entity
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCompra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "facturaCompra")
    private String facturaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorProducto")
    private BigDecimal valorProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "productos_idproductos", referencedColumnName = "idproductos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productos productosIdproductos;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor proveedorIdproveedor;

    public Compras() {
    }

    public Compras(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compras(Integer idCompra, Date fechaCompra, String facturaCompra, int cantidad, BigDecimal valorProducto, BigDecimal valorTotal) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.facturaCompra = facturaCompra;
        this.cantidad = cantidad;
        this.valorProducto = valorProducto;
        this.valorTotal = valorTotal;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFacturaCompra() {
        return facturaCompra;
    }

    public void setFacturaCompra(String facturaCompra) {
        this.facturaCompra = facturaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(BigDecimal valorProducto) {
        this.valorProducto = valorProducto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Productos getProductosIdproductos() {
        return productosIdproductos;
    }

    public void setProductosIdproductos(Productos productosIdproductos) {
        this.productosIdproductos = productosIdproductos;
    }

    public Proveedor getProveedorIdproveedor() {
        return proveedorIdproveedor;
    }

    public void setProveedorIdproveedor(Proveedor proveedorIdproveedor) {
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.Compras[ idCompra=" + idCompra + " ]";
    }
    
}
