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
 * Modelo de la tabla Clientes 10/08/2021
 */
public class informacionCliente {
   private String idEstacion;
   private Date fecha_registro;
   private String nombre_responsable;
   private String razon_social;
   private String registro_fedcausante;
   private String domicilio;
   private String colonia;
   private String ciudad;
   private String estado;
   private String telefono;
   private String correo_electronico;
   private String coordenadasUTM;
   private String codigo_postal;
   private String numero_cre;
   private String marca_gasolina;
   private int mangueraMagna;
   private int mangueraPremium;
   private int mangueraDiesel;
   private String estatus_maguera;

    public informacionCliente() {
    }

    public informacionCliente(String idEstacion, Date fecha_registro, String nombre_responsable, String razon_social, String registro_fedcausante, String domicilio, String colonia, String ciudad, String estado, String telefono, String correo_electronico, String coordenadasUTM, String codigo_postal, String numero_cre, String marca_gasolina, int mangueraMagna, int mangueraPremium, int mangueraDiesel, String estatus_maguera) {
        this.idEstacion = idEstacion;
        this.fecha_registro = fecha_registro;
        this.nombre_responsable = nombre_responsable;
        this.razon_social = razon_social;
        this.registro_fedcausante = registro_fedcausante;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.coordenadasUTM = coordenadasUTM;
        this.codigo_postal = codigo_postal;
        this.numero_cre = numero_cre;
        this.marca_gasolina = marca_gasolina;
        this.mangueraMagna = mangueraMagna;
        this.mangueraPremium = mangueraPremium;
        this.mangueraDiesel = mangueraDiesel;
        this.estatus_maguera = estatus_maguera;
    }
    
    public String getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(String idEstacion) {
        this.idEstacion = idEstacion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNombre_responsable() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRegistro_fedcausante() {
        return registro_fedcausante;
    }

    public void setRegistro_fedcausante(String registro_fedcausante) {
        this.registro_fedcausante = registro_fedcausante;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getCoordenadasUTM() {
        return coordenadasUTM;
    }

    public void setCoordenadasUTM(String coordenadasUTM) {
        this.coordenadasUTM = coordenadasUTM;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getNumero_cre() {
        return numero_cre;
    }

    public void setNumero_cre(String numero_cre) {
        this.numero_cre = numero_cre;
    }

    public String getMarca_gasolina() {
        return marca_gasolina;
    }

    public void setMarca_gasolina(String marca_gasolina) {
        this.marca_gasolina = marca_gasolina;
    }

    public int getMangueraMagna() {
        return mangueraMagna;
    }

    public void setMangueraMagna(int mangueraMagna) {
        this.mangueraMagna = mangueraMagna;
    }

    public int getMangueraPremium() {
        return mangueraPremium;
    }

    public void setMangueraPremium(int mangueraPremium) {
        this.mangueraPremium = mangueraPremium;
    }

    public int getMangueraDiesel() {
        return mangueraDiesel;
    }

    public void setMangueraDiesel(int mangueraDiesel) {
        this.mangueraDiesel = mangueraDiesel;
    }

    public String getEstatus_maguera() {
        return estatus_maguera;
    }

    public void setEstatus_maguera(String estatus_maguera) {
        this.estatus_maguera = estatus_maguera;
    }

    @Override
    public String toString() {
        return "informacionClientes{" + "idEstacion=" + idEstacion + ", fecha_registro=" + fecha_registro + ", nombre_responsable=" + nombre_responsable + ", razon_social=" + razon_social + ", registro_fedcausante=" + registro_fedcausante + ", domicilio=" + domicilio + ", colonia=" + colonia + ", ciudad=" + ciudad + ", estado=" + estado + ", telefono=" + telefono + ", correo_electronico=" + correo_electronico + ", coordenadasUTM=" + coordenadasUTM + ", codigo_postal=" + codigo_postal + ", numero_cre=" + numero_cre + ", marca_gasolina=" + marca_gasolina + ", mangueraMagna=" + mangueraMagna + ", mangueraPremium=" + mangueraPremium + ", mangueraDiesel=" + mangueraDiesel + ", estatus_maguera=" + estatus_maguera + '}';
    }
   
   
   
}
