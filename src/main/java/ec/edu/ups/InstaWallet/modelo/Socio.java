package ec.edu.ups.InstaWallet.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Pidrovo
 */
@Entity
@Table(name="socio")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "identificacion_socio",unique = true)
    String identificacionSocio;
    @Column(name = "nombre_socio", length = 255)
    String nombreSocio;
    @Column(name = "correo_socio", length = 255)
    String correoSocio;
    @Column(name = "telefono_socio", length = 255)
    String telefonoSocio;


    @OneToMany(mappedBy = "socio")
    @JsonManagedReference
    private List<Cuenta> payments;


    public String getIdentificacionSocio() {
        return identificacionSocio;
    }

    public void setIdentificacionSocio(String identificacionSocio) {
        this.identificacionSocio = identificacionSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getCorreoSocio() {
        return correoSocio;
    }

    public void setCorreoSocio(String correoSocio) {
        this.correoSocio = correoSocio;
    }

    public String getTelefonoSocio() {
        return telefonoSocio;
    }

    public void setTelefonoSocio(String telefonoSocio) {
        this.telefonoSocio = telefonoSocio;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "identificacionSocio='" + identificacionSocio + '\'' +
                ", nombreSocio='" + nombreSocio + '\'' +
                ", correoSocio='" + correoSocio + '\'' +
                ", telefonoSocio='" + telefonoSocio + '\'' +
                '}';
    }
}
