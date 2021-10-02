package com.faisal.restapispring.controller;

import com.faisal.restapispring.dto.ResponseData;
import com.faisal.restapispring.dto.SuplierData;
import com.faisal.restapispring.model.entities.Supliers;
import com.faisal.restapispring.service.SuplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/suplier")
public class SuplierController {

    @Autowired
    private SuplierService suplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Supliers>> create(@Valid @RequestBody SuplierData suplierData, Errors errors){
        ResponseData<Supliers> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // manual tanpa model mapper
        // Supliers supliers = new Supliers();
        // supliers.setName(suplierData.getName());
        // supliers.setAddress(suplierData.getAddress());
        // supliers.setEmail(suplierData.getEmail());

        //dengan model mapper
        Supliers supliers = modelMapper.map(suplierData,Supliers.class);

        responseData.setStatus(true);
        responseData.setPayload(suplierService.saveSuplier(supliers));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Supliers> findall(){
        return suplierService.getAllSuplier();
    }

    @GetMapping("/{id}")
    public Supliers findOne(@PathVariable long id){
        return  suplierService.getSuplierById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Supliers>> update(@Valid @RequestBody SuplierData suplierData, Errors errors){
        ResponseData<Supliers> responseData = new ResponseData<>();
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        // manual tanpa model mapper
        // Supliers supliers = new Supliers();
        // supliers.setName(suplierData.getName());
        // supliers.setAddress(suplierData.getAddress());
        // supliers.setEmail(suplierData.getEmail());

        //dengan model mapper
        Supliers supliers = modelMapper.map(suplierData,Supliers.class);

        responseData.setStatus(true);
        responseData.setPayload(suplierService.saveSuplier(supliers));

        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public String removeOne(@PathVariable("id") Long id){
        suplierService.deleteSuplier(id);
        return "Sucees Delete Product";
    }


}
