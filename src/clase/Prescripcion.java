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
@Table(name = "PRESCRIPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescripcion.findAll", query = "SELECT p FROM Prescripcion p")
    , @NamedQuery(name = "Prescripcion.findByIdPrescripcion", query = "SELECT p FROM Prescripcion p WHERE p.idPrescripcion = :idPrescripcion")
    , @NamedQuery(name = "Prescripcion.findByDetalle", query = "SELECT p FROM Prescripcion p WHERE p.detalle = :detalle")})
public class Prescripcion implements Serializable {

    @Column(name = "CANTIDAD_MEDICAMENTO")
    private BigInteger cantidadMedicamento;
    @JoinColumn(name = "ID_MEDICO", referencedColumnName = "ID_MEDICO")
    @ManyToOne
    private Medico idMedico;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRESCRIPCION")
    private BigDecimal idPrescripcion;
    @Column(name = "DETALLE")
    private String detalle;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM", referencedColumnName = "CODIGO_AM")
    @ManyToOne(optional = false)
    private ArticuloYMedica articuloYMedicaCodigoAm;
    @JoinColumn(name = "RECETA_ID_RECETA", referencedColumnName = "ID_RECETA")
    @ManyToOne(optional = false)
    private Receta recetaIdReceta;
    @JoinColumn(name = "TRATAMINENTO_ID_TRATAMIENTO", referencedColumnName = "ID_TRATAMIENTO")
    @ManyToOne(optional = false)
    private Trataminento trataminentoIdTratamiento;

    public Prescripcion() {
    }

    public Prescripcion(BigDecimal idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public BigDecimal getIdPrescripcion() {
        return idPrescripcion;
    }

    public void setIdPrescripcion(BigDecimal idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
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

    public Receta getRecetaIdReceta() {
        return recetaIdReceta;
    }

    public void setRecetaIdReceta(Receta recetaIdReceta) {
        this.recetaIdReceta = recetaIdReceta;
    }

    public Trataminento getTrataminentoIdTratamiento() {
        return trataminentoIdTratamiento;
    }

    public void setTrataminentoIdTratamiento(Trataminento trataminentoIdTratamiento) {
        this.trataminentoIdTratamiento = trataminentoIdTratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrescripcion != null ? idPrescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescripcion)) {
            return false;
        }
        Prescripcion other = (Prescripcion) object;
        if ((this.idPrescripcion == null && other.idPrescripcion != null) || (this.idPrescripcion != null && !this.idPrescripcion.equals(other.idPrescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Prescripcion[ idPrescripcion=" + idPrescripcion + " ]";
    }

    public BigInteger getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(BigInteger cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
    }
    
}
