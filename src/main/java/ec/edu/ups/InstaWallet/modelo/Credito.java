/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
public class Credito{
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",unique = true)
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
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cunetaI", nullable=false,referencedColumnName = "id")
	private Cuenta cuentaI;
    
    
    @OneToMany(mappedBy = "creditoID")
    @JsonManagedReference
    private List<DetalleCredito> detallesCredito;

    public Credito() {
    }

    /*public Credito(Integer id, String estadoSolicitudCredito, String estado, double valorCredito, double interes, double cuotaCredito, int numeroDeCuotas, Date fechaInicio, Date fechaFinal, int numeroCuotasRestantes, String numeroCuenta, List<DetalleCredito> detallesCredito) {
        this.id = id;
        this.estadoSolicitudCredito = estadoSolicitudCredito;
        this.estado = estado;
        this.valorCredito = valorCredito;
        this.interes = interes;
        this.cuotaCredito = cuotaCredito;
        this.numeroDeCuotas = numeroDeCuotas;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.numeroCuotasRestantes = numeroCuotasRestantes;
        //this.numeroCuenta = numeroCuenta;
        this.detallesCredito = detallesCredito;
    }*/

    public Credito(double valorCredito, int numeroDeCuotas) {
        this.valorCredito = valorCredito;
        this.numeroDeCuotas = numeroDeCuotas;
    }
    
    
    
    

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getNumeroDeCuotas() {
        return numeroDeCuotas;
    }

    public void setNumeroDeCuotas(int numeroDeCuotas) {
        this.numeroDeCuotas = numeroDeCuotas;
    }

    public Integer getId() {
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

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
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


    public List<DetalleCredito> getDetallesCredito() {
        return detallesCredito;
    }

    public void setDetallesCredito(List<DetalleCredito> detallesCredito) {
        this.detallesCredito = detallesCredito;
    }
    
    public void anadirDetalleCredito(DetalleCredito detalle){
        List<DetalleCredito> detalles = this.getDetallesCredito();
        
        detalles.add(detalle);
    }

    @Override
    public String toString() {
        return "Credito{" + "id=" + id + ", estadoSolicitudCredito=" + estadoSolicitudCredito + 
                ", estado=" + estado + ", valorCredito=" + valorCredito + ", cuotaCredito=" + 
                cuotaCredito + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + 
                ", numeroCuotasRestantes=" + numeroCuotasRestantes +
                ", detallesCredito=" + detallesCredito + '}';
    }
    
    
    
}
