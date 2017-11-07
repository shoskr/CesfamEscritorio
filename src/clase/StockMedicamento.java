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
@Table(name = "STOCK_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockMedicamento.findAll", query = "SELECT s FROM StockMedicamento s")
    , @NamedQuery(name = "StockMedicamento.findByStockMedi", query = "SELECT s FROM StockMedicamento s WHERE s.stockMedi = :stockMedi")
    , @NamedQuery(name = "StockMedicamento.findByStockCritico", query = "SELECT s FROM StockMedicamento s WHERE s.stockCritico = :stockCritico")
    , @NamedQuery(name = "StockMedicamento.findByIdStockMedicamento", query = "SELECT s FROM StockMedicamento s WHERE s.idStockMedicamento = :idStockMedicamento")})
public class StockMedicamento implements Serializable {

    @Column(name = "STOCK_MEDI")
    private int stockMedi;
    @Column(name = "STOCK_CRITICO")
    private int stockCritico;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_STOCK_MEDICAMENTO")
    private int idStockMedicamento;
    @JoinColumn(name = "ARTICULO_Y_MEDICA_CODIGO_AM")
    @ManyToOne(optional = false)
    private int articuloYMedicaCodigoAm;
    @JoinColumn(name = "FARMACIA_ID_FARMACIA")
    @ManyToOne(optional = false)
    private int farmaciaIdFarmacia;
    @JoinColumn(name = "INGRESO_ART_MED_ID_INGRESO")
    @ManyToOne(optional = false)
    private int ingresoArtMedIdIngreso;

    public StockMedicamento() {
    }

    public StockMedicamento(int idStockMedicamento) {
        this.idStockMedicamento = idStockMedicamento;
    }


    public int getStockMedi() {
        return stockMedi;
    }

    public void setStockMedi(int stockMedi) {
        this.stockMedi = stockMedi;
    }

    public int getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    public int getIdStockMedicamento() {
        return idStockMedicamento;
    }

    public void setIdStockMedicamento(int idStockMedicamento) {
        this.idStockMedicamento = idStockMedicamento;
    }

    public int getArticuloYMedicaCodigoAm() {
        return articuloYMedicaCodigoAm;
    }

    public void setArticuloYMedicaCodigoAm(int articuloYMedicaCodigoAm) {
        this.articuloYMedicaCodigoAm = articuloYMedicaCodigoAm;
    }

    public int getFarmaciaIdFarmacia() {
        return farmaciaIdFarmacia;
    }

    public void setFarmaciaIdFarmacia(int farmaciaIdFarmacia) {
        this.farmaciaIdFarmacia = farmaciaIdFarmacia;
    }

    public int getIngresoArtMedIdIngreso() {
        return ingresoArtMedIdIngreso;
    }

    public void setIngresoArtMedIdIngreso(int ingresoArtMedIdIngreso) {
        this.ingresoArtMedIdIngreso = ingresoArtMedIdIngreso;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idStockMedicamento != null ? idStockMedicamento.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof StockMedicamento)) {
//            return false;
//        }
//        StockMedicamento other = (StockMedicamento) object;
//        if ((this.idStockMedicamento == null && other.idStockMedicamento != null) || (this.idStockMedicamento != null && !this.idStockMedicamento.equals(other.idStockMedicamento))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "clase.StockMedicamento[ idStockMedicamento=" + idStockMedicamento + " ]";
    }

    
}
