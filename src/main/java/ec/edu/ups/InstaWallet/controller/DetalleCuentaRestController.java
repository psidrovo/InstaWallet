package ec.edu.ups.InstaWallet.controller;


import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.services.DetalleCuentaService;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequestMapping("/detalleCuenta")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "DetalleCuenta", description = "Operaciones de la clase DetalleCuenta")
public class DetalleCuentaRestController {
	
	//@Autowired
	private DetalleCuentaService detalleCuentaService;

	public DetalleCuentaRestController(DetalleCuentaService detalleCuentaService) {
		this.detalleCuentaService = detalleCuentaService;
	}
	
	@PostMapping("/detalleCuenta")
	@Operation(summary = "Metodo de creacion de Movimientos")
	public ResponseEntity <DetalleCuenta> agregarMovimiento(@Valid @RequestBody DetalleCuenta detalleCuenta){
		System.out.println("Detalle recibido: "+detalleCuenta);
		return new ResponseEntity<>(this.detalleCuentaService.save(detalleCuenta), HttpStatus.CREATED);
    }
	
	@GetMapping("/listar")
	@Operation(summary = "Listar todas los detalles de cuentas")
    public List<DetalleCuenta> listarAportaciones() {
        return this.detalleCuentaService.findAll();
    }
	
	

}
