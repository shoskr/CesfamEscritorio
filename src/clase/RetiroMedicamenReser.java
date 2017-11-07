/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "RETIRO_MEDICAMEN_RESER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetiroMedicamenReser.findAll", query = "SELECT r FROM RetiroMedicamenReser r")
    , @NamedQuery(name = "RetiroMedicamenReser.findByIdRetiroRe", query = "SELECT r FROM RetiroMedicamenReser r WHERE r.idRetiroRe = :idRetiroRe")
    , @NamedQuery(name = "RetiroMedicamenReser.findByCantidad", query = "SELECT r FROM RetiroMedicamenReser r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "RetiroMedicamenReser.findByNombreReceptor", query = "SELECT r FROM RetiroMedicamenReser r WHERE r.nombreReceptor = :nombreReceptor")
    , @NamedQuery(name = "RetiroMedicamenReser.findByFechaRetiro", query = "SELECT r FROM RetiroMedicamenReser r WHERE r.fechaRetiro = :fechaRetiro")})
public class RetiroMedicamenReser implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RETIRO_RE")
    private BigDecimal idRetiroRe;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "NOMBRE_RECEPTOR")
    private String nombreReceptor;
    @Column(name = "FECHA_RETIRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRetiro;
    @JoinColumn(name = "RESERVA_ID_RESERVA", referencedColumnName = "ID_RESERVA")
    @ManyToOne(optional = false)
    private Reserva reservaIdReserva;
    @JoinColumn(name = "RETIRO_MEDICAMENTO_ID_RETIRO", referencedColumnName = "ID_RETIRO")
    @ManyToOne(optional = false)
    private RetiroMedicamento retiroMedicamentoIdRetiro;

    public RetiroMedicamenReser() {
    }

    public RetiroMedicamenReser(BigDecimal idRetiroRe) {
        this.idRetiroRe = idRetiroRe;
    }

    public BigDecimal getIdRetiroRe() {
        return idRetiroRe;
    }

    public void setIdRetiroRe(BigDecimal idRetiroRe) {
        this.idRetiroRe = idRetiroRe;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
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

    public Reserva getReservaIdReserva() {
        return reservaIdReserva;
    }

    public void setReservaIdReserva(Reserva reservaIdReserva) {
        this.reservaIdReserva = reservaIdReserva;
    }

    public RetiroMedicamento getRetiroMedicamentoIdRetiro() {
        return retiroMedicamentoIdRetiro;
    }

    public void setRetiroMedicamentoIdRetiro(RetiroMedicamento retiroMedicamentoIdRetiro) {
        this.retiroMedicamentoIdRetiro = retiroMedicamentoIdRetiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetiroRe != null ? idRetiroRe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetiroMedicamenReser)) {
            return false;
        }
        RetiroMedicamenReser other = (RetiroMedicamenReser) object;
        if ((this.idRetiroRe == null && other.idRetiroRe != null) || (this.idRetiroRe != null && !this.idRetiroRe.equals(other.idRetiroRe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.RetiroMedicamenReser[ idRetiroRe=" + idRetiroRe + " ]";
    }
    
}
