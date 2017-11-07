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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESERVA")
    private BigDecimal idReserva;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM", referencedColumnName = "CODIGO_AM")
    @ManyToOne(optional = false)
    private ArticuloYMedica articuloYMedicaCodigoAm;
    @JoinColumn(name = "RECETA_ID_RECETA", referencedColumnName = "ID_RECETA")
    @ManyToOne(optional = false)
    private Receta recetaIdReceta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaIdReserva")
    private Collection<RetiroMedicamenReser> retiroMedicamenReserCollection;

    public Reserva() {
    }

    public Reserva(BigDecimal idReserva) {
        this.idReserva = idReserva;
    }

    public BigDecimal getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(BigDecimal idReserva) {
        this.idReserva = idReserva;
    }

    public ArticuloYMedica getArticuloYMedicaCodigoAm() {
        return articuloYMedicaCodigoAm;
    }

    public void setArticuloYMedicaCodigoAm(ArticuloYMedica articuloYMedicaCodigoAm) {
        this.articuloYMedicaCodigoAm = articuloYMedicaCodigoAm;
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
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
