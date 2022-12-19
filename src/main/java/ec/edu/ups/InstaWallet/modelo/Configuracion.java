/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author dduta
 */
@Entity
public class Configuracion implements Serializable {
    
    @Id
    private String nombreEmpresa;
    private String logo;
    private String correoEmpresa;

    public Configuracion() {
    }

    public Configuracion(String nombreEmpresa, String logo, String correoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.logo = logo;
        this.correoEmpresa = correoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "nombreEmpresa=" + nombreEmpresa + ", logo=" + logo + ", correoEmpresa=" + correoEmpresa + '}';
    }
    
}
