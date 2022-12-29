package ec.edu.ups.InstaWallet.controller;

//import java.util.ArrayList;
import java.util.List;

//import ec.edu.ups.InstaWallet.services.SocioService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
//import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.services.CuentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping("/cuenta")
@Tag(name = "Cuenta", description = "Operaciones de la clase Cuenta")
public class CuentaResController {

	private CuentaService cuentaService;

	public CuentaResController(CuentaService cuentaService) {
		this.cuentaService = cuentaService;
	}


	@PostMapping("/")
	@Operation(summary = "Crear una cuenta")
	ResponseEntity<Cuenta> crearCuenta(@Valid @RequestBody Cuenta cuenta){
		System.out.println("Cuenta recibida: " + cuenta);
		return new ResponseEntity<>(this.cuentaService.save(cuenta), HttpStatus.CREATED);
    }
	
	@GetMapping("/listarCuentas")
	@Operation(summary = "Listar todas las Cuentas")
    public List<Cuenta> listarCuentas() {
        return this.cuentaService.findAll();
    }

	@PostMapping("/actualizarEstado")
	@Operation(summary = "Actualizar el estado de una Cuenta")
    public void actualizarEstado(@RequestParam String id, @RequestParam Boolean estado) {
            Cuenta cuenta = this.cuentaService.findByNumerCuenta(id);
            if(cuenta!=null) {
				cuenta.setEstado(estado);
				this.cuentaService.save(cuenta);
			}
	}
	/*
	@GetMapping(value = "/listarAportaciones", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "devuelve un listado de las aportaciones de la cuenta")
	public ArrayList<DetalleCuenta> listarAportaciones (@RequestParam Integer id){
		
		if (this.cuentaService.existsById(id)) {
            var cuenta = this.cuentaService.findById(id).get();
            return (ArrayList<DetalleCuenta>) cuenta.getDetallesCuentas();
        }
		
		return null;
	}*/
	
	
}
