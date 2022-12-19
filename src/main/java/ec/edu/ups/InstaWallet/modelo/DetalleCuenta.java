package ec.edu.ups.InstaWallet.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DetalleCuenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 
	 private String tipoMovimiento;
	 private Double valor;
	 private Date fecha;
	 
	 @ManyToOne
	 @JoinColumn(name = "cuentaID")
	 @JsonBackReference 
	 private Cuenta cuentaID;
	 
	 
	 

	public DetalleCuenta() {
	}
	
	

	public DetalleCuenta(int id, String tipoMovimiento, Double valor, Date fecha, Cuenta cuentaID) {
		this.id = id;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.fecha = fecha;
		this.cuentaID = cuentaID;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuentaID() {
		return cuentaID;
	}

	public void setCuentaID(Cuenta cuentaID) {
		this.cuentaID = cuentaID;
	}

	@Override
	public String toString() {
		return "DetalleCuenta [id=" + id + ", tipoMovimiento=" + tipoMovimiento + ", valor=" + valor + ", fecha="
				+ fecha + ", cuentaID=" + cuentaID + "]";
	}
	 
	 

}
