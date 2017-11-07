/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "MERMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merma.findAll", query = "SELECT m FROM Merma m")
    , @NamedQuery(name = "Merma.findByIdMerma", query = "SELECT m FROM Merma m WHERE m.idMerma = :idMerma")
    , @NamedQuery(name = "Merma.findByCantidad", query = "SELECT m FROM Merma m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Merma.findByDetalle", query = "SELECT m FROM Merma m WHERE m.detalle = :detalle")})
public class Merma implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MERMA")
    private BigDecimal idMerma;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "DETALLE")
    private String detalle;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM", referencedColumnName = "CODIGO_AM")
    @ManyToOne(optional = false)
    private ArticuloYMedica articuloYMedicaCodigoAm;
    @JoinColumn(name = "FARMACIA_ID_FARMACIA", referencedColumnName = "ID_FARMACIA")
    @ManyToOne(optional = false)
    private Farmacia farmaciaIdFarmacia;

    public Merma() {
    }

    public Merma(BigDecimal idMerma) {
        this.idMerma = idMerma;
    }

    public BigDecimal getIdMerma() {
        return idMerma;
    }

    public void setIdMerma(BigDecimal idMerma) {
        this.idMerma = idMerma;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public ArticuloYMedica getArticuloYMedicaCodigoAm() {
        return articuloYMedicaCodigoAm;
    }

    public void setArticuloYMedicaCodigoAm(ArticuloYMedica articuloYMedicaCodigoAm) {
        this.articuloYMedicaCodigoAm = articuloYMedicaCodigoAm;
    }

    public Farmacia getFarmaciaIdFarmacia() {
        return farmaciaIdFarmacia;
    }

    public void setFarmaciaIdFarmacia(Farmacia farmaciaIdFarmacia) {
        this.farmaciaIdFarmacia = farmaciaIdFarmacia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMerma != null ? idMerma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merma)) {
            return false;
        }
        Merma other = (Merma) object;
        if ((this.idMerma == null && other.idMerma != null) || (this.idMerma != null && !this.idMerma.equals(other.idMerma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Merma[ idMerma=" + idMerma + " ]";
    }
    
}
