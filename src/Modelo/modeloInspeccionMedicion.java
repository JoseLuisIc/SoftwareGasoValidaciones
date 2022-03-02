/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author joseluis.caamal
 * Table: tabla_inspeccion_medicion
Columns:
    id_inspeccion_medicion int AI PK 
    folio varchar(45) 
    n_estacion varchar(45) 
    n_dispensario varchar(45) 
    termometro varchar(45) 
    cronometro varchar(45) 
    lado_manguera varchar(45) 
    calc_profeco varchar(45) 
    calc_uva varchar(45) 
    precinto varchar(45) 
    V20 varchar(45) 
    KC varchar(45) 
    gasto_max_p1 varchar(45) 
    gasto_max_p2 varchar(45) 
    gasto_max_p3 varchar(45) 
    gasto_med_p1 varchar(45) 
    gasto_med_p2 varchar(45) 
    gasto_med_p3 varchar(45) 
    gasto_min_p1 varchar(45) 
    gasto_min_p2 varchar(45) 
    gasto_min_p3 varchar(45) 
    gasto_max_lc varchar(45) 
    gasto_med_lc varchar(45) 
    gasto_min_lc varchar(45) 
    gasto_max_er varchar(45) 
    gasto_med_er varchar(45) 
    gasto_min_er varchar(45) 
    temp_max_p1 varchar(45) 
    temp_med_p1 varchar(45) 
    temp_min_p1 varchar(45) 
    temp_max_p2 varchar(45) 
    temp_med_p2 varchar(45) 
    temp_min_p2 varchar(45) 
    temp_max_p3 varchar(45) 
    temp_med_p3 varchar(45) 
    temp_min_p3 varchar(45) 
    i_max_p1 varchar(45) 
    i_med_p1 varchar(45) 
    i_min_p1 varchar(45) 
    i_max_p2 varchar(45) 
    i_med_p2 varchar(45) 
    i_min_p2 varchar(45) 
    i_max_p3 varchar(45) 
    i_med_p3 varchar(45) 
    i_min_p3 varchar(45) 
    i_max_lc varchar(45) 
    i_med_lc varchar(45) 
    i_min_lc varchar(45) 
    tiempo_max_p1 varchar(45) 
    tiempo_med_p1 varchar(45) 
    tiempo_min_p1 varchar(45) 
    tiempo_max_p2 varchar(45) 
    tiempo_med_p2 varchar(45) 
    tiempo_min_p2 varchar(45) 
    tiempo_max_p3 varchar(45) 
    tiempo_med_p3 varchar(45) 
    tiempo_min_p3 varchar(45) 
    vcmv_gmax varchar(45) 
    vcmv_gmed varchar(45) 
    vcmv_gmin varchar(45) 
    e_gmax varchar(45) 
    e_gmed varbinary(45) 
    e_gmin varchar(45) 
    qv_gmax varchar(45) 
    qv_gmed varchar(45) 
    qv_gmin varchar(45) 
    restultados_ml1 varchar(45) 
    resultados_ml2 varchar(45)
 */
public class modeloInspeccionMedicion {
    private int id;
    private String folio;
    private String n_estacion;
    private String n_dispensario;
    private String termometro;
    private String cronometro;
    private String lado_manguera;
    private String calc_profeco;
    private String calc_uva;
    private String precinto;
    private String V20;
    private String KC;
    private String gasto_max_p1;
    private String gasto_max_p2;
    private String gasto_max_p3;
    private String gasto_med_p1;
    private String gasto_med_p2;
    private String gasto_med_p3;
    private String gasto_min_p1; 
    private String gasto_min_p2;
    private String gasto_min_p3; 
    private String gasto_max_lc; 
    private String gasto_med_lc;
    private String gasto_min_lc; 
    private String gasto_max_er; 
    private String gasto_med_er; 
    private String gasto_min_er;
    private String temp_max_p1;
    private String temp_med_p1; 
    private String temp_min_p1; 
    private String temp_max_p2; 
    private String temp_med_p2;
    private String temp_min_p2;
    private String temp_max_p3; 
    private String temp_med_p3;
    private String temp_min_p3;
    private String i_max_p1; 
    private String i_med_p1; 
    private String i_min_p1; 
    private String i_max_p2;
    private String i_med_p2;
    private String i_min_p2;
    private String i_max_p3;
    private String i_med_p3; 
    private String i_min_p3;
    private String i_max_lc;
    private String i_med_lc; 
    private String i_min_lc;
    private String tiempo_max_p1;
    private String tiempo_med_p1;
    private String tiempo_min_p1;
    private String tiempo_max_p2;
    private String tiempo_med_p2; 
    private String tiempo_min_p2;
    private String tiempo_max_p3;
    private String tiempo_med_p3; 
    private String tiempo_min_p3;
    private String vcmv_gmax;
    private String vcmv_gmed; 
    private String vcmv_gmin; 
    private String e_gmax;
    private String e_gmed; 
    private String e_gmin; 
    private String qv_gmax;
    private String qv_gmed;
    private String qv_gmin;
    private String restultados_ml1;
    private String resultados_ml2;
    private String ID_jarra;
    private int incluido;

