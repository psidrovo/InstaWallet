/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Configuracion;
import ec.edu.ups.InstaWallet.repository.ConfiguracionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dduta
 */
@Service
public class ConfiguracionService {
    
    @Autowired
    private ConfiguracionRepo configuracionRepo;

    public ConfiguracionService(ConfiguracionRepo configuracionRepo) {
        this.configuracionRepo = configuracionRepo;
    }
    
    public Configuracion actualizar (Configuracion configuracion){
        return configuracionRepo.save(configuracion);
    }
        
        
}
