/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.rest;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.DetalleCreditoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@RestController
@RequestMapping("/credito")
public class DetalleCreditoRest {
    
    @Autowired
    private DetalleCreditoService detalleCreditoService;
    
    
    @PostMapping
    public boolean save(@RequestBody DetalleCredito det){
        System.out.println(det.toString());
        detalleCreditoService.save(det);
        return true;
    }
    
    @GetMapping
    public List<DetalleCredito> findAll(){
        return detalleCreditoService.findAll();
    }
    
    @GetMapping
    public DetalleCredito findbyId(@RequestBody int id){
        return detalleCreditoService.getById(id);
    }
    
    @GetMapping
    public boolean existsbyId(@RequestBody int id){
        return detalleCreditoService.existsById(id);
    }
}
