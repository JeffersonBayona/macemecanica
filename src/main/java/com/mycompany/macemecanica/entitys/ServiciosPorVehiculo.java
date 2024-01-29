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

/**
 *
 * @author Jeffer
 */
@Entity
@Table(name = "servicios_por_vehiculo")
@NamedQueries({
    @NamedQuery(name = "ServiciosPorVehiculo.findAll", query = "SELECT s FROM ServiciosPorVehiculo s")})
public class ServiciosPorVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServiciosporVehiculo")
    private Integer idServiciosporVehiculo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaServicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "varorServicio")
    private BigDecimal varorServicio;
    @JoinColumn(name = "servicios_idServicio", referencedColumnName = "idservicios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicios serviciosidServicio;
    @JoinColumn(name = "vehiculo_idVehiculo", referencedColumnName = "idVehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo vehiculoidVehiculo;

    public ServiciosPorVehiculo() {
    }

    public ServiciosPorVehiculo(Integer idServiciosporVehiculo) {
        this.idServiciosporVehiculo = idServiciosporVehiculo;
    }

    public ServiciosPorVehiculo(Integer idServiciosporVehiculo, Date fechaServicio, BigDecimal varorServicio) {
        this.idServiciosporVehiculo = idServiciosporVehiculo;
        this.fechaServicio = fechaServicio;
        this.varorServicio = varorServicio;
    }

    public Integer getIdServiciosporVehiculo() {
        return idServiciosporVehiculo;
    }

    public void setIdServiciosporVehiculo(Integer idServiciosporVehiculo) {
        this.idServiciosporVehiculo = idServiciosporVehiculo;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public BigDecimal getVarorServicio() {
        return varorServicio;
    }

    public void setVarorServicio(BigDecimal varorServicio) {
        this.varorServicio = varorServicio;
    }

    public Servicios getServiciosidServicio() {
        return serviciosidServicio;
    }

    public void setServiciosidServicio(Servicios serviciosidServicio) {
        this.serviciosidServicio = serviciosidServicio;
    }

    public Vehiculo getVehiculoidVehiculo() {
        return vehiculoidVehiculo;
    }

    public void setVehiculoidVehiculo(Vehiculo vehiculoidVehiculo) {
        this.vehiculoidVehiculo = vehiculoidVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiciosporVehiculo != null ? idServiciosporVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosPorVehiculo)) {
            return false;
        }
        ServiciosPorVehiculo other = (ServiciosPorVehiculo) object;
        if ((this.idServiciosporVehiculo == null && other.idServiciosporVehiculo != null) || (this.idServiciosporVehiculo != null && !this.idServiciosporVehiculo.equals(other.idServiciosporVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.ServiciosPorVehiculo[ idServiciosporVehiculo=" + idServiciosporVehiculo + " ]";
    }
    
}