    public modeloInspeccionMedicion() {
    }

    public modeloInspeccionMedicion(int id, String folio, String n_estacion, String n_dispensario, String termometro, String cronometro, String lado_manguera, String calc_profeco, String calc_uva, String precinto, String V20, String KC, String gasto_max_p1, String gasto_max_p2, String gasto_max_p3, String gasto_med_p1, String gasto_med_p2, String gasto_med_p3, String gasto_min_p1, String gasto_min_p2, String gasto_min_p3, String gasto_max_lc, String gasto_med_lc, String gasto_min_lc, String gasto_max_er, String gasto_med_er, String gasto_min_er, String temp_max_p1, String temp_med_p1, String temp_min_p1, String temp_max_p2, String temp_med_p2, String temp_min_p2, String temp_max_p3, String temp_med_p3, String temp_min_p3, String i_max_p1, String i_med_p1, String i_min_p1, String i_max_p2, String i_med_p2, String i_min_p2, String i_max_p3, String i_med_p3, String i_min_p3, String i_max_lc, String i_med_lc, String i_min_lc, String tiempo_max_p1, String tiempo_med_p1, String tiempo_min_p1, String tiempo_max_p2, String tiempo_med_p2, String tiempo_min_p2, String tiempo_max_p3, String tiempo_med_p3, String tiempo_min_p3, String vcmv_gmax, String vcmv_gmed, String vcmv_gmin, String e_gmax, String e_gmed, String e_gmin, String qv_gmax, String qv_gmed, String qv_gmin, String restultados_ml1, String resultados_ml2,String ID_jarra, int incluido) {
        this.id = id;
        this.folio = folio;
        this.n_estacion = n_estacion;
        this.n_dispensario = n_dispensario;
        this.termometro = termometro;
        this.cronometro = cronometro;
        this.lado_manguera = lado_manguera;
        this.calc_profeco = calc_profeco;
        this.calc_uva = calc_uva;
        this.precinto = precinto;
        this.V20 = V20;
        this.KC = KC;
        this.gasto_max_p1 = gasto_max_p1;
        this.gasto_max_p2 = gasto_max_p2;
        this.gasto_max_p3 = gasto_max_p3;
        this.gasto_med_p1 = gasto_med_p1;
        this.gasto_med_p2 = gasto_med_p2;
        this.gasto_med_p3 = gasto_med_p3;
        this.gasto_min_p1 = gasto_min_p1;
        this.gasto_min_p2 = gasto_min_p2;
        this.gasto_min_p3 = gasto_min_p3;
        this.gasto_max_lc = gasto_max_lc;
        this.gasto_med_lc = gasto_med_lc;
        this.gasto_min_lc = gasto_min_lc;
        this.gasto_max_er = gasto_max_er;
        this.gasto_med_er = gasto_med_er;
        this.gasto_min_er = gasto_min_er;
        this.temp_max_p1 = temp_max_p1;
        this.temp_med_p1 = temp_med_p1;
        this.temp_min_p1 = temp_min_p1;
        this.temp_max_p2 = temp_max_p2;
        this.temp_med_p2 = temp_med_p2;
        this.temp_min_p2 = temp_min_p2;
        this.temp_max_p3 = temp_max_p3;
        this.temp_med_p3 = temp_med_p3;
        this.temp_min_p3 = temp_min_p3;
        this.i_max_p1 = i_max_p1;
        this.i_med_p1 = i_med_p1;
        this.i_min_p1 = i_min_p1;
        this.i_max_p2 = i_max_p2;
        this.i_med_p2 = i_med_p2;
        this.i_min_p2 = i_min_p2;
        this.i_max_p3 = i_max_p3;
        this.i_med_p3 = i_med_p3;
        this.i_min_p3 = i_min_p3;
        this.i_max_lc = i_max_lc;
        this.i_med_lc = i_med_lc;
        this.i_min_lc = i_min_lc;
        this.tiempo_max_p1 = tiempo_max_p1;
        this.tiempo_med_p1 = tiempo_med_p1;
        this.tiempo_min_p1 = tiempo_min_p1;
        this.tiempo_max_p2 = tiempo_max_p2;
        this.tiempo_med_p2 = tiempo_med_p2;
        this.tiempo_min_p2 = tiempo_min_p2;
        this.tiempo_max_p3 = tiempo_max_p3;
        this.tiempo_med_p3 = tiempo_med_p3;
        this.tiempo_min_p3 = tiempo_min_p3;
        this.vcmv_gmax = vcmv_gmax;
        this.vcmv_gmed = vcmv_gmed;
        this.vcmv_gmin = vcmv_gmin;
        this.e_gmax = e_gmax;
        this.e_gmed = e_gmed;
        this.e_gmin = e_gmin;
        this.qv_gmax = qv_gmax;
        this.qv_gmed = qv_gmed;
        this.qv_gmin = qv_gmin;
        this.restultados_ml1 = restultados_ml1;
        this.resultados_ml2 = resultados_ml2;
        this.ID_jarra= ID_jarra;
        this.incluido = incluido;
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

    public String getN_dispensario() {
        return n_dispensario;
    }

    public void setN_dispensario(String n_dispensario) {
        this.n_dispensario = n_dispensario;
    }

    public String getTermometro() {
        return termometro;
    }

    public void setTermometro(String termometro) {
        this.termometro = termometro;
    }

    public String getCronometro() {
        return cronometro;
    }

    public void setCronometro(String cronometro) {
        this.cronometro = cronometro;
    }

    public String getLado_manguera() {
        return lado_manguera;
    }

    public void setLado_manguera(String lado_manguera) {
        this.lado_manguera = lado_manguera;
    }

    public String getCalc_profeco() {
        return calc_profeco;
    }

    public void setCalc_profeco(String calc_profeco) {
        this.calc_profeco = calc_profeco;
    }

    public String getCalc_uva() {
        return calc_uva;
    }

    public void setCalc_uva(String calc_uva) {
        this.calc_uva = calc_uva;
    }

    public String getPrecinto() {
        return precinto;
    }

    public void setPrecinto(String precinto) {
        this.precinto = precinto;
    }

    public String getV20() {
        return V20;
    }

    public void setV20(String V20) {
        this.V20 = V20;
    }

    public String getKC() {
        return KC;
    }

    public void setKC(String KC) {
        this.KC = KC;
    }

    public String getGasto_max_p1() {
        return gasto_max_p1;
    }

    public void setGasto_max_p1(String gasto_max_p1) {
        this.gasto_max_p1 = gasto_max_p1;
    }

    public String getGasto_max_p2() {
        return gasto_max_p2;
    }

    public void setGasto_max_p2(String gasto_max_p2) {
        this.gasto_max_p2 = gasto_max_p2;
    }

    public String getGasto_max_p3() {
        return gasto_max_p3;
    }

    public void setGasto_max_p3(String gasto_max_p3) {
        this.gasto_max_p3 = gasto_max_p3;
    }

    public String getGasto_med_p1() {
        return gasto_med_p1;
    }

    public void setGasto_med_p1(String gasto_med_p1) {
        this.gasto_med_p1 = gasto_med_p1;
    }

    public String getGasto_med_p2() {
        return gasto_med_p2;
    }

    public void setGasto_med_p2(String gasto_med_p2) {
        this.gasto_med_p2 = gasto_med_p2;
    }

    public String getGasto_med_p3() {
        return gasto_med_p3;
    }

    public void setGasto_med_p3(String gasto_med_p3) {
        this.gasto_med_p3 = gasto_med_p3;
    }

    public String getGasto_min_p1() {
        return gasto_min_p1;
    }

    public void setGasto_min_p1(String gasto_min_p1) {
        this.gasto_min_p1 = gasto_min_p1;
    }

    public String getGasto_min_p2() {
        return gasto_min_p2;
    }

    public void setGasto_min_p2(String gasto_min_p2) {
        this.gasto_min_p2 = gasto_min_p2;
    }

    public String getGasto_min_p3() {
        return gasto_min_p3;
    }

    public void setGasto_min_p3(String gasto_min_p3) {
        this.gasto_min_p3 = gasto_min_p3;
    }

    public String getGasto_max_lc() {
        return gasto_max_lc;
    }

    public void setGasto_max_lc(String gasto_max_lc) {
        this.gasto_max_lc = gasto_max_lc;
    }

    public String getGasto_med_lc() {
        return gasto_med_lc;
    }

    public void setGasto_med_lc(String gasto_med_lc) {
        this.gasto_med_lc = gasto_med_lc;
    }

    public String getGasto_min_lc() {
        return gasto_min_lc;
    }

    public void setGasto_min_lc(String gasto_min_lc) {
        this.gasto_min_lc = gasto_min_lc;
    }

    public String getGasto_max_er() {
        return gasto_max_er;
    }

    public void setGasto_max_er(String gasto_max_er) {
        this.gasto_max_er = gasto_max_er;
    }

    public String getGasto_med_er() {
        return gasto_med_er;
    }

    public void setGasto_med_er(String gasto_med_er) {
        this.gasto_med_er = gasto_med_er;
    }

    public String getGasto_min_er() {
        return gasto_min_er;
    }

    public void setGasto_min_er(String gasto_min_er) {
        this.gasto_min_er = gasto_min_er;
    }

    public String getTemp_max_p1() {
        return temp_max_p1;
    }

    public void setTemp_max_p1(String temp_max_p1) {
        this.temp_max_p1 = temp_max_p1;
    }

    public String getTemp_med_p1() {
        return temp_med_p1;
    }

    public void setTemp_med_p1(String temp_med_p1) {
        this.temp_med_p1 = temp_med_p1;
    }

    public String getTemp_min_p1() {
        return temp_min_p1;
    }

    public void setTemp_min_p1(String temp_min_p1) {
        this.temp_min_p1 = temp_min_p1;
    }

    public String getTemp_max_p2() {
        return temp_max_p2;
    }

    public void setTemp_max_p2(String temp_max_p2) {
        this.temp_max_p2 = temp_max_p2;
    }

    public String getTemp_med_p2() {
        return temp_med_p2;
    }

    public void setTemp_med_p2(String temp_med_p2) {
        this.temp_med_p2 = temp_med_p2;
    }

    public String getTemp_min_p2() {
        return temp_min_p2;
    }

    public void setTemp_min_p2(String temp_min_p2) {
        this.temp_min_p2 = temp_min_p2;
    }

    public String getTemp_max_p3() {
        return temp_max_p3;
    }

    public void setTemp_max_p3(String temp_max_p3) {
        this.temp_max_p3 = temp_max_p3;
    }

    public String getTemp_med_p3() {
        return temp_med_p3;
    }

    public void setTemp_med_p3(String temp_med_p3) {
        this.temp_med_p3 = temp_med_p3;
    }

    public String getTemp_min_p3() {
        return temp_min_p3;
    }

    public void setTemp_min_p3(String temp_min_p3) {
        this.temp_min_p3 = temp_min_p3;
    }

    public String getI_max_p1() {
        return i_max_p1;
    }

    public void setI_max_p1(String i_max_p1) {
        this.i_max_p1 = i_max_p1;
    }

    public String getI_med_p1() {
        return i_med_p1;
    }

    public void setI_med_p1(String i_med_p1) {
        this.i_med_p1 = i_med_p1;
    }

    public String getI_min_p1() {
        return i_min_p1;
    }

    public void setI_min_p1(String i_min_p1) {
        this.i_min_p1 = i_min_p1;
    }

    public String getI_max_p2() {
        return i_max_p2;
    }

    public void setI_max_p2(String i_max_p2) {
        this.i_max_p2 = i_max_p2;
    }

    public String getI_med_p2() {
        return i_med_p2;
    }

    public void setI_med_p2(String i_med_p2) {
        this.i_med_p2 = i_med_p2;
    }

    public String getI_min_p2() {
        return i_min_p2;
    }

    public void setI_min_p2(String i_min_p2) {
        this.i_min_p2 = i_min_p2;
    }

    public String getI_max_p3() {
        return i_max_p3;
    }

    public void setI_max_p3(String i_max_p3) {
        this.i_max_p3 = i_max_p3;
    }

    public String getI_med_p3() {
        return i_med_p3;
    }

    public void setI_med_p3(String i_med_p3) {
        this.i_med_p3 = i_med_p3;
    }

    public String getI_min_p3() {
        return i_min_p3;
    }

    public void setI_min_p3(String i_min_p3) {
        this.i_min_p3 = i_min_p3;
    }

    public String getI_max_lc() {
        return i_max_lc;
    }

    public void setI_max_lc(String i_max_lc) {
        this.i_max_lc = i_max_lc;
    }

    public String getI_med_lc() {
        return i_med_lc;
    }

    public void setI_med_lc(String i_med_lc) {
        this.i_med_lc = i_med_lc;
    }

    public String getI_min_lc() {
        return i_min_lc;
    }

    public void setI_min_lc(String i_min_lc) {
        this.i_min_lc = i_min_lc;
    }

    public String getTiempo_max_p1() {
        return tiempo_max_p1;
    }

    public void setTiempo_max_p1(String tiempo_max_p1) {
        this.tiempo_max_p1 = tiempo_max_p1;
    }

    public String getTiempo_med_p1() {
        return tiempo_med_p1;
    }

    public void setTiempo_med_p1(String tiempo_med_p1) {
        this.tiempo_med_p1 = tiempo_med_p1;
    }

    public String getTiempo_min_p1() {
        return tiempo_min_p1;
    }

    public void setTiempo_min_p1(String tiempo_min_p1) {
        this.tiempo_min_p1 = tiempo_min_p1;
    }

    public String getTiempo_max_p2() {
        return tiempo_max_p2;
    }

    public void setTiempo_max_p2(String tiempo_max_p2) {
        this.tiempo_max_p2 = tiempo_max_p2;
    }

    public String getTiempo_med_p2() {
        return tiempo_med_p2;
    }

    public void setTiempo_med_p2(String tiempo_med_p2) {
        this.tiempo_med_p2 = tiempo_med_p2;
    }

    public String getTiempo_min_p2() {
        return tiempo_min_p2;
    }

    public void setTiempo_min_p2(String tiempo_min_p2) {
        this.tiempo_min_p2 = tiempo_min_p2;
    }

    public String getTiempo_max_p3() {
        return tiempo_max_p3;
    }

    public void setTiempo_max_p3(String tiempo_max_p3) {
        this.tiempo_max_p3 = tiempo_max_p3;
    }

    public String getTiempo_med_p3() {
        return tiempo_med_p3;
    }

    public void setTiempo_med_p3(String tiempo_med_p3) {
        this.tiempo_med_p3 = tiempo_med_p3;
    }

    public String getTiempo_min_p3() {
        return tiempo_min_p3;
    }

    public void setTiempo_min_p3(String tiempo_min_p3) {
        this.tiempo_min_p3 = tiempo_min_p3;
    }

    public String getVcmv_gmax() {
        return vcmv_gmax;
    }

    public void setVcmv_gmax(String vcmv_gmax) {
        this.vcmv_gmax = vcmv_gmax;
    }

    public String getVcmv_gmed() {
        return vcmv_gmed;
    }

    public void setVcmv_gmed(String vcmv_gmed) {
        this.vcmv_gmed = vcmv_gmed;
    }

    public String getVcmv_gmin() {
        return vcmv_gmin;
    }

    public void setVcmv_gmin(String vcmv_gmin) {
        this.vcmv_gmin = vcmv_gmin;
    }

    public String getE_gmax() {
        return e_gmax;
    }

    public void setE_gmax(String e_gmax) {
        this.e_gmax = e_gmax;
    }

    public String getE_gmed() {
        return e_gmed;
    }

    public void setE_gmed(String e_gmed) {
        this.e_gmed = e_gmed;
    }

    public String getE_gmin() {
        return e_gmin;
    }

    public void setE_gmin(String e_gmin) {
        this.e_gmin = e_gmin;
    }

    public String getQv_gmax() {
        return qv_gmax;
    }

    public void setQv_gmax(String qv_gmax) {
        this.qv_gmax = qv_gmax;
    }

    public String getQv_gmed() {
        return qv_gmed;
    }

    public void setQv_gmed(String qv_gmed) {
        this.qv_gmed = qv_gmed;
    }

    public String getQv_gmin() {
        return qv_gmin;
    }

    public void setQv_gmin(String qv_gmin) {
        this.qv_gmin = qv_gmin;
    }

    public String getRestultados_ml1() {
        return restultados_ml1;
    }

    public void setRestultados_ml1(String restultados_ml1) {
        this.restultados_ml1 = restultados_ml1;
    }

    public String getResultados_ml2() {
        return resultados_ml2;
    }

    public void setResultados_ml2(String resultados_ml2) {
        this.resultados_ml2 = resultados_ml2;
    }

    public int getIncluido() {
        return incluido;
    }

    public void setIncluido(int incluido) {
        this.incluido = incluido;
    }
    //Joel Estrella 23/02/2022

    public String getID_jarra() {
        return ID_jarra;
    }

    public void setID_jarra(String ID_jarra) {
        this.ID_jarra = ID_jarra;
    }

    
    @Override
    public String toString() {
        return "modeloInspeccionMedicion{" + "id=" + id + ", folio=" + folio + ", n_estacion=" + n_estacion + ", n_dispensario=" + n_dispensario + ", termometro=" + termometro + ", cronometro=" + cronometro + ", lado_manguera=" + lado_manguera + ", calc_profeco=" + calc_profeco + ", calc_uva=" + calc_uva + ", precinto=" + precinto + ", V20=" + V20 + ", KC=" + KC + ", gasto_max_p1=" + gasto_max_p1 + ", gasto_max_p2=" + gasto_max_p2 + ", gasto_max_p3=" + gasto_max_p3 + ", gasto_med_p1=" + gasto_med_p1 + ", gasto_med_p2=" + gasto_med_p2 + ", gasto_med_p3=" + gasto_med_p3 + ", gasto_min_p1=" + gasto_min_p1 + ", gasto_min_p2=" + gasto_min_p2 + ", gasto_min_p3=" + gasto_min_p3 + ", gasto_max_lc=" + gasto_max_lc + ", gasto_med_lc=" + gasto_med_lc + ", gasto_min_lc=" + gasto_min_lc + ", gasto_max_er=" + gasto_max_er + ", gasto_med_er=" + gasto_med_er + ", gasto_min_er=" + gasto_min_er + ", temp_max_p1=" + temp_max_p1 + ", temp_med_p1=" + temp_med_p1 + ", temp_min_p1=" + temp_min_p1 + ", temp_max_p2=" + temp_max_p2 + ", temp_med_p2=" + temp_med_p2 + ", temp_min_p2=" + temp_min_p2 + ", temp_max_p3=" + temp_max_p3 + ", temp_med_p3=" + temp_med_p3 + ", temp_min_p3=" + temp_min_p3 + ", i_max_p1=" + i_max_p1 + ", i_med_p1=" + i_med_p1 + ", i_min_p1=" + i_min_p1 + ", i_max_p2=" + i_max_p2 + ", i_med_p2=" + i_med_p2 + ", i_min_p2=" + i_min_p2 + ", i_max_p3=" + i_max_p3 + ", i_med_p3=" + i_med_p3 + ", i_min_p3=" + i_min_p3 + ", i_max_lc=" + i_max_lc + ", i_med_lc=" + i_med_lc + ", i_min_lc=" + i_min_lc + ", tiempo_max_p1=" + tiempo_max_p1 + ", tiempo_med_p1=" + tiempo_med_p1 + ", tiempo_min_p1=" + tiempo_min_p1 + ", tiempo_max_p2=" + tiempo_max_p2 + ", tiempo_med_p2=" + tiempo_med_p2 + ", tiempo_min_p2=" + tiempo_min_p2 + ", tiempo_max_p3=" + tiempo_max_p3 + ", tiempo_med_p3=" + tiempo_med_p3 + ", tiempo_min_p3=" + tiempo_min_p3 + ", vcmv_gmax=" + vcmv_gmax + ", vcmv_gmed=" + vcmv_gmed + ", vcmv_gmin=" + vcmv_gmin + ", e_gmax=" + e_gmax + ", e_gmed=" + e_gmed + ", e_gmin=" + e_gmin + ", qv_gmax=" + qv_gmax + ", qv_gmed=" + qv_gmed + ", qv_gmin=" + qv_gmin + ", restultados_ml1=" + restultados_ml1 + ", resultados_ml2=" + resultados_ml2 + ", incluido=" + incluido + '}';
    }

    
}