/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Configuracion;
import ec.edu.ups.InstaWallet.services.ConfiguracionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dduta
 */
@RestController
@RequestMapping("/configuracion")
@Tag(name = "Configuracion", description = "configuracion basica de un usuario")
public class ConfiguracionRestController {
    
    private ConfiguracionService configuracionService;

    public ConfiguracionRestController(ConfiguracionService configuracionService) {
        this.configuracionService = configuracionService;
    }
    
    @PostMapping("/actualizarConfigracion")
    @Operation(summary = "actualizacion de configuracion de una cuenta")
    public Configuracion actualizar(Configuracion configuracion){
        return configuracionService.actualizar(configuracion);
    }
}
