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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")})
public class Empresa implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDocumento")
    private TiposDoc tipoDocumento;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempresa")
    private Integer idempresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numDocumento")
    private String numDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreRazonSocial")
    private String nombreRazonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccionEmpresa")
    private String direccionEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telEmpresa")
    private String telEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mailEmpresa")
    private String mailEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaIdempresa", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public Empresa() {
    }

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(Integer idempresa, TiposDoc tipoDocumento, String numDocumento, String nombreRazonSocial, String direccionEmpresa, String telEmpresa, String mailEmpresa) {
        this.idempresa = idempresa;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombreRazonSocial = nombreRazonSocial;
        this.direccionEmpresa = direccionEmpresa;
        this.telEmpresa = telEmpresa;
        this.mailEmpresa = mailEmpresa;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelEmpresa() {
        return telEmpresa;
    }

    public void setTelEmpresa(String telEmpresa) {
        this.telEmpresa = telEmpresa;
    }

    public String getMailEmpresa() {
        return mailEmpresa;
    }

    public void setMailEmpresa(String mailEmpresa) {
        this.mailEmpresa = mailEmpresa;
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
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.macemecanica.entitys.Empresa[ idempresa=" + idempresa + " ]";
    }

    public TiposDoc getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TiposDoc tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

}
