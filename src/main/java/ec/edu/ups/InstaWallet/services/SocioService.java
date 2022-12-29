package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Socio;
//import ec.edu.ups.InstaWallet.repository.CuentaRepo;
import ec.edu.ups.InstaWallet.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Pidrovo
 */
@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;
    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }
    public List<Socio> listarSocios(){
        return socioRepository.findAll(); 
    }

    public Socio findById(Socio socio){
        return socioRepository.findByIdentificacion(socio.getIdentificacionSocio());
    }
    public Socio crearSocio(Socio socio){
        return socioRepository.save(socio);
    }
    public void editarSocio(Socio socio){
        socioRepository.save(socio);
    }

}
