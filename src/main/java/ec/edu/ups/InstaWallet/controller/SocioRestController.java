package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.services.SocioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/socio")
public class SocioRestController {

    @Autowired
    private SocioService socioService;

    public SocioRestController(SocioService socioService) {
        this.socioService = socioService;
    }
    @GetMapping("/")
    @Operation(summary = "Lista todos los socios disponibles")
    List<Socio> lista(){
        return socioService.listarSocios();
    }

    @PostMapping("/")
    @Operation(summary = "Crear un socio")
    Socio crear(Socio socio){
        return this.socioService.crearSocio(socio);
    }
}
