package ec.edu.ups.InstaWallet.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.InstaWallet.modelo.Credito;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.services.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/credito")
@Tag(name = "Credito", description = "Operaciones de la clase Crédito")
public class CreditoRestController {

    private CreditoService creditoService;
    private Credito credito;

    public CreditoRestController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping("/")
    @Operation(summary = "Crear un credito")
    public Credito crearCredito(@RequestBody Credito credito) {
        return creditoService.save(credito);
    }

    @CrossOrigin
    @PostMapping("/aprobar-rechazar-credito")
    @Operation(summary = "Aprobar o rechazar un crédito")
    public void aprobarRechazarCredito(@RequestParam Integer id, @RequestParam String aprobarRechazar) {

        if (creditoService.existsById(id)) {
            credito = creditoService.findById(id).get();

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

            creditoService.update(credito);

        }
    }


    @GetMapping("/findAllPendientes")
    @Operation(summary = "Encontar creditos que estan pendientes de aprovación o rechazo")
    public ArrayList<Credito> findAllPendiente(){
        var listaTodos = creditoService.findAll();
        ArrayList<Credito> creditosPendientes = new ArrayList<>();

        for(Credito cre:listaTodos){
            if(cre.getEstadoSolicitudCredito().equalsIgnoreCase("en trámite")){
                creditosPendientes.add(cre);
            }

        }

        return creditosPendientes;
    }




    @GetMapping("/tabla-amortizacion")
    @Operation(summary = "Crear una tabla de amortización")
    public ArrayList<DetalleCredito> generarTablaAmortizacion(@RequestParam int numeroDeCuotas,
            //@RequestParam Date fechaInicio,
            @RequestParam double valorCredito) {

        double pagoMensual = valorCredito / numeroDeCuotas;
        //double interes = creditoService.calculoInteres(valorCredito);
        double interes = 0.5;
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
