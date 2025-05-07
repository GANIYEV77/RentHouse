package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.ProfileDto;
import uz.usmon.renthouse.dto.UserDto;
import uz.usmon.renthouse.model.Profile;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.model.User;
import uz.usmon.renthouse.service.ProfileServise;
import uz.usmon.renthouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService aboutUsService;
    @GetMapping
    public HttpEntity<?> findAll(){
        List<User> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        User aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<?> create(@RequestBody UserDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping
    public HttpEntity<?> update(@PathVariable Integer id , @RequestBody UserDto aboutUsDto) {
        Result result = aboutUsService.update(id,aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
