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
@Table(name = "MEDICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByIdMedico", query = "SELECT m FROM Medico m WHERE m.idMedico = :idMedico")
    , @NamedQuery(name = "Medico.findByNombreMed", query = "SELECT m FROM Medico m WHERE m.nombreMed = :nombreMed")
    , @NamedQuery(name = "Medico.findByApellidoPaterno", query = "SELECT m FROM Medico m WHERE m.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Medico.findByApellidoMater", query = "SELECT m FROM Medico m WHERE m.apellidoMater = :apellidoMater")
    , @NamedQuery(name = "Medico.findByRutMedi", query = "SELECT m FROM Medico m WHERE m.rutMedi = :rutMedi")
    , @NamedQuery(name = "Medico.findByTelefonoMedico", query = "SELECT m FROM Medico m WHERE m.telefonoMedico = :telefonoMedico")})
public class Medico implements Serializable {

    @Column(name = "CORREO")
    private String correo;
    @Column(name = "FECHA_NACIMINETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimineto;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "EDAD")
    private BigInteger edad;
    @OneToMany(mappedBy = "idMedico")
    private Collection<Prescripcion> prescripcionCollection;
    @OneToMany(mappedBy = "idMedico")
    private Collection<Receta> recetaCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MEDICO")
    private BigDecimal idMedico;
    @Column(name = "NOMBRE_MED")
    private String nombreMed;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATER")
    private String apellidoMater;
    @Column(name = "RUT_MEDI")
    private String rutMedi;
    @Column(name = "TELEFONO_MEDICO")
    private String telefonoMedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoIdMedico")
    private Collection<Trataminento> trataminentoCollection;
    @JoinColumn(name = "CIUDAD_ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;
    @JoinColumn(name = "NACIONALIDAD_ID_NACIONALIDAD", referencedColumnName = "ID_NACIONALIDAD")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidadIdNacionalidad;
    @JoinColumn(name = "USUARIO_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioIdUsuario;

    public Medico() {
    }

    public Medico(BigDecimal idMedico) {
        this.idMedico = idMedico;
    }

    public BigDecimal getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(BigDecimal idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMater() {
        return apellidoMater;
    }

    public void setApellidoMater(String apellidoMater) {
        this.apellidoMater = apellidoMater;
    }

    public String getRutMedi() {
        return rutMedi;
    }

    public void setRutMedi(String rutMedi) {
        this.rutMedi = rutMedi;
    }

    public String getTelefonoMedico() {
        return telefonoMedico;
    }

    public void setTelefonoMedico(String telefonoMedico) {
        this.telefonoMedico = telefonoMedico;
    }

    @XmlTransient
    public Collection<Trataminento> getTrataminentoCollection() {
        return trataminentoCollection;
    }

    public void setTrataminentoCollection(Collection<Trataminento> trataminentoCollection) {
        this.trataminentoCollection = trataminentoCollection;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    public Nacionalidad getNacionalidadIdNacionalidad() {
        return nacionalidadIdNacionalidad;
    }

    public void setNacionalidadIdNacionalidad(Nacionalidad nacionalidadIdNacionalidad) {
        this.nacionalidadIdNacionalidad = nacionalidadIdNacionalidad;
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
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.Medico[ idMedico=" + idMedico + " ]";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    @XmlTransient
    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }
    
}
