package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.services.SocioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/socio")
public class SocioRestController {
    private SocioService socioService;

    public SocioRestController(SocioService socioService) {
        this.socioService = socioService;
    }
    @GetMapping("/")
    List<Socio> lista(){
        return socioService.listarSocios();
    }
}
