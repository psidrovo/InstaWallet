/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.InstaWallet.repository;

import ec.edu.ups.InstaWallet.modelo.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dduta
 */
@Repository
public interface ConfiguracionRepo extends JpaRepository<Configuracion, String>{
    
}
