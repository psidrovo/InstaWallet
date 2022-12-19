/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Usuarios;
import ec.edu.ups.InstaWallet.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dduta
 */
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Operaciones basicas de usuarios")
public class UsuarioRestConroller {
    
    @Autowired
    private UsuarioService usuariosService;

    public UsuarioRestConroller(UsuarioService usuariosService) {
        this.usuariosService = usuariosService;
    }
    
    @PostMapping("/ListUsuarios")
    @Operation(summary = "Lista todos los usuarios disponibles")
    List<Usuarios> findAll(){
        return usuariosService.findAll();
    }
    
    @PostMapping("/createUsuario")
    @Operation(summary = "Metodo de creacion de usuario")
    Usuarios createUsuario(Usuarios usuario){
        return this.usuariosService.guardar(usuario);
    }
    
    @PostMapping("/findById")
    @Operation(summary = "Metodo de creacion de usuario")
    Optional findUsuario(String id){
        return usuariosService.findById(id);
    }
}
