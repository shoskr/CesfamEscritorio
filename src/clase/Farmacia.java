/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "FARMACIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Farmacia.findAll", query = "SELECT f FROM Farmacia f")
    , @NamedQuery(name = "Farmacia.findByIdFarmacia", query = "SELECT f FROM Farmacia f WHERE f.idFarmacia = :idFarmacia")
    , @NamedQuery(name = "Farmacia.findByTelefono", query = "SELECT f FROM Farmacia f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Farmacia.findByDireccion", query = "SELECT f FROM Farmacia f WHERE f.direccion = :direccion")})
public class Farmacia implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmaciaIdFarmacia")
    private Collection<StockMedicamento> stockMedicamentoCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FARMACIA")
    private BigDecimal idFarmacia;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmaciaIdFarmacia")
    private Collection<RetiroMedicamento> retiroMedicamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmaciaIdFarmacia")
    private Collection<Merma> mermaCollection;

    public Farmacia() {
    }

    public Farmacia(BigDecimal idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public BigDecimal getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(BigDecimal idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<RetiroMedicamento> getRetiroMedicamentoCollection() {
        return retiroMedicamentoCollection;
    }

    public void setRetiroMedicamentoCollection(Collection<RetiroMedicamento> retiroMedicamentoCollection) {
        this.retiroMedicamentoCollection = retiroMedicamentoCollection;
    }

    @XmlTransient
    public Collection<Merma> getMermaCollection() {
        return mermaCollection;
    }

    public void setMermaCollection(Collection<Merma> mermaCollection) {
        this.mermaCollection = mermaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFarmacia != null ? idFarmacia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmacia)) {
            return false;
        }
        Farmacia other = (Farmacia) object;
        if ((this.idFarmacia == null && other.idFarmacia != null) || (this.idFarmacia != null && !this.idFarmacia.equals(other.idFarmacia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Farmacia[ idFarmacia=" + idFarmacia + " ]";
    }

    @XmlTransient
    public Collection<StockMedicamento> getStockMedicamentoCollection() {
        return stockMedicamentoCollection;
    }

    public void setStockMedicamentoCollection(Collection<StockMedicamento> stockMedicamentoCollection) {
        this.stockMedicamentoCollection = stockMedicamentoCollection;
    }
    
}
