/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import ec.edu.ups.InstaWallet.repository.DetalleCreditoRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/detalle-credito")
@Tag(name = "DetalleCredito", description = "Operaciones de la clase DetalleCredito")
public class DetalleCreditoService {

    @Autowired
    private DetalleCreditoRepo detalleCreditoRepo;

    @Autowired
    private CreditoRepo creditoRepo;

    private DetalleCredito detalleCredito;

    @GetMapping("/all")
    @Operation(summary = "Encuentra todos los detalles de los créditos existentes")
    public List<DetalleCredito> findAll() {
        return detalleCreditoRepo.findAll();
    }

    @PostMapping("/save")
    @Operation(summary = "Crear un detalle correspondiente a un crédito")
    public DetalleCredito save(@RequestParam double valorPago, @RequestParam int creditoId) {

        var credito = creditoRepo.findById(creditoId).get();

        if (credito != null) {
            credito.setNumeroCuotasRestantes(credito.getNumeroCuotasRestantes() - 1);
            creditoRepo.save(credito);
            var det = new DetalleCredito(0, new Date(), valorPago, "Pagado", credito);

            return detalleCreditoRepo.save(det);
        }
        return null;
    }

    @GetMapping("/existe{id}")
    @Operation(summary = "Comprobar que existe un detalle credito en particular")
    public boolean existsById(@RequestBody int id) {
        var cre = detalleCreditoRepo.findById(id);

        return !cre.isEmpty();
    }

    @GetMapping("/find{id}")
    @Operation(summary = "Buscar un crédito en particular")
    public DetalleCredito findById(@RequestBody int id) {
        detalleCredito = detalleCreditoRepo.findById(id).get();

        return detalleCredito;
    }

}
