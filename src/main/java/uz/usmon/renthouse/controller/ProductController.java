package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.PhotoDto;
import uz.usmon.renthouse.dto.ProductDto;
import uz.usmon.renthouse.model.Photo;
import uz.usmon.renthouse.model.Product;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.service.PhotoService;
import uz.usmon.renthouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService aboutUsService;
    @GetMapping
    public HttpEntity<?> findAll(){
        List<Product> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        Product aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody ProductDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public HttpEntity<?> update(@PathVariable Integer id , @RequestBody ProductDto aboutUsDto) {
        Result result = aboutUsService.update(id, aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
