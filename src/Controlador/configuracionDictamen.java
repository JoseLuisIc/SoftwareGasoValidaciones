/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Usuario
 */
public class configuracionDictamen {
    
    private String NoCre;
    private String TotDispen;
    private String Fecha;
    private String HoraIn; 
    private String HoraFin;
    private String Folio;
    private String Periodo;
    
    public configuracionDictamen(String NoCre, String TotDispen, String Fecha, String HoraIn, String HoraFin, String Folio, String Periodo) {
        this.NoCre = NoCre;
        this.TotDispen = TotDispen;
        this.Fecha = Fecha;
        this.HoraIn = HoraIn;
        this.HoraFin = HoraFin;
        this.Folio = Folio;
        this.Periodo = Periodo;
    }
    
    public configuracionDictamen() {
    }
    
    public String getNoCre() {
        return NoCre;
    }

    public void setNoCre(String NoCre) {
        this.NoCre = NoCre;
    }

    public String getTotDispen() {
        return TotDispen;
    }

    public void setTotDispen(String TotDispen) {
        this.TotDispen = TotDispen;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHoraIn() {
        return HoraIn;
    }

    public void setHoraIn(String HoraIn) {
        this.HoraIn = HoraIn;
    }

    public String getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(String HoraFin) {
        this.HoraFin = HoraFin;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    @Override
    public String toString() {
        return "configuracionDictamen{" + "NoCre=" +
                NoCre + ", TotDispen=" + TotDispen + ", Fecha=" +
                Fecha + ", HoraIn=" + HoraIn + ", HoraFin=" +
                HoraFin + ", Folio=" + Folio + ", Periodo=" + Periodo + '}';
    }
   
    
}
