package ec.edu.ups.InstaWallet.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.repository.CuentaRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("/cuenta")
@Tag(name = "Cuenta", description = "Operaciones de la clase Cuenta")
public class CuentaService {

	@Autowired
	private CuentaRepo cuentaRepo;

	@PostMapping("/crear")
	@Operation(summary = "Crear una Cuenta")
	public Cuenta crear(@RequestParam String numeroCuneta, @RequestParam double monto) {

		var cuen = new Cuenta();
		cuen.setEstado(true);
		cuen.setFechaCreacion(new Date());
		cuen.setNumerCuenta(numeroCuneta);
		cuen.setMonto(monto);
		cuen.setDetallesCuentas(new ArrayList<DetalleCuenta>());
		return cuentaRepo.save(cuen);

	}

	@GetMapping("/existe{id}")
	@Operation(summary = "Comprobar si existe una Cuenta")
	public boolean existsById(@RequestParam int id) {
		var cue = cuentaRepo.findById(id);

		return !cue.isEmpty();
	}

	@GetMapping("/find{id}")
	@Operation(summary = "Encontrar una Cuenta en particular")
	public Optional<Cuenta> findById(@RequestParam int id) {

		return cuentaRepo.findById(id);
	}

	@PostMapping("/actualizarEstado")
    @Operation(summary = "actualizar el estado de una Cuenta")
    public void actualizarEstado(@RequestParam Integer id, @RequestParam Boolean estado) {

        if (this.existsById(id)) {
            var cuenta = this.findById(id).get();
            cuenta.setEstado(estado);
            cuentaRepo.save(cuenta);
        }
	}
	
	@GetMapping("/listarCuentas")
	@Operation(summary = "devuelve un listado de las cuentas existentes")
	public ArrayList<Cuenta> listarCunetas (){
		return (ArrayList<Cuenta>) cuentaRepo.findAll();
	}
	
	@GetMapping("/listarAportaciones")
	@Operation(summary = "devuelve un listado de las aportaciones de la cuenta")
	public ArrayList<DetalleCuenta> listarAportaciones (@RequestParam Integer id){
		
		if (this.existsById(id)) {
            var cuenta = this.findById(id).get();
            return (ArrayList<DetalleCuenta>) cuenta.getDetallesCuentas();
        }
		
		return null;
	}
	
	
}
