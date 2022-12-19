package ec.edu.ups.InstaWallet.services;

import java.util.List;
import java.util.Optional;

import ec.edu.ups.InstaWallet.modelo.Socio;
import ec.edu.ups.InstaWallet.repository.DetalleCuentaRepo;
import ec.edu.ups.InstaWallet.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.repository.CuentaRepo;




@Service
public class CuentaService {

	@Autowired
	private CuentaRepo cuentaRepo;
	private DetalleCuentaRepo detalleCuentaRepo;
	private SocioRepository socioRepository;

	public CuentaService(CuentaRepo cuentaRepo, DetalleCuentaRepo detalleCuentaRepo, SocioRepository socioRepository) {
		this.cuentaRepo = cuentaRepo;
		this.detalleCuentaRepo = detalleCuentaRepo;
		this.socioRepository=socioRepository;
	}

	public Cuenta save(Cuenta cuenta){
		return cuentaRepo.save(cuenta);
    }

	
	public List<Cuenta> findAll(){
        return cuentaRepo.findAll();
    }
	
	public boolean existsById(int id) {
		var cue = cuentaRepo.findById(id);

		return !cue.isEmpty();
	}
	
	
}
