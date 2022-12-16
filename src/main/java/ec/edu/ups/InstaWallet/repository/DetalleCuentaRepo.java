package ec.edu.ups.InstaWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.InstaWallet.modelo.DetalleCuenta;

@Repository
public interface DetalleCuentaRepo extends JpaRepository<DetalleCuenta, Integer>{

}
