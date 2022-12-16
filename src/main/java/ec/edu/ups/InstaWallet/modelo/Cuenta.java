package ec.edu.ups.InstaWallet.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cuenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String numerCuenta;
	private boolean estado;
	private double monto;
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "cuentaI")
	@JsonManagedReference
	private List<Credito> creditos;
	
	@OneToMany(mappedBy = "cuentaID")
	@JsonManagedReference
	private List<DetalleCuenta> detallesCuentas;
	
	

	public Cuenta() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumerCuenta() {
		return numerCuenta;
	}

	public void setNumerCuenta(String numerCuenta) {
		this.numerCuenta = numerCuenta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	public List<DetalleCuenta> getDetallesCuentas() {
		return detallesCuentas;
	}

	public void setDetallesCuentas(List<DetalleCuenta> detallesCuentas) {
		this.detallesCuentas = detallesCuentas;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numerCuenta=" + numerCuenta + ", estado=" + estado + ", monto=" + monto
				+ ", fechaCreacion=" + fechaCreacion + ", creditos=" + creditos + ", detallesCuentas=" + detallesCuentas
				+ "]";
	}
	
	

	
	

}
