package ec.edu.ups.InstaWallet.repository;

import ec.edu.ups.InstaWallet.modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Pidrovo
 */
@Repository
public interface SocioRepository extends JpaRepository<Socio,Long> {
    @Query("select s from Socio s where s.identificacionSocio = ?1")
    Socio findByIdentificacion(String identificacionSocio);
}
