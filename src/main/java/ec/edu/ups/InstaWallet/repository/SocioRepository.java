package ec.edu.ups.InstaWallet.repository;

import ec.edu.ups.InstaWallet.modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Pidrovo
 */
@Repository
public interface SocioRepository extends JpaRepository<Socio,String> {
}
