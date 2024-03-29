package ec.edu.ups.InstaWallet.controller;

import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.services.SocioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/socio")
@Tag(name = "Socio", description = "Socio de la entidad bancaria")
public class SocioRestController {

   
    private SocioService socioService;

    public SocioRestController(SocioService socioService) {
        this.socioService = socioService;
    }
    @GetMapping("/")
    @Operation(summary = "Lista todos los socios disponibles")
    public List<Socio> lista(){
        return socioService.listarSocios();
    }

    @PostMapping("/")
    @Operation(summary = "Metodo de creacion de un Socio")
    public ResponseEntity<Socio> crear(@Valid @RequestBody Socio socio){
        System.out.println("Socio ingresado: " +socio.toString());
        return new ResponseEntity<>(this.socioService.crearSocio(socio), HttpStatus.CREATED);
    }
}
