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
@Table(name = "RETIRO_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetiroMedicamento.findAll", query = "SELECT r FROM RetiroMedicamento r")
    , @NamedQuery(name = "RetiroMedicamento.findByIdRetiro", query = "SELECT r FROM RetiroMedicamento r WHERE r.idRetiro = :idRetiro")
    , @NamedQuery(name = "RetiroMedicamento.findByCantidadMedicamento", query = "SELECT r FROM RetiroMedicamento r WHERE r.cantidadMedicamento = :cantidadMedicamento")
    , @NamedQuery(name = "RetiroMedicamento.findByNombreReceptor", query = "SELECT r FROM RetiroMedicamento r WHERE r.nombreReceptor = :nombreReceptor")
    , @NamedQuery(name = "RetiroMedicamento.findByFechaRetiro", query = "SELECT r FROM RetiroMedicamento r WHERE r.fechaRetiro = :fechaRetiro")})
public class RetiroMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RETIRO")
    private BigDecimal idRetiro;
    @Column(name = "CANTIDAD_MEDICAMENTO")
    private BigInteger cantidadMedicamento;
    @Column(name = "NOMBRE_RECEPTOR")
    private String nombreReceptor;
    @Column(name = "FECHA_RETIRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRetiro;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM", referencedColumnName = "CODIGO_AM")
    @ManyToOne(optional = false)
    private ArticuloYMedica articuloYMedicaCodigoAm;
    @JoinColumn(name = "FARMACIA_ID_FARMACIA", referencedColumnName = "ID_FARMACIA")
    @ManyToOne(optional = false)
    private Farmacia farmaciaIdFarmacia;
    @JoinColumn(name = "RECETA_ID_RECETA", referencedColumnName = "ID_RECETA")
    @ManyToOne(optional = false)
    private Receta recetaIdReceta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "retiroMedicamentoIdRetiro")
    private Collection<RetiroMedicamenReser> retiroMedicamenReserCollection;

    public RetiroMedicamento() {
    }

    public RetiroMedicamento(BigDecimal idRetiro) {
        this.idRetiro = idRetiro;
    }

    public BigDecimal getIdRetiro() {
        return idRetiro;
    }

    public void setIdRetiro(BigDecimal idRetiro) {
        this.idRetiro = idRetiro;
    }

    public BigInteger getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(BigInteger cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
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

    public Receta getRecetaIdReceta() {
        return recetaIdReceta;
    }

    public void setRecetaIdReceta(Receta recetaIdReceta) {
        this.recetaIdReceta = recetaIdReceta;
    }

    @XmlTransient
    public Collection<RetiroMedicamenReser> getRetiroMedicamenReserCollection() {
        return retiroMedicamenReserCollection;
    }

    public void setRetiroMedicamenReserCollection(Collection<RetiroMedicamenReser> retiroMedicamenReserCollection) {
        this.retiroMedicamenReserCollection = retiroMedicamenReserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetiro != null ? idRetiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetiroMedicamento)) {
            return false;
        }
        RetiroMedicamento other = (RetiroMedicamento) object;
        if ((this.idRetiro == null && other.idRetiro != null) || (this.idRetiro != null && !this.idRetiro.equals(other.idRetiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.RetiroMedicamento[ idRetiro=" + idRetiro + " ]";
    }
    
}
