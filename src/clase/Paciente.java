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
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paciente.findByApellidoPaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Paciente.findByApellidoMaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Paciente.findByRutPaciente", query = "SELECT p FROM Paciente p WHERE p.rutPaciente = :rutPaciente")
    , @NamedQuery(name = "Paciente.findByDireccion", query = "SELECT p FROM Paciente p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Paciente.findBySexo", query = "SELECT p FROM Paciente p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Paciente.findByFechaNacimientp", query = "SELECT p FROM Paciente p WHERE p.fechaNacimientp = :fechaNacimientp")
    , @NamedQuery(name = "Paciente.findByCorreo", query = "SELECT p FROM Paciente p WHERE p.correo = :correo")})
public class Paciente implements Serializable {

    @Column(name = "EDAD")
    private BigInteger edad;
    @Column(name = "DV")
    private String dv;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PACIENTE")
    private BigDecimal idPaciente;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "RUT_PACIENTE")
    private String rutPaciente;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "FECHA_NACIMIENTP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimientp;
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdPaciente")
    private Collection<Trataminento> trataminentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdPaciente")
    private Collection<Tutor> tutorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacienteIdPaciente")
    private Collection<Receta> recetaCollection;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;
    @JoinColumn(name = "SECTOR_IDSECTOR", referencedColumnName = "IDSECTOR")
    @ManyToOne(optional = false)
    private Sector sectorIdsector;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Paciente() {
    }

    public Paciente(BigDecimal idPaciente) {
        this.idPaciente = idPaciente;
    }

    public BigDecimal getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(BigDecimal idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRutPaciente() {
        return rutPaciente;
    }

    public void setRutPaciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimientp() {
        return fechaNacimientp;
    }

    public void setFechaNacimientp(Date fechaNacimientp) {
        this.fechaNacimientp = fechaNacimientp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Trataminento> getTrataminentoCollection() {
        return trataminentoCollection;
    }

    public void setTrataminentoCollection(Collection<Trataminento> trataminentoCollection) {
        this.trataminentoCollection = trataminentoCollection;
    }

    @XmlTransient
    public Collection<Tutor> getTutorCollection() {
        return tutorCollection;
    }

    public void setTutorCollection(Collection<Tutor> tutorCollection) {
        this.tutorCollection = tutorCollection;
    }

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    public Sector getSectorIdsector() {
        return sectorIdsector;
    }

    public void setSectorIdsector(Sector sectorIdsector) {
        this.sectorIdsector = sectorIdsector;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Paciente[ idPaciente=" + idPaciente + " ]";
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }
    
}
