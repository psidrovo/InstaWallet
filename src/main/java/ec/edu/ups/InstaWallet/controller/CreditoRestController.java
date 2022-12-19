package ec.edu.ups.InstaWallet.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.InstaWallet.services.CreditoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/credito")
@Tag(name = "Credito", description = "Operaciones de la clase Crédito")
public class CreditoRestController {
	
	private CreditoService creditoService;

	public CreditoRestController(CreditoService creditoService) {
		this.creditoService = creditoService;
	}
	
	
	
	

}
