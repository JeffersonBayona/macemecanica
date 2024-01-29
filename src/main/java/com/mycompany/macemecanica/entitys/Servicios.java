/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.macemecanica.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "servicios")
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicios")
    private Integer idservicios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion_servicio")
    private String descripcionServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviciosidServicio", fetch = FetchType.LAZY)
    private List<ServiciosPorVehiculo> serviciosPorVehiculoList;

    public Servicios() {
    }

    public Servicios(Integer idservicios) {
        this.idservicios = idservicios;
    }

    public Servicios(Integer idservicios, String descripcionServicio, BigDecimal valor) {
        this.idservicios = idservicios;
        this.descripcionServicio = descripcionServicio;
        this.valor = valor;
    }

    public Integer getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Integer idservicios) {
        this.idservicios = idservicios;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ServiciosPorVehiculo> getServiciosPorVehiculoList() {
        return serviciosPorVehiculoList;
    }

    public void setServiciosPorVehiculoList(List<ServiciosPorVehiculo> serviciosPorVehiculoList) {
        this.serviciosPorVehiculoList = serviciosPorVehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicios != null ? idservicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.idservicios == null && other.idservicios != null) || (this.idservicios != null && !this.idservicios.equals(other.idservicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.Servicios[ idservicios=" + idservicios + " ]";
    }
    
}
