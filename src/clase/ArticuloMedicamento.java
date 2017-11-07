package clase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LSP
 */
public class ArticuloMedicamento {
    
    public int codigoAm;
    public String descripcion;
   public String fabricante;
   public String  tipoMedicamento;
   public String  componentes;
   public String contenido;
    public int cantidad; 
    public String gramaje;
    public StockMedicamento StockMedicamento;  

    public int getCodigoAm() {
        return codigoAm;
    }

    public void setCodigoAm(int codigoAm) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getGramaje() {
        return gramaje;
    }

    public void setGramaje(String gramaje) {
        this.gramaje = gramaje;
    }

    public StockMedicamento getStockMedicamento() {
        return StockMedicamento;
    }

    public void setStockMedicamento(StockMedicamento StockMedicamento) {
        this.StockMedicamento = StockMedicamento;
    }

    public ArticuloMedicamento() {
    }

    public ArticuloMedicamento(int codigoAm) {
        this.codigoAm = codigoAm;
    }

    
    
    public ArticuloMedicamento(int codigoAm, String descripcion, String fabricante, String tipoMedicamento, String componentes, String contenido, int cantidad, String gramaje, StockMedicamento StockMedicamento) {
        this.codigoAm = codigoAm;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.tipoMedicamento = tipoMedicamento;
        this.componentes = componentes;
        this.contenido = contenido;
        this.cantidad = cantidad;
        this.gramaje = gramaje;
        this.StockMedicamento = StockMedicamento;
    }

    @Override
    public String toString() {
        return "ArticuloMedicamento{" + "codigoAm=" + codigoAm + ", descripcion=" + descripcion + ", fabricante=" + fabricante + ", tipoMedicamento=" + tipoMedicamento + ", componentes=" + componentes + ", contenido=" + contenido + ", cantidad=" + cantidad + ", gramaje=" + gramaje + ", StockMedicamento=" + StockMedicamento + '}';
    }

      
}