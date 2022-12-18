package ec.edu.ups.InstaWallet.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.repository.DetalleCuentaRepo;

@Service
public class DetalleCuentaService {
	
private DetalleCuentaRepo detalleCuentaRepo; 
	
	public DetalleCuenta save(DetalleCuenta detalleCuenta){
        return detalleCuentaRepo.save(detalleCuenta);
    }
	
	public ArrayList<DetalleCuenta> findAll(){
        return (ArrayList<DetalleCuenta>) detalleCuentaRepo.findAll();
    }

}
