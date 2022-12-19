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
public class Usuarios implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String identificadorUsuario;

    private String nombre;
    private String correo;
    private String password;
    private String cargo;

    public Usuarios() {
    }

    public Usuarios(String identificadorUsuario, String nombre, String correo, String password, String cargo) {
        this.identificadorUsuario = identificadorUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.cargo = cargo;
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "identificadorUsuario=" + identificadorUsuario + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", cargo=" + cargo + '}';
    }
    
    

}
