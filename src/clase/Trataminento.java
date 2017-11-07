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
@Table(name = "TRATAMINENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trataminento.findAll", query = "SELECT t FROM Trataminento t")
    , @NamedQuery(name = "Trataminento.findByIdTratamiento", query = "SELECT t FROM Trataminento t WHERE t.idTratamiento = :idTratamiento")
    , @NamedQuery(name = "Trataminento.findByPeriodoo", query = "SELECT t FROM Trataminento t WHERE t.periodoo = :periodoo")
    , @NamedQuery(name = "Trataminento.findByTipoTratamiento", query = "SELECT t FROM Trataminento t WHERE t.tipoTratamiento = :tipoTratamiento")})
public class Trataminento implements Serializable {

    @Column(name = "FECHA_INICIO")
    private String fechaInicio;
    @Column(name = "FECHA_TERMINO")
    private String fechaTermino;
    @Column(name = "DIAGNOSTICO")
    private String diagnostico;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRATAMIENTO")
    private BigDecimal idTratamiento;
    @Column(name = "PERIODOO")
    private String periodoo;
    @Column(name = "TIPO_TRATAMIENTO")
    private String tipoTratamiento;
    @JoinColumn(name = "MEDICO_ID_MEDICO", referencedColumnName = "ID_MEDICO")
    @ManyToOne(optional = false)
    private Medico medicoIdMedico;
    @JoinColumn(name = "PACIENTE_ID_PACIENTE", referencedColumnName = "ID_PACIENTE")
    @ManyToOne(optional = false)
    private Paciente pacienteIdPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trataminentoIdTratamiento")
    private Collection<Prescripcion> prescripcionCollection;

    public Trataminento() {
    }

    public Trataminento(BigDecimal idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public BigDecimal getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(BigDecimal idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getPeriodoo() {
        return periodoo;
    }

    public void setPeriodoo(String periodoo) {
        this.periodoo = periodoo;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public Medico getMedicoIdMedico() {
        return medicoIdMedico;
    }

    public void setMedicoIdMedico(Medico medicoIdMedico) {
        this.medicoIdMedico = medicoIdMedico;
    }

    public Paciente getPacienteIdPaciente() {
        return pacienteIdPaciente;
    }

    public void setPacienteIdPaciente(Paciente pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }

    @XmlTransient
    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trataminento)) {
            return false;
        }
        Trataminento other = (Trataminento) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Trataminento[ idTratamiento=" + idTratamiento + " ]";
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
}
