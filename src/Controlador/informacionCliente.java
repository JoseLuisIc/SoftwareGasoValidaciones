/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;

/**
 *
 * @author joseluis.caamal
 * id_dispensario int AI PK 
* no_dispensario int 
*    numero_estacion varchar(45) 
 *   marca_dispensario varchar(45) 
 *   modelo varchar(45) 
 *   numSerie varchar(45) 
 *   alcanceMin varchar(45) 
 *   aprobacionDGN varchar(45) 
 *   alcanceMax varchar(45) 
  *  mangueraA varchar(45) 
  *  mangueraB varchar(45) 
  *  mangueraC varchar(45) 
   * mangueraD varchar(45) 
  *  mangueraE varchar(45) 
  *  mangueraF varchar(45) 
  *  fecha_reg_disp datetime
 */
public class informacionCliente {
    private int id_dispensario;
    private int no_dispensario;
    private String numero_estacion;
    private String marca_dispensario;
    private String modelo;
    private String numSerie;
    private String alcanceMin;
    private String aprobacionDGN;
    private String alcanceMax;
    private String mangueraA; 
    private String mangueraB;
    private String mangueraC;
    private String mangueraD; 
    private String mangueraE;
    private String mangueraF;
    private Date fecha_reg_disp;

    public informacionCliente() {
    }
    
    
    public informacionCliente(int id_dispensario, int no_dispensario, String numero_estacion, String marca_dispensario, String modelo, String numSerie, String alcanceMin, String aprobacionDGN, String alcanceMax, String mangueraA, String mangueraB, String mangueraC, String mangueraD, String mangueraE, String mangueraF, Date fecha_reg_disp) {
        this.id_dispensario = id_dispensario;
        this.no_dispensario = no_dispensario;
        this.numero_estacion = numero_estacion;
        this.marca_dispensario = marca_dispensario;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.alcanceMin = alcanceMin;
        this.aprobacionDGN = aprobacionDGN;
        this.alcanceMax = alcanceMax;
        this.mangueraA = mangueraA;
        this.mangueraB = mangueraB;
        this.mangueraC = mangueraC;
        this.mangueraD = mangueraD;
        this.mangueraE = mangueraE;
        this.mangueraF = mangueraF;
        this.fecha_reg_disp = fecha_reg_disp;
    }

    public int getId_dispensario() {
        return id_dispensario;
    }

    public void setId_dispensario(int id_dispensario) {
        this.id_dispensario = id_dispensario;
    }

    public int getNo_dispensario() {
        return no_dispensario;
    }

    public void setNo_dispensario(int no_dispensario) {
        this.no_dispensario = no_dispensario;
    }

    public String getNumero_estacion() {
        return numero_estacion;
    }

    public void setNumero_estacion(String numero_estacion) {
        this.numero_estacion = numero_estacion;
    }

    public String getMarca_dispensario() {
        return marca_dispensario;
    }

    public void setMarca_dispensario(String marca_dispensario) {
        this.marca_dispensario = marca_dispensario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getAlcanceMin() {
        return alcanceMin;
    }

    public void setAlcanceMin(String alcanceMin) {
        this.alcanceMin = alcanceMin;
    }

    public String getAprobacionDGN() {
        return aprobacionDGN;
    }

    public void setAprobacionDGN(String aprobacionDGN) {
        this.aprobacionDGN = aprobacionDGN;
    }

    public String getAlcanceMax() {
        return alcanceMax;
    }

    public void setAlcanceMax(String alcanceMax) {
        this.alcanceMax = alcanceMax;
    }

    public String getMangueraA() {
        return mangueraA;
    }

    public void setMangueraA(String mangueraA) {
        this.mangueraA = mangueraA;
    }

    public String getMangueraB() {
        return mangueraB;
    }

    public void setMangueraB(String mangueraB) {
        this.mangueraB = mangueraB;
    }

    public String getMangueraC() {
        return mangueraC;
    }

    public void setMangueraC(String mangueraC) {
        this.mangueraC = mangueraC;
    }

    public String getMangueraD() {
        return mangueraD;
    }

    public void setMangueraD(String mangueraD) {
        this.mangueraD = mangueraD;
    }

    public String getMangueraE() {
        return mangueraE;
    }

    public void setMangueraE(String mangueraE) {
        this.mangueraE = mangueraE;
    }

    public String getMangueraF() {
        return mangueraF;
    }

    public void setMangueraF(String mangueraF) {
        this.mangueraF = mangueraF;
    }

    public Date getFecha_reg_disp() {
        return fecha_reg_disp;
    }

    public void setFecha_reg_disp(Date fecha_reg_disp) {
        this.fecha_reg_disp = fecha_reg_disp;
    }
    
    @Override
    public String toString() {
        return "informacionCliente{" + "id_dispensario=" + id_dispensario + ", no_dispensario=" + no_dispensario + ", numero_estacion=" + numero_estacion + ", marca_dispensario=" + marca_dispensario + ", modelo=" + modelo + ", numSerie=" + numSerie + ", alcanceMin=" + alcanceMin + ", aprobacionDGN=" + aprobacionDGN + ", alcanceMax=" + alcanceMax + ", mangueraA=" + mangueraA + ", mangueraB=" + mangueraB + ", mangueraC=" + mangueraC + ", mangueraD=" + mangueraD + ", mangueraE=" + mangueraE + ", mangueraF=" + mangueraF + ", fecha_reg_disp=" + fecha_reg_disp + '}';
    }
    
}
