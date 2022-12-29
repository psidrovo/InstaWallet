/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.Credito;
import ec.edu.ups.InstaWallet.repository.CreditoRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EstAdolfoSebastianJa
 */
@Service
public class CreditoService {

    @Autowired
    private CreditoRepo creditoRepo;

    public CreditoService(CreditoRepo creditoRepo) {
        this.creditoRepo = creditoRepo;
    }

    public Credito save(Credito credito) {
        return creditoRepo.save(credito);
    }

    public boolean existsById(int id) {
        Optional<Credito> cre = creditoRepo.findById(id);

        return cre.isPresent();
    }

    public Optional<Credito> findById(int id) {

        return creditoRepo.findById(id);
    }

    public List<Credito> findAll() {
        return creditoRepo.findAll();
    }

    public Credito update(Credito credito) {
        return creditoRepo.save(credito);
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

    /*

     */
}
