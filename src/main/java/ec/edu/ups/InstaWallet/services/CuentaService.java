package ec.edu.ups.InstaWallet.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;



import ec.edu.ups.InstaWallet.modelo.Cuenta;

import ec.edu.ups.InstaWallet.repository.CuentaRepo;




@Service
public class CuentaService {

	private CuentaRepo cuentaRepo;
	
	public Cuenta create(Cuenta cuenta){
        return cuentaRepo.save(cuenta);
    }
	
	public ArrayList<Cuenta> findAll(){
        return (ArrayList<Cuenta>) cuentaRepo.findAll();
    }

	

	/*@GetMapping("/existe{id}")
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
	
	
	@GetMapping("/listarAportaciones")
	@Operation(summary = "devuelve un listado de las aportaciones de la cuenta")
	public ArrayList<DetalleCuenta> listarAportaciones (@RequestParam Integer id){
		
		if (this.existsById(id)) {
            var cuenta = this.findById(id).get();
            return (ArrayList<DetalleCuenta>) cuenta.getDetallesCuentas();
        }
		
		return null;
	}*/
	
	
}
