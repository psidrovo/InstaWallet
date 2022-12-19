package ec.edu.ups.InstaWallet.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import io.swagger.v3.oas.annotations.Operation;

public class DetalleCreditoRestController {
	
	private DetalleCreditoService detalleCreditoService;
	private CreditoService creditoService;

	public DetalleCreditoRestController(DetalleCreditoService detalleCreditoService) {
		this.detalleCreditoService = detalleCreditoService;
	}

	@PostMapping("/")
	@Operation(summary = "Crear un detalle credito")
	public DetalleCredito crearDetalleCredito(@Valid @RequestBody DetalleCredito detalleCredito, @RequestParam int creditoId){
		var credito = creditoService.findById(creditoId).get();
		if (credito != null) {
            credito.setNumeroCuotasRestantes(credito.getNumeroCuotasRestantes() - 1);
            creditoService.save(credito);

            return detalleCreditoService.save(detalleCredito);
        }
        return null;
		
    }
	
	@GetMapping("/all")
	@Operation(summary = "Encuentra todos los detalles de los créditos existentes")
    public List<DetalleCredito> listarDetallesCuentas() {
        return this.detalleCreditoService.findAll();
    }
	
	
	
	
	
	
	

}
