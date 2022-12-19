package ec.edu.ups.InstaWallet.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="cuenta")
public class Cuenta {
	
	@Id
	@Column(name = "numero_cuenta", unique = true)
	private String numerCuenta;
	@Column(name = "estado", length = 255)
	private boolean estado;
	@Column(name = "monto", length = 255)
	private double monto;
	@Column(name = "fecha_creacion", length = 255)
	private LocalDate fechaCreacion;
	@Column(name = "id_socio", length = 255)
	private String socioIdentificacion;
	@OneToMany
	@JoinColumn(name="id_cuenta")
	private List<Credito> creditos;

	@OneToMany
	@JoinColumn(name="id_cuenta")
	private List<DetalleCuenta> detallesCuentas;


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

	public void setSocioIdentificacion(String socioIdentificacion) {
		this.socioIdentificacion = socioIdentificacion;
	}

	public String getSocioIdentificacion() {
		return socioIdentificacion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
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
		return "Cuenta{" +
				"numerCuenta='" + numerCuenta + '\'' +
				", estado=" + estado +
				", monto=" + monto +
				", fechaCreacion=" + fechaCreacion +
				", creditos=" + creditos +
				", detallesCuentas=" + detallesCuentas +
				'}';
	}
}
