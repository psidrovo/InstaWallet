/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Usuario;
import ec.edu.ups.InstaWallet.repository.UsuarioRepo;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;
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

    public Usuario guardar(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    
    public Usuario findById(String id){
        return usuarioRepo.findById(id).get();
    }
    
    public List<Usuario> findAll(){
        return usuarioRepo.findAll();
    }
    
    public boolean verifyExistence(String id){
        Optional<Usuario> cue = usuarioRepo.findById(id);
        
        return cue!=null;
    }
    
    
}
