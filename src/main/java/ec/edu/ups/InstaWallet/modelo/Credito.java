/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.Id;


/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String estadoSolicitudCredito;
    private String estado;
    private String valorCredito;
    private double interes;
    private double cuotaCredito;
    private Date fechaInicio;
    private Date fechaFinal;
    private int numeroCuotasRestantes;
    private String numeroCuenta;
    private ArrayList<DetalleCredito> detallesCredito;

    public Credito() {
    }

    public Credito(int id, String estadoSolicitudCredito, String estado, String valorCredito, double interes, double cuotaCredito, Date fechaInicio, Date fechaFinal, int numeroCuotasRestantes, String numeroCuenta, ArrayList<DetalleCredito> detallesCredito) {
        this.id = id;
        this.estadoSolicitudCredito = estadoSolicitudCredito;
        this.estado = estado;
        this.valorCredito = valorCredito;
        this.interes = interes;
        this.cuotaCredito = cuotaCredito;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.numeroCuotasRestantes = numeroCuotasRestantes;
        this.numeroCuenta = numeroCuenta;
        this.detallesCredito = detallesCredito;
    }

       
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoSolicitudCredito() {
        return estadoSolicitudCredito;
    }

    public void setEstadoSolicitudCredito(String estadoSolicitudCredito) {
        this.estadoSolicitudCredito = estadoSolicitudCredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(String valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getCuotaCredito() {
        return cuotaCredito;
    }

    public void setCuotaCredito(double cuotaCredito) {
        this.cuotaCredito = cuotaCredito;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNumeroCuotasRestantes() {
        return numeroCuotasRestantes;
    }

    public void setNumeroCuotasRestantes(int numeroCuotasRestantes) {
        this.numeroCuotasRestantes = numeroCuotasRestantes;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ArrayList<DetalleCredito> getDetallesCredito() {
        return detallesCredito;
    }

    public void setDetallesCredito(ArrayList<DetalleCredito> detallesCredito) {
        this.detallesCredito = detallesCredito;
    }
    
    public void anadirDetalleCredito(DetalleCredito detalle){
        ArrayList<DetalleCredito> detalles = this.getDetallesCredito();
        
        detalles.add(detalle);
    }

    @Override
    public String toString() {
        return "Credito{" + "id=" + id + ", estadoSolicitudCredito=" + estadoSolicitudCredito + ", estado=" + estado + ", valorCredito=" + valorCredito + ", cuotaCredito=" + cuotaCredito + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", numeroCuotasRestantes=" + numeroCuotasRestantes + ", numeroCuenta=" + numeroCuenta + ", detallesCredito=" + detallesCredito + '}';
    }
    
    
    
}
