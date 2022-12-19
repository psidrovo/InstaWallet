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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
public class DetalleCredito implements Serializable{
    
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
	
    @ManyToOne
    @JoinColumn(name = "creditoID")
    @JsonBackReference 
    private Credito creditoID;

    public DetalleCredito() {
    }

    public DetalleCredito(int id, Date fechaPago, double valorPago, String estado, Credito creditoID) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
        this.estado = estado;
        this.creditoID = creditoID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

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

    public Credito getCreditoID() {
        return creditoID;
    }

    public void setCreditoID(Credito creditoID) {
        this.creditoID = creditoID;
    }

    @Override
    public String toString() {
        return "DetalleCredito{" + "id=" + id + ", fechaPago=" + fechaPago + ", valorPago=" + valorPago + ", creditoID=" + creditoID + '}';
    }

    


}
