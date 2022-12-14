/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.DetalleCreditoRepo;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public DetalleCreditoService(DetalleCreditoRepo detalleCreditoRepo) {
        this.detalleCreditoRepo = detalleCreditoRepo;
    }

    public DetalleCredito save(DetalleCredito detalleCredito) {
        return detalleCreditoRepo.save(detalleCredito);
    }

    public boolean existsById(int id) {
        Optional<DetalleCredito> cre = detalleCreditoRepo.findById(id);

        return cre.isPresent();
    }

    public Optional<DetalleCredito> findById(int id) {
        return detalleCreditoRepo.findById(id);
    }

    public List<DetalleCredito> findAll() {
        return detalleCreditoRepo.findAll();
    }

}
