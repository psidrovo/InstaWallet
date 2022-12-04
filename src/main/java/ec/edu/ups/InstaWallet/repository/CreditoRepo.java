/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.InstaWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.ups.InstaWallet.modelo.Credito;

/**
 *
 * @author EstAdolfoSebastianJa
 */
public interface CreditoRepo extends JpaRepository<Credito, Long>{
    
}
