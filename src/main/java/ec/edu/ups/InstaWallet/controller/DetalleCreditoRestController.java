package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Credito;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracion")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleCreditoRestController {

    private DetalleCreditoService detalleCreditoService;
    private CreditoService creditoService;

    public DetalleCreditoRestController(DetalleCreditoService detalleCreditoService, CreditoService creditoService) {
        this.detalleCreditoService = detalleCreditoService;
        this.creditoService = creditoService;
    }

    @PostMapping("/")
    @Operation(summary = "Crear un detalle credito")
    public DetalleCredito crearDetalleCredito(@Valid @RequestBody DetalleCredito detalleCredito, @RequestParam int creditoId) {
        Credito credito = creditoService.findById(creditoId).get();
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
