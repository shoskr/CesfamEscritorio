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
@Table(name = "SECTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
    , @NamedQuery(name = "Sector.findByIdsector", query = "SELECT s FROM Sector s WHERE s.idsector = :idsector")
    , @NamedQuery(name = "Sector.findByNombresector", query = "SELECT s FROM Sector s WHERE s.nombresector = :nombresector")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDSECTOR")
    private BigDecimal idsector;
    @Basic(optional = false)
    @Column(name = "NOMBRESECTOR")
    private String nombresector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorIdsector")
    private Collection<Paciente> pacienteCollection;

    public Sector() {
    }

    public Sector(BigDecimal idsector) {
        this.idsector = idsector;
    }

    public Sector(BigDecimal idsector, String nombresector) {
        this.idsector = idsector;
        this.nombresector = nombresector;
    }

    public BigDecimal getIdsector() {
        return idsector;
    }

    public void setIdsector(BigDecimal idsector) {
        this.idsector = idsector;
    }

    public String getNombresector() {
        return nombresector;
    }

    public void setNombresector(String nombresector) {
        this.nombresector = nombresector;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsector != null ? idsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.idsector == null && other.idsector != null) || (this.idsector != null && !this.idsector.equals(other.idsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Sector[ idsector=" + idsector + " ]";
    }
    
}
