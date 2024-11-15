package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.PatientModel;
import com.camilo.hotel_back.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientModel>> getAllPatients() {
        List<PatientModel> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<PatientModel>> findByFirstName(@PathVariable String firstName) {
        List<PatientModel> patients = patientService.findByFirstName(firstName);
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<PatientModel>> findByLastName(@PathVariable String lastName) {
        List<PatientModel> patients = patientService.findByLastName(lastName);
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}/lastName/{lastName}")
    public ResponseEntity<List<PatientModel>> findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        List<PatientModel> patients = patientService.findByFirstNameAndLastName(firstName, lastName);
        if (patients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getPatientById(@PathVariable Long id) {
        Optional<PatientModel> patientModel = patientService.getPatientById(id);
        return patientModel.map(patient -> new ResponseEntity<>(patient, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PatientModel> createPatient(@RequestBody PatientModel patientModel) {
        PatientModel savedPatient = patientService.savePatient(patientModel);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatient(@PathVariable Long id, @RequestBody PatientModel patientModel) {
        Optional<PatientModel> existingPatient = patientService.getPatientById(id);
        if (existingPatient.isPresent()) {
            patientModel.setId(id);
            PatientModel updatedPatient = patientService.savePatient(patientModel);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Optional<PatientModel> existingPatient = patientService.getPatientById(id);
        if (existingPatient.isPresent()) {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
