package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//CrossOrigin allows the backend to be accessed on production
@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
//this refers to the command to ask for this class GET, POST, PUT, DELETE, UPDATE
public class StockController {

    //Connect to database
    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        //Takes care of receiving Post data, with an StockDTO object
        return ResponseEntity.ok(service.save(dto));
        //Sane as a 200 http code
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
        /*PREVIOUS MOCK DATA:
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine Luiza");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);
        return ResponseEntity.ok(list);*/
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        //gets response using specific ID
        return ResponseEntity.ok(service.findById(id));
        /*PREVIOUS MOCK DATA:
        List<StockDTO> list = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Magazine Luiza");
        stock1.setPrice(100D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());
        list.add(stock1);
        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Gamestop");
        stock2.setPrice(200D);
        stock2.setVariation(20D);
        stock2.setDate(LocalDate.now());
        list.add(stock2);
        StockDTO dtoSelect = list.stream().filter(x->x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dtoSelect);*/
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today")
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }
}
