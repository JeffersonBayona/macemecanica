/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jeffer
 */
@Entity
@Table(name = "metodo_pago")
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmetodo_pago")
    private Integer idmetodoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoPagoIdmetodoPago", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public MetodoPago() {
    }

    public MetodoPago(Integer idmetodoPago) {
        this.idmetodoPago = idmetodoPago;
    }

    public MetodoPago(Integer idmetodoPago, String metodoPago) {
        this.idmetodoPago = idmetodoPago;
        this.metodoPago = metodoPago;
    }

    public Integer getIdmetodoPago() {
        return idmetodoPago;
    }

    public void setIdmetodoPago(Integer idmetodoPago) {
        this.idmetodoPago = idmetodoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmetodoPago != null ? idmetodoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idmetodoPago == null && other.idmetodoPago != null) || (this.idmetodoPago != null && !this.idmetodoPago.equals(other.idmetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.MetodoPago[ idmetodoPago=" + idmetodoPago + " ]";
    }
    
}
