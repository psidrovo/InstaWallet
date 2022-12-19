/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
public class DetalleCredito {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",unique = true)
    private int id;
	@Column(name = "fecha_Pago", length = 255)
    private Date fechaPago;
	@Column(name = "valor_pagado", length = 255)
    private double valorPago;
	@Column(name = "estado", length = 255)
    private String estado;
    @Column(name = "id_credito", length = 255)
    private String creditoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(String creditoId) {
        this.creditoId = creditoId;
    }

    @Override
    public String toString() {
        return "DetalleCredito{" +
                "id=" + id +
                ", fechaPago=" + fechaPago +
                ", valorPago=" + valorPago +
                ", estado='" + estado + '\'' +
                ", creditoId='" + creditoId + '\'' +
                '}';
    }
}
