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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vehiculo")
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numeroPlaca")
    private String numeroPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "TipoVehiculo")
    private String tipoVehiculo;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clientes clienteidCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoidVehiculo", fetch = FetchType.LAZY)
    private List<ServiciosPorVehiculo> serviciosPorVehiculoList;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(Integer idVehiculo, String numeroPlaca, String tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.numeroPlaca = numeroPlaca;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Clientes getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Clientes clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
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
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
