package com.example.openapi;


import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;



@RestController
public class TestController {

    Map<String,Patient> patients = new HashMap<>();

    @Operation(summary = "Gets the patient details for the specific patient id passed")
    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable("id") String id) {

        System.out.println(id);
        System.out.println(patients.get(id));
       return patients.get(id);
    }

    @Operation(summary = "Gets the details of all the patients in the system")
    @GetMapping("/patients")
    public Collection<Patient> getAllPatients() {

        return patients.values();
    }

    @Operation(summary = "Adds details of a new patient to the system")
    @PostMapping("/patient")
    public void addPatient(@RequestBody Patient patient) {

        this.patients.put(patient.id(),patient);

    }

    @Operation(summary = "Updates the detail of specific patient in the system")
    @PutMapping("/patient")
    public void updatePatient(@RequestBody Patient patient) {

     patients.put(patient.id(), patient);


    }

    @Operation(summary = "Deletes details of a patient represented by the passed id")
    @DeleteMapping("/patient/{id}")
    public void delete(@PathVariable("id") String id) {

      patients.remove(id);

    }
}
