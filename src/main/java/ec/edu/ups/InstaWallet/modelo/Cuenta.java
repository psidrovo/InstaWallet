package ec.edu.ups.InstaWallet.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="cuenta")
public class Cuenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",unique = true)
    private Integer id;
	
	@Column(name = "numero_cuenta", length = 255)
	private String numerCuenta;
	@Column(name = "estado", length = 255)
	private boolean estado;
	@Column(name = "monto", length = 255)
	private double monto;
	@Column(name = "fecha_creacion", length = 255)
	private LocalDate fechaCreacion;
	
	//@OneToMany(mappedBy = "cuentaI")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Credito> creditos;
	
	//@OneToMany(mappedBy = "cuentaID")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<DetalleCuenta> detallesCuentas;

	@ManyToOne(cascade = CascadeType.ALL,optional = false)
	@JoinColumn(name="socio_id", nullable=false,referencedColumnName = "identificacion_socio")
	private Socio socio;

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

	

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	/*public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}*/

	public List<DetalleCuenta> getDetallesCuentas() {
		return detallesCuentas;
	}

	/*public void setDetallesCuentas(List<DetalleCuenta> detallesCuentas) {
		this.detallesCuentas = detallesCuentas;
	}*/
	
	

	/*public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}*/

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numerCuenta=" + numerCuenta + ", estado=" + estado + ", monto=" + monto
				+ ", fechaCreacion=" + fechaCreacion + ", socio=" + socio + ", creditos=" + creditos
				+ ", detallesCuentas=" + detallesCuentas + "]";
	}

	
	

	
	

}
