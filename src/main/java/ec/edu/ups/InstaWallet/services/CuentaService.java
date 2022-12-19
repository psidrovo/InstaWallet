package ec.edu.ups.InstaWallet.services;

import java.util.List;
import java.util.Optional;

import ec.edu.ups.InstaWallet.repository.DetalleCuentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.ups.InstaWallet.modelo.Cuenta;
import ec.edu.ups.InstaWallet.repository.CuentaRepo;




@Service
public class CuentaService {

	@Autowired
	private CuentaRepo cuentaRepo;
	@Autowired
	private DetalleCuentaRepo detalleCuentaRepo;

	public CuentaService(CuentaRepo cuentaRepo, DetalleCuentaRepo detalleCuentaRepo) {
		this.cuentaRepo = cuentaRepo;
		this.detalleCuentaRepo = detalleCuentaRepo;
	}

	public Cuenta save(Cuenta cuenta){
		return cuentaRepo.save(cuenta);
    }
	
	
	public Optional<Cuenta> findById(int id) {

		return cuentaRepo.findById(id);
	}
	
	
	public List<Cuenta> findAll(){
        return cuentaRepo.findAll();
    }
	
	public boolean existsById(int id) {
		var cue = cuentaRepo.findById(id);

		return !cue.isEmpty();
	}
	
	
}
