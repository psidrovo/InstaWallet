/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.DetalleCreditoRepo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/detalle-credito")
public class DetalleCreditoService {
    
    @Autowired
    private DetalleCreditoRepo detalleCreditoRepo;

    private DetalleCredito detalleCredito;
    
    @GetMapping("/all")
    public List<DetalleCredito> findAll(){
        return detalleCreditoRepo.findAll();
    }

    @PostMapping("/save")
    public DetalleCredito save(@RequestBody DetalleCredito detalleCredito){
        return detalleCreditoRepo.save(detalleCredito);
    }

    @GetMapping("/existe{id}")
    public boolean existsById(@RequestBody int id){
        var cre = detalleCreditoRepo.findById(id);

        return !cre.isEmpty();
    }


    @GetMapping("/find{id}")
    public DetalleCredito findById(@RequestBody int id){
        detalleCredito = detalleCreditoRepo.getReferenceById(id);
        
        return detalleCredito;
    }
    
    
    
    
}
