/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
@Table(name="credito")
public class Credito{
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_credito",unique = true)
    private Integer id;
	@Column(name = "estado_solicitud_credito", length = 255)
    private String estadoSolicitudCredito;
	@Column(name = "estado", length = 255)
    private String estado;
	@Column(name = "valor_credito", length = 255)
    private double valorCredito;
	@Column(name = "interes", length = 255)
    private double interes;
	@Column(name = "cuota_credito", length = 255)
    private double cuotaCredito;
	@Column(name = "numero_de_cuotas", length = 255)
    private int numeroDeCuotas;
	@Column(name = "fecha_inicio", length = 255)
    private Date fechaInicio;
	@Column(name = "fecha_final", length = 255)
    private Date fechaFinal;
	@Column(name = "numero_cuotas_restantes", length = 255)
    private int numeroCuotasRestantes;

    @OneToMany
    @JoinColumn(name="id_credito")
    private List<DetalleCredito> detalleCreditoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCuotaCredito() {
        return cuotaCredito;
    }

    public void setCuotaCredito(double cuotaCredito) {
        this.cuotaCredito = cuotaCredito;
    }

    public int getNumeroDeCuotas() {
        return numeroDeCuotas;
    }

    public void setNumeroDeCuotas(int numeroDeCuotas) {
        this.numeroDeCuotas = numeroDeCuotas;
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

    public List<DetalleCredito> getDetalleCreditoList() {
        return detalleCreditoList;
    }

    public void setDetalleCreditoList(List<DetalleCredito> detalleCreditoList) {
        this.detalleCreditoList = detalleCreditoList;
    }

    @Override
    public String toString() {
        return "Credito{" +
                "id=" + id +
                ", estadoSolicitudCredito='" + estadoSolicitudCredito + '\'' +
                ", estado='" + estado + '\'' +
                ", valorCredito=" + valorCredito +
                ", interes=" + interes +
                ", cuotaCredito=" + cuotaCredito +
                ", numeroDeCuotas=" + numeroDeCuotas +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", numeroCuotasRestantes=" + numeroCuotasRestantes +
                ", detalleCreditoList=" + detalleCreditoList +
                '}';
    }
}
