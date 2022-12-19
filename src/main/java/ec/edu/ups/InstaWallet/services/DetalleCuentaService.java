package ec.edu.ups.InstaWallet.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;
import ec.edu.ups.InstaWallet.repository.DetalleCuentaRepo;

@Service
public class DetalleCuentaService {
	
	@Autowired
	private DetalleCuentaRepo detalleCuentaRepo; 
	
	public DetalleCuenta save(DetalleCuenta detalleCuenta){
        return detalleCuentaRepo.save(detalleCuenta);
    }
	
	public List<DetalleCuenta> findAll(){
        return  detalleCuentaRepo.findAll();
    }

}
