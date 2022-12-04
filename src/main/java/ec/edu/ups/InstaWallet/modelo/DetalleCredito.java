/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@Entity
public class DetalleCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fechaPago;
    private double valorPago;
    private Credito creditoID;

    public DetalleCredito() {
    }

    public DetalleCredito(int id, Date fechaPago, double valorPago, Credito creditoID) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
        this.creditoID = creditoID;
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
