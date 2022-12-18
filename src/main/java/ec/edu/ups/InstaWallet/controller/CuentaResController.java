package ec.edu.ups.InstaWallet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.repository.CuentaRepo;
import ec.edu.ups.InstaWallet.services.CuentaService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cuenta")
@Tag(name = "Cuenta", description = "Operaciones de la clase Cuenta")
public class CuentaResController {
	
	@Autowired
	private CuentaService cuentaService;

	public CuentaResController(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}
	
	@PostMapping(value = "/cuenta", produces = "application/json")
	public Cuenta guardarCurso(Cuenta cuenta){
        return this.cuentaService.create(cuenta);
    }
	
	@GetMapping( value = "/listar", produces = "application/json")
    public ArrayList<Cuenta> listarCurso() {
        return this.cuentaService.findAll();
    }
	
	
	
	
}
