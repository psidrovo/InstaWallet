package ec.edu.ups.InstaWallet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.services.DetalleCuentaService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/detalleCuenta")
@Tag(name = "DetalleCuenta", description = "Operaciones de la clase DetalleCuenta")
public class DetalleCuentaRestController {
	
	@Autowired
	private DetalleCuentaService detalleCuentaService;

	public DetalleCuentaRestController(DetalleCuentaService detalleCuentaService) {
		this.detalleCuentaService = detalleCuentaService;
	}
	
	@PostMapping(value = "/detalleCuenta", produces = "application/json")
	public DetalleCuenta guardarCurso(DetalleCuenta detalleCuenta){
        return this.detalleCuentaService.create(detalleCuenta);
    }
	
	@GetMapping( value = "/listar", produces = "application/json")
    public ArrayList<DetalleCuenta> listarCurso() {
        return this.detalleCuentaService.findAll();
    }
	
	

}
