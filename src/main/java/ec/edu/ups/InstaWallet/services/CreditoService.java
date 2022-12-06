/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@Service
public class CreditoService implements CreditoRepo {

    @Autowired
    private CreditoRepo creditoRepo;

    private Credito credito;

    public void aprobarRechazarCredito(Integer id, String aprobarRechazar) {

        if (this.existsById(id)) {
            credito = this.getById(id);

            credito.setEstadoSolicitudCredito(aprobarRechazar);

            if (aprobarRechazar.startsWith("A")) {
                this.actualizarEstadoCredito("Activo");
            } else {
                this.actualizarEstadoCredito("Desactivo");
            }

            this.save(credito);
        }
    }

    public void actualizarEstadoCredito(String estado) {
        credito.setEstado(estado);
    }

    public ArrayList<DetalleCredito> generarTablaAmortizacion(int numeroDeCuotas, Date fechaInicio,
            double valorCredito) {

        double pagoMensual = valorCredito / numeroDeCuotas;
        double interes = calculoInteres(valorCredito);
        double calucloPago = pagoMensual * interes;
        double total = pagoMensual + calucloPago;
        double pago = Math.round(total);

        ArrayList<DetalleCredito> listaPagos = new ArrayList<>();
        DetalleCredito det;

        for (Integer i = 1; i <= numeroDeCuotas; i++) {
            det = new DetalleCredito();
            det.setId(i);
            det.setFechaPago(generarFechaPago(i));
            det.setValorPago(pago);
            
            listaPagos.add(det);

        }

        return listaPagos;
    }

    public double calculoInteres(double monto) {
        double interes = 0;
        if (monto >= 0 && monto < 20000) {
            interes = 0.05;
        } else if (monto >= 20000 && monto < 40000) {
            interes = 0.06;
        } else if (monto >= 40000 && monto < 60000) {
            interes = 0.07;
        } else if (monto >= 60000 && monto < 80000) {
            interes = 0.08;
        } else if (monto >= 80000 && monto < 100000) {
            interes = 0.09;
        } else if (monto >= 100000) {
            interes = 0.1;
        }
        return interes;
    }

    public Date generarFechaPago(int numeroCuota) {

        Calendar c = Calendar.getInstance();
        
        c.add(Calendar.MONTH, numeroCuota);
        Date fina = c.getTime();

        return fina;

    }
/*
    public Date generarFechaFin(int plazo) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, plazo);
        Date fina = c.getTime();

        return fina;
    }*/

    @Override
    public List<Credito> findAll() {
        // TODO Auto-generated method stub
        return creditoRepo.findAll();
    }

    @Override
    public <S extends Credito> S save(S entity) {

        return creditoRepo.save(entity);
    }

    @Override
    public Credito getById(Integer arg0) {
        // TODO Auto-generated method stub
        return creditoRepo.getById(arg0);
    }

    @Override
    public Credito getOne(Integer arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Credito entity) {
        creditoRepo.delete(entity);
    }

    @Override
    public void deleteAll() {
        creditoRepo.deleteAll();

    }

    @Override
    public void deleteById(Integer id) {
        creditoRepo.deleteById(id);

    }

    @Override
    public boolean existsById(Integer id) {
        return creditoRepo.existsById(id);
    }

    @Override
    public Optional<Credito> findById(Integer id) {
        // TODO Auto-generated method stub
        return creditoRepo.findById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllInBatch(Iterable<Credito> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public <S extends Credito> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public Credito getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Credito> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAll(Iterable<? extends Credito> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Credito> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Credito> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Credito> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Credito> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Credito> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}
