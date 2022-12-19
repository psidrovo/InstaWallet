package ec.edu.ups.InstaWallet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.services.CuentaService;
import io.swagger.v3.oas.annotations.Operation;
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
	
	@PostMapping(value = "/cuenta")
	public Cuenta crearCuenta(Cuenta cuenta){
        return this.cuentaService.save(cuenta);
    }
	
	@GetMapping( value = "/listarCuentas")
    public List<Cuenta> listarCuentas() {
        return this.cuentaService.findAll();
    }
	
	@PostMapping("/actualizarEstado")
    @Operation(summary = "actualizar el estado de una Cuenta")
    public void actualizarEstado(@RequestParam Integer id, @RequestParam Boolean estado) {

        if (this.cuentaService.existsById(id)) {
            var cuenta = this.cuentaService.findById(id).get();
            cuenta.setEstado(estado);
            this.cuentaService.save(cuenta);
        }
	}
	
	@GetMapping("/listarAportaciones")
	@Operation(summary = "devuelve un listado de las aportaciones de la cuenta")
	public ArrayList<DetalleCuenta> listarAportaciones (@RequestParam Integer id){
		
		if (this.cuentaService.existsById(id)) {
            var cuenta = this.cuentaService.findById(id).get();
            return (ArrayList<DetalleCuenta>) cuenta.getDetallesCuentas();
        }
		
		return null;
	}
	
	
}
