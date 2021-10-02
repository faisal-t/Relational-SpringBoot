package com.faisal.restapispring.service;

import com.faisal.restapispring.model.entities.Supliers;
import com.faisal.restapispring.model.repository.SuplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import java.util.Optional;

@Service
@TransactionScoped
public class SuplierService {

    @Autowired
    private SuplierRepository suplierRepository;

    public Supliers saveSuplier(Supliers supliers){

        return suplierRepository.save(supliers);
    }

    public Supliers getSuplierById(Long id){
        Optional<Supliers> supliers = suplierRepository.findById(id);
        if (!supliers.isPresent()){
            return null;
        }
        return suplierRepository.findById(id).get();
    }

    public Iterable<Supliers> getAllSuplier(){
        return suplierRepository.findAll();
    }

    public void deleteSuplier(Long id){
        suplierRepository.deleteById(id);
    }




}
