package ec.edu.ups.InstaWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.InstaWallet.modelo.Cuenta;



@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer> {
    Cuenta findByNumerCuenta(String numerCuenta);

}
