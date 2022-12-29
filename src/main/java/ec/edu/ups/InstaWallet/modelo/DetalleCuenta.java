package ec.edu.ups.InstaWallet.modelo;

//import java.time.LocalDate;
import java.util.Date;

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
	private Date fecha;
	@Column(name = "id_cuenta", length = 255)
	private String cuentaCodigo;


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



	public void setId(Integer id) {
		this.id = id;
	}

	public void setCuentaCodigo(String cuentaCodigo) {
		this.cuentaCodigo = cuentaCodigo;
	}
	public String getCuentaCodigo() {
		return cuentaCodigo;
	}

	@Override
	public String toString() {
		return "DetalleCuenta{" +
				"id=" + id +
				", tipoMovimiento='" + tipoMovimiento + '\'' +
				", valor=" + valor +
				", fecha=" + fecha +
				", cuentaCodigo='" + cuentaCodigo + '\'' +
				'}';
	}
}
