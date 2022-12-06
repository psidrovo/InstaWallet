/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.InstaWallet.services;

import ec.edu.ups.InstaWallet.modelo.DetalleCredito;
import ec.edu.ups.InstaWallet.repository.DetalleCreditoRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

/**
 *
 * @author EstAdolfoSebastianJa
 */
public class DetalleCreditoService implements DetalleCreditoRepo {
    
    @Autowired
    private DetalleCreditoRepo detalleCreditoRepo;

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch(Iterable<DetalleCredito> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends DetalleCredito> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public DetalleCredito getById(Integer arg0) {
        return detalleCreditoRepo.getById(arg0);
    }

    @Override
    public DetalleCredito getOne(Integer arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DetalleCredito getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DetalleCredito> findAll() {
        return detalleCreditoRepo.findAll();
    }

    @Override
    public List<DetalleCredito> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(DetalleCredito entity) {
        
        detalleCreditoRepo.delete(entity);
        
    }

    @Override
    public void deleteAll() {
        
        detalleCreditoRepo.deleteAll();
        
    }

    @Override
    public void deleteAll(Iterable<? extends DetalleCredito> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        
        detalleCreditoRepo.deleteById(id);
        
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return detalleCreditoRepo.existsById(id);
    }

    @Override
    public Optional<DetalleCredito> findById(Integer id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public <S extends DetalleCredito> S save(S entity) {
        // TODO Auto-generated method stub
        return detalleCreditoRepo.save(entity);
    }

    @Override
    public List<DetalleCredito> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<DetalleCredito> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends DetalleCredito> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends DetalleCredito> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends DetalleCredito> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    
    
    
}
