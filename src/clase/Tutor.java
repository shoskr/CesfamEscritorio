/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "TUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutor.findAll", query = "SELECT t FROM Tutor t")
    , @NamedQuery(name = "Tutor.findByIdTutor", query = "SELECT t FROM Tutor t WHERE t.idTutor = :idTutor")
    , @NamedQuery(name = "Tutor.findByNombreTutor", query = "SELECT t FROM Tutor t WHERE t.nombreTutor = :nombreTutor")
    , @NamedQuery(name = "Tutor.findByRutTutor", query = "SELECT t FROM Tutor t WHERE t.rutTutor = :rutTutor")
    , @NamedQuery(name = "Tutor.findByCorreoTutor", query = "SELECT t FROM Tutor t WHERE t.correoTutor = :correoTutor")
    , @NamedQuery(name = "Tutor.findByTelefonoTutor", query = "SELECT t FROM Tutor t WHERE t.telefonoTutor = :telefonoTutor")})
public class Tutor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TUTOR")
    private BigDecimal idTutor;
    @Column(name = "NOMBRE_TUTOR")
    private String nombreTutor;
    @Column(name = "RUT_TUTOR")
    private String rutTutor;
    @Column(name = "CORREO_TUTOR")
    private String correoTutor;
    @Column(name = "TELEFONO_TUTOR")
    private String telefonoTutor;
    @JoinColumn(name = "PACIENTE_ID_PACIENTE", referencedColumnName = "ID_PACIENTE")
    @ManyToOne(optional = false)
    private Paciente pacienteIdPaciente;

    public Tutor() {
    }

    public Tutor(BigDecimal idTutor) {
        this.idTutor = idTutor;
    }

    public BigDecimal getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(BigDecimal idTutor) {
        this.idTutor = idTutor;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getRutTutor() {
        return rutTutor;
    }

    public void setRutTutor(String rutTutor) {
        this.rutTutor = rutTutor;
    }

    public String getCorreoTutor() {
        return correoTutor;
    }

    public void setCorreoTutor(String correoTutor) {
        this.correoTutor = correoTutor;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    public Paciente getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(Paciente pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTutor != null ? idTutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutor)) {
            return false;
        }
        Tutor other = (Tutor) object;
        if ((this.idTutor == null && other.idTutor != null) || (this.idTutor != null && !this.idTutor.equals(other.idTutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Tutor[ idTutor=" + idTutor + " ]";
    }
    
}
