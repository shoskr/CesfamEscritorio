/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "INGRESO_ART_MED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoArtMed.findAll", query = "SELECT i FROM IngresoArtMed i")
    , @NamedQuery(name = "IngresoArtMed.findByIdIngreso", query = "SELECT i FROM IngresoArtMed i WHERE i.idIngreso = :idIngreso")
    , @NamedQuery(name = "IngresoArtMed.findByFechaVenci", query = "SELECT i FROM IngresoArtMed i WHERE i.fechaVenci = :fechaVenci")
    , @NamedQuery(name = "IngresoArtMed.findByCantidad", query = "SELECT i FROM IngresoArtMed i WHERE i.cantidad = :cantidad")})
public class IngresoArtMed implements Serializable {

    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingresoArtMedIdIngreso")
    private Collection<StockMedicamento> stockMedicamentoCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INGRESO")
    private BigDecimal idIngreso;
    @Column(name = "FECHA_VENCI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenci;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM", referencedColumnName = "CODIGO_AM")
    @ManyToOne(optional = false)
    private ArticuloYMedica articuloYMedicaCodigoAm;

    public IngresoArtMed() {
    }

    public IngresoArtMed(BigDecimal idIngreso) {
        this.idIngreso = idIngreso;
    }

    public BigDecimal getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(BigDecimal idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Date getFechaVenci() {
        return fechaVenci;
    }

    public void setFechaVenci(Date fechaVenci) {
        this.fechaVenci = fechaVenci;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public ArticuloYMedica getArticuloYMedicaCodigoAm() {
        return articuloYMedicaCodigoAm;
    }

    public void setArticuloYMedicaCodigoAm(ArticuloYMedica articuloYMedicaCodigoAm) {
        this.articuloYMedicaCodigoAm = articuloYMedicaCodigoAm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngreso != null ? idIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoArtMed)) {
            return false;
        }
        IngresoArtMed other = (IngresoArtMed) object;
        if ((this.idIngreso == null && other.idIngreso != null) || (this.idIngreso != null && !this.idIngreso.equals(other.idIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.IngresoArtMed[ idIngreso=" + idIngreso + " ]";
    }

    @XmlTransient
    public Collection<StockMedicamento> getStockMedicamentoCollection() {
        return stockMedicamentoCollection;
    }

    public void setStockMedicamentoCollection(Collection<StockMedicamento> stockMedicamentoCollection) {
        this.stockMedicamentoCollection = stockMedicamentoCollection;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
}
