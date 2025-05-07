package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.CartDto;
import uz.usmon.renthouse.dto.CommentDto;
import uz.usmon.renthouse.model.Cart;
import uz.usmon.renthouse.model.Comment;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.service.CartService;
import uz.usmon.renthouse.service.CommentService;

import java.util.List;
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService aboutUsService;
    @GetMapping
    public HttpEntity<?> findAll(){
        List<Comment> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        Comment aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody CommentDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public HttpEntity<?> update(@PathVariable Integer id , @RequestBody CommentDto aboutUsDto) {
        Result result = aboutUsService.update(id, aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
