/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Usuarios;
import ec.edu.ups.InstaWallet.repository.UsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dduta
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    
    /**\
     * 
     * @param usuario
     * @return 
     */
    public Usuarios guardar(Usuarios usuario){
        return usuarioRepo.save(usuario);
    }
    
    public Optional<Usuarios> findById(String id){
        return usuarioRepo.findById(id);
    }
    
    public List<Usuarios> findAll(){
        return usuarioRepo.findAll();
    }
    
    public boolean verifyExistence(String id){
        var cue = usuarioRepo.findById(id);
        
        return cue!=null;
    }
    
    
}
