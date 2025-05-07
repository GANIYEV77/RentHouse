package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.AboutUsDto;
import uz.usmon.renthouse.model.AboutUs;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.service.AboutUsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aboutus")
public class AboutUsController {
    @Autowired
    AboutUsService aboutUsService;
    @GetMapping
    public HttpEntity<?> findAll(){
        List<AboutUs> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        AboutUs aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody AboutUsDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public HttpEntity<?> update(@PathVariable Integer id , @RequestBody AboutUsDto aboutUsDto) {
        Result result = aboutUsService.update(id, aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
