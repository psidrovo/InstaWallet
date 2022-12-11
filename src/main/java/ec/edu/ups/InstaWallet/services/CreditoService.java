/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/credito")
@Tag(name = "Credito", description = "Operaciones de la clase Crédito")
public class CreditoService {

    @Autowired
    private CreditoRepo creditoRepo;

    /*
    
    private CuentaService cuentaService;
     */
    private Credito credito;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Encuentra todos los créditos")
    public List<Credito> findAll() {
        return creditoRepo.findAll();
    }

    @PostMapping("/save")
    @Operation(summary = "Crear un crédito")
    public Credito save(@RequestParam int numeroDeCuotas, @RequestParam double valorCredito) {
        
        var cred = new Credito();
        cred.setEstadoSolicitudCredito("Iniciado");
        cred.setEstado("Iniciado");
        cred.setCuotaCredito(this.calcularPagoMensual(valorCredito, numeroDeCuotas));
        cred.setInteres(this.calculoInteres(valorCredito));
        cred.setNumeroDeCuotas(numeroDeCuotas);
        cred.setValorCredito(valorCredito);

        cred.setFechaInicio(new Date());
        cred.setFechaFinal(this.generarFechaFin(numeroDeCuotas));
        cred.setInteres(this.calculoInteres(valorCredito));
        cred.setNumeroCuotasRestantes(numeroDeCuotas);
        cred.setDetallesCredito(new ArrayList<DetalleCredito>());
        return creditoRepo.save(cred);

    }

    public Credito update(Credito credito) {
        return creditoRepo.save(credito);
    }

    @GetMapping("/existe{id}")
    @Operation(summary = "Comprobar si existe un crédito")
    public boolean existsById(@RequestParam int id) {
        var cre = creditoRepo.findById(id);

        return !cre.isEmpty();
    }

    @GetMapping("/find{id}")
    @Operation(summary = "Encontrar un crédito en particular")
    public Optional<Credito> findById(@RequestParam int id) {

        return creditoRepo.findById(id);
    }

    @PostMapping("/aprobar-rechazar-credito")
    @Operation(summary = "Aprobar o rechazar un crédito")
    public void aprobarRechazarCredito(@RequestParam Integer id, @RequestParam String aprobarRechazar) {

        if (this.existsById(id)) {
            credito = this.findById(id).get();

            credito.setEstadoSolicitudCredito(aprobarRechazar);

            if (aprobarRechazar.startsWith("A")) {
                this.actualizarEstadoCredito("Activo");
                credito.setEstadoSolicitudCredito("Aprobado");

                /*
                
                var cuenta = credito.getCuenta();
                
                cuenta.setSaldo(cuenta.getSaldo + credito.getValorCredito());
                
                cuentaService.save(cuenta);
                 */
            } else {
                this.actualizarEstadoCredito("Desactivo");
                credito.setEstadoSolicitudCredito("Desaprobado");
            }

            this.update(credito);

        }
    }

    @GetMapping("/tabla-amortizacion")
    @Operation(summary = "Crear una tabla de amortización")
    public ArrayList<DetalleCredito> generarTablaAmortizacion(@RequestParam int numeroDeCuotas,
            @RequestParam Date fechaInicio,
            @RequestParam double valorCredito) {

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

    public double calcularPagoMensual(double monto, double numeroDeCuotas) {
        double pagoMensual = monto / numeroDeCuotas;
        double interes = calculoInteres(monto);
        double calucloPago = pagoMensual * interes;
        double total = pagoMensual + calucloPago;
        double pago = Math.round(total);

        return pago;
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
    }

    public void actualizarEstadoCredito(@RequestParam String estado) {

        credito.setEstado(estado);
    }

}
