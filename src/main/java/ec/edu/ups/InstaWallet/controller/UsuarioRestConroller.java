/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Usuario;
import ec.edu.ups.InstaWallet.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author dduta
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Usuario", description = "Operaciones basicas de usuarios")
public class UsuarioRestConroller {

    private UsuarioService usuariosService;

    public UsuarioRestConroller(UsuarioService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/ListUsuarios")
    @Operation(summary = "Lista todos los usuarios disponibles")
    public List<Usuario> findAll(){
        return usuariosService.findAll();
    }

    @PostMapping("/createUsuario")
    @Operation(summary = "Metodo de creacion de usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return this.usuariosService.guardar(usuario);
    }

    @PostMapping("/findById/{id}")
    @Operation(summary = "Metodo de creacion de usuario")
    public Usuario findUsuario(@PathVariable ("id") String id){
        return usuariosService.findById(id);
    }
}
