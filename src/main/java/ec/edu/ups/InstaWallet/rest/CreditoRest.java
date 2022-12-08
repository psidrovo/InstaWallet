/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.rest;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class CreditoRest {
    
    @Autowired
    private CreditoService creditoService;
    
    //@CrossOrigin(origins = *)
    @PostMapping
    public boolean save(@RequestBody Credito credito){
        System.out.println(credito.toString());
        creditoService.save(credito);
        return true;
    }
    
    @GetMapping
    public List<Credito> findAll(){
        return creditoService.findAll();
    }
    
    @GetMapping
    public Credito findbyId(@RequestBody int id){
        return creditoService.getById(id);
    }
    
    @GetMapping
    public boolean existsbyId(@RequestBody int id){
        return creditoService.existsById(id);
    }
    
}
