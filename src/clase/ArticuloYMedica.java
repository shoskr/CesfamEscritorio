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
@Table(name = "ARTICULO_Y_MEDICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticuloYMedica.findAll", query = "SELECT a FROM ArticuloYMedica a")
    , @NamedQuery(name = "ArticuloYMedica.findByCodigoAm", query = "SELECT a FROM ArticuloYMedica a WHERE a.codigoAm = :codigoAm")
    , @NamedQuery(name = "ArticuloYMedica.findByDescripcion", query = "SELECT a FROM ArticuloYMedica a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "ArticuloYMedica.findByFabricante", query = "SELECT a FROM ArticuloYMedica a WHERE a.fabricante = :fabricante")
    , @NamedQuery(name = "ArticuloYMedica.findByTipoMedicamento", query = "SELECT a FROM ArticuloYMedica a WHERE a.tipoMedicamento = :tipoMedicamento")
    , @NamedQuery(name = "ArticuloYMedica.findByComponentes", query = "SELECT a FROM ArticuloYMedica a WHERE a.componentes = :componentes")
    , @NamedQuery(name = "ArticuloYMedica.findByContenido", query = "SELECT a FROM ArticuloYMedica a WHERE a.contenido = :contenido")
    , @NamedQuery(name = "ArticuloYMedica.findByCantidad", query = "SELECT a FROM ArticuloYMedica a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "ArticuloYMedica.findByGramaje", query = "SELECT a FROM ArticuloYMedica a WHERE a.gramaje = :gramaje")})
public class ArticuloYMedica implements Serializable {

    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<StockMedicamento> stockMedicamentoCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_AM")
    private BigDecimal codigoAm;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FABRICANTE")
    private String fabricante;
    @Column(name = "TIPO_MEDICAMENTO")
    private String tipoMedicamento;
    @Column(name = "COMPONENTES")
    private String componentes;
    @Column(name = "CONTENIDO")
    private String contenido;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "GRAMAJE")
    private String gramaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<RetiroMedicamento> retiroMedicamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<Prescripcion> prescripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<IngresoArtMed> ingresoArtMedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<Merma> mermaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articuloYMedicaCodigoAm")
    private Collection<Reserva> reservaCollection;

    public ArticuloYMedica() {
    }

    public ArticuloYMedica(BigDecimal codigoAm) {
        this.codigoAm = codigoAm;
    }

    public BigDecimal getCodigoAm() {
        return codigoAm;
    }

    public void setCodigoAm(BigDecimal codigoAm) {
        this.codigoAm = codigoAm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public String getGramaje() {
        return gramaje;
    }

    public void setGramaje(String gramaje) {
        this.gramaje = gramaje;
    }

    @XmlTransient
    public Collection<RetiroMedicamento> getRetiroMedicamentoCollection() {
        return retiroMedicamentoCollection;
    }

    public void setRetiroMedicamentoCollection(Collection<RetiroMedicamento> retiroMedicamentoCollection) {
        this.retiroMedicamentoCollection = retiroMedicamentoCollection;
    }

    @XmlTransient
    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }

    @XmlTransient
    public Collection<IngresoArtMed> getIngresoArtMedCollection() {
        return ingresoArtMedCollection;
    }

    public void setIngresoArtMedCollection(Collection<IngresoArtMed> ingresoArtMedCollection) {
        this.ingresoArtMedCollection = ingresoArtMedCollection;
    }

    @XmlTransient
    public Collection<Merma> getMermaCollection() {
        return mermaCollection;
    }

    public void setMermaCollection(Collection<Merma> mermaCollection) {
        this.mermaCollection = mermaCollection;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAm != null ? codigoAm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticuloYMedica)) {
            return false;
        }
        ArticuloYMedica other = (ArticuloYMedica) object;
        if ((this.codigoAm == null && other.codigoAm != null) || (this.codigoAm != null && !this.codigoAm.equals(other.codigoAm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clase.ArticuloYMedica[ codigoAm=" + codigoAm + " ]";
    }

    @XmlTransient
    public Collection<StockMedicamento> getStockMedicamentoCollection() {
        return stockMedicamentoCollection;
    }

    public void setStockMedicamentoCollection(Collection<StockMedicamento> stockMedicamentoCollection) {
        this.stockMedicamentoCollection = stockMedicamentoCollection;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
}
