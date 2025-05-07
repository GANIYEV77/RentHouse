package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.AddressDto;
import uz.usmon.renthouse.dto.CardDto;
import uz.usmon.renthouse.model.Address;
import uz.usmon.renthouse.model.Card;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.service.AddressService;
import uz.usmon.renthouse.service.CardServise;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardControllet {
    @Autowired
    CardServise aboutUsService;
    @GetMapping
    public HttpEntity<?> findAll(){
        List<Card> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        Card aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody CardDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public HttpEntity<?> update(@PathVariable Integer id , @RequestBody CardDto aboutUsDto) {
        Result result = aboutUsService.update(id, aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
