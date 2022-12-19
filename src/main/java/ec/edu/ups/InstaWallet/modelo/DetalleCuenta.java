package ec.edu.ups.InstaWallet.modelo;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="detalle_cuenta")
public class DetalleCuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",unique = true)
	private Integer id;
	@Column(name = "tipo_movimiento", length = 255)
	private String tipoMovimiento;
	@Column(name = "valor", length = 255)
	private Double valor;
	@Column(name = "fecha", length = 255)
	private LocalDate fecha;

	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "cunetaID", nullable = false, referencedColumnName = "numero_cuenta")
	private Cuenta cuenta;


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

	

	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "DetalleCuenta{" +
				"id=" + id +
				", tipoMovimiento='" + tipoMovimiento + '\'' +
				", valor=" + valor +
				", fecha=" + fecha +
				", cuenta=" + cuenta +
				'}';
	}
}
