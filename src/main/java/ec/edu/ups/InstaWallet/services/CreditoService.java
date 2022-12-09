/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import io.swagger.v3.oas.models.media.MediaType;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@RestController
@RequestMapping("/credito")
public class CreditoService {

    @Autowired
    private CreditoRepo creditoRepo;

    private Credito credito;
    
    @GetMapping("/all")
    public List<Credito> findAll(){
        return creditoRepo.findAll();
    }
    
    
    
/*
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

    public Date generarFechaFin(int plazo) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, plazo);
        Date fina = c.getTime();

        return fina;
    }*/


}
