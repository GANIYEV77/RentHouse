package uz.usmon.renthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.usmon.renthouse.dto.PhotoDto;
import uz.usmon.renthouse.dto.ProfileDto;
import uz.usmon.renthouse.model.Photo;
import uz.usmon.renthouse.model.Profile;
import uz.usmon.renthouse.model.Result;
import uz.usmon.renthouse.service.PhotoService;
import uz.usmon.renthouse.service.ProfileServise;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    ProfileServise aboutUsService;

    @GetMapping
    public HttpEntity<?> findAll() {
        List<Profile> aboutUs = aboutUsService.findAll();
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Profile aboutUs = aboutUsService.findById(id);
        return new ResponseEntity<>(aboutUs, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> create(@RequestBody ProfileDto aboutUsDto) {
        Result result = aboutUsService.create(aboutUsDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody ProfileDto aboutUsDto) {
        Result result = aboutUsService.update(aboutUsDto, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        aboutUsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
