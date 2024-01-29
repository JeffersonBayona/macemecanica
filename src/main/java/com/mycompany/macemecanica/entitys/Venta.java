/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jeffer
 */
@Entity
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByValorTotalVenta", query = "SELECT v FROM Venta v WHERE v.valorTotalVenta = :valorTotalVenta"),
    @NamedQuery(name = "Venta.findByCreatedAt", query = "SELECT v FROM Venta v WHERE v.createdAt = :createdAt"),
    @NamedQuery(name = "Venta.findByUpdatedAt", query = "SELECT v FROM Venta v WHERE v.updatedAt = :updatedAt")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotalVenta")
    private long valorTotalVenta;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "clientes_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes clientesidCliente;
    @JoinColumn(name = "empresa_idempresa", referencedColumnName = "idempresa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresaIdempresa;
    @JoinColumn(name = "metodo_pago_idmetodo_pago", referencedColumnName = "idmetodo_pago")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MetodoPago metodoPagoIdmetodoPago;
    @OneToMany(mappedBy = "ventaIdventa", fetch = FetchType.LAZY)
    private List<VentaHasProductos> ventaHasProductosL;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Venta(Integer idventa, Date fechaVenta, int cantidadComprada, long valorTotalVenta) {
        this.idventa = idventa;
        this.fechaVenta = fechaVenta;
        this.valorTotalVenta = valorTotalVenta;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public long getValorTotalVenta() {
        return valorTotalVenta;
    }

    public void setValorTotalVenta(long valorTotalVenta) {
        this.valorTotalVenta = valorTotalVenta;
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

    public Clientes getClientesidCliente() {
        return clientesidCliente;
    }

    public void setClientesidCliente(Clientes clientesidCliente) {
        this.clientesidCliente = clientesidCliente;
    }

    public Empresa getEmpresaIdempresa() {
        return empresaIdempresa;
    }

    public void setEmpresaIdempresa(Empresa empresaIdempresa) {
        this.empresaIdempresa = empresaIdempresa;
    }

    public MetodoPago getMetodoPagoIdmetodoPago() {
        return metodoPagoIdmetodoPago;
    }

    public void setMetodoPagoIdmetodoPago(MetodoPago metodoPagoIdmetodoPago) {
        this.metodoPagoIdmetodoPago = metodoPagoIdmetodoPago;
    }

    public List<VentaHasProductos> getVentaHasProductosL() {
        return ventaHasProductosL;
    }

    public void setVentaHasProductosL(List<VentaHasProductos> ventaHasProductosL) {
        this.ventaHasProductosL = ventaHasProductosL;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.Venta[ idventa=" + idventa + " ]";
    }
    
}
