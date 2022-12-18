package ec.edu.ups.InstaWallet.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.ups.InstaWallet.modelo.Cuenta;

import ec.edu.ups.InstaWallet.repository.CuentaRepo;




@Service
public class CuentaService {

	private CuentaRepo cuentaRepo;
	
	public Cuenta save(Cuenta cuenta){
        return cuentaRepo.save(cuenta);
    }
	
	
	public Optional<Cuenta> findById(int id) {

		return cuentaRepo.findById(id);
	}
	
	
	public ArrayList<Cuenta> findAll(){
        return (ArrayList<Cuenta>) cuentaRepo.findAll();
    }
	
	public boolean existsById(int id) {
		var cue = cuentaRepo.findById(id);

		return !cue.isEmpty();
	}
	
	
}
