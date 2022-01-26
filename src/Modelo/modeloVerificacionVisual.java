/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author joseluis.caamal
 * @DATA
 * idtabla_verificacion_visual int AI PK 
 *  folio varchar(45) 
 *   n_estacion varchar(45) 
 *   dispensario varchar(45) 
 *   leyendas varchar(45) 
 *   placa varchar(45) 
 *   caratula varchar(45) 
 *   signo varchar(45) 
 *   disp_contador varchar(45) 
 *   mecanismo varchar(45) 
 *   disp_despacho varchar(45) 
 *   golpes varchar(45) 
 *   tiempo varchar(45)
 * @since 12/09/2021
 * @version 1.0
 */
public class modeloVerificacionVisual {
    private int id;
    private String folio;
    private String n_estacion;
    private String n_dispensario;
    private String leyendas;
    private String placa;
    private String caratula;
    private String signo;
    private String disp_contador;
    private String mecanismo;
    private String disp_despacho;
    private String golpes;
    private String tiempo;

    public modeloVerificacionVisual() {
    }

    public modeloVerificacionVisual(int id, String folio, String n_estacion, String dispensario, String leyendas, String placa, String caratula, String signo, String disp_contador, String mecanismo, String disp_despacho, String golpes, String tiempo) {
        this.id = id;
        this.folio = folio;
        this.n_estacion = n_estacion;
        this.n_dispensario = dispensario;
        this.leyendas = leyendas;
        this.placa = placa;
        this.caratula = caratula;
        this.signo = signo;
        this.disp_contador = disp_contador;
        this.mecanismo = mecanismo;
        this.disp_despacho = disp_despacho;
        this.golpes = golpes;
        this.tiempo = tiempo;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    public String getN_estacion() {
        return n_estacion;
    }

    public void setN_estacion(String n_estacion) {
        this.n_estacion = n_estacion;
    }

    public String getDispensario() {
        return n_dispensario;
    }

    public void setDispensario(String dispensario) {
        this.n_dispensario = dispensario;
    }

    public String getLeyendas() {
        return leyendas;
    }

    public void setLeyendas(String leyendas) {
        this.leyendas = leyendas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getDisp_contador() {
        return disp_contador;
    }

    public void setDisp_contador(String disp_contador) {
        this.disp_contador = disp_contador;
    }

    public String getMecanismo() {
        return mecanismo;
    }

    public void setMecanismo(String mecanismo) {
        this.mecanismo = mecanismo;
    }

    public String getDisp_despacho() {
        return disp_despacho;
    }

    public void setDisp_despacho(String disp_despacho) {
        this.disp_despacho = disp_despacho;
    }

    public String getGolpes() {
        return golpes;
    }

    public void setGolpes(String golpes) {
        this.golpes = golpes;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "modeloVerificacionVisual{" + "id=" + id + ", folio=" + folio + ", n_estacion=" + n_estacion + ", dispensario=" + n_dispensario + ", leyendas=" + leyendas + ", placa=" + placa + ", caratula=" + caratula + ", signo=" + signo + ", disp_contador=" + disp_contador + ", mecanismo=" + mecanismo + ", disp_despacho=" + disp_despacho + ", golpes=" + golpes + ", tiempo=" + tiempo + '}';
    }


    
    
}
