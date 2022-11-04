package com.ibrahim.istidata.controller;

import com.ibrahim.istidata.exception.ResourceNotFoundException;
import com.ibrahim.istidata.model.Personal;
import com.ibrahim.istidata.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personals")

public class PersonalControllers {

    @Autowired
    public PersonalRepository personalRepository;

    @GetMapping
    public List<Personal> getAllPersonal(){
        return personalRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal){
        return personalRepository.save(personal);
    }

    // build get personal by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable long id){
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("the person doesn't exist: " + id));
        return ResponseEntity.ok(personal);
    }

    // build update personal REST API
    @PatchMapping("{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable long id,@RequestBody Personal personalDetails){
        Personal updatePersonal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("the person doesn't exist with:" + id));

        updatePersonal.setNik(personalDetails.getNik());
        updatePersonal.setFullName(personalDetails.getFullName());
        updatePersonal.setAge(personalDetails.getAge());
        updatePersonal.setBorn(personalDetails.getBorn());
        updatePersonal.setGender(personalDetails.getGender());
        updatePersonal.setAddress(personalDetails.getAddress());
        updatePersonal.setCountry(personalDetails.getCountry());

        personalRepository.save(updatePersonal);

        return ResponseEntity.ok(updatePersonal);
    }

    // build delete personal REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePersonal(@PathVariable long id){

        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("the person doesn't exist with id : " + id));

        personalRepository.delete(personal);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
