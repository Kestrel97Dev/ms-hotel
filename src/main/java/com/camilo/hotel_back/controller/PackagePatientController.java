package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.PackagePatientModel;
import com.camilo.hotel_back.service.PackagePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/packagePatients")
public class PackagePatientController {

    private final PackagePatientService packagePatientService;

    @Autowired
    public PackagePatientController(PackagePatientService packagePatientService) {
        this.packagePatientService = packagePatientService;
    }

    @GetMapping
    public ResponseEntity<List<PackagePatientModel>> getAllPackagePatients() {
        List<PackagePatientModel> packagePatients = packagePatientService.getAllPackagePatients();
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/packageName/{packageName}")
    public ResponseEntity<List<PackagePatientModel>> findByPackageName(@PathVariable String packageName) {
        List<PackagePatientModel> packagePatients = packagePatientService.findByPackageName(packageName);
        if (packagePatients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/patientFirstName/{patientFirstName}")
    public ResponseEntity<List<PackagePatientModel>> findByPatientFirstName(@PathVariable String patientFirstName) {
        List<PackagePatientModel> packagePatients = packagePatientService.findByPatientFirstName(patientFirstName);
        if (packagePatients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/patientId/{patientId}")
    public ResponseEntity<List<PackagePatientModel>> findByPatientModelId(@PathVariable Long patientId) {
        List<PackagePatientModel> packagePatients = packagePatientService.findByPatientModelId(patientId);
        if (packagePatients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/packageId/{packageId}")
    public ResponseEntity<List<PackagePatientModel>> findByPackageModelId(@PathVariable Long packageId) {
        List<PackagePatientModel> packagePatients = packagePatientService.findByPackageModelId(packageId);
        if (packagePatients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/purchaseDateBetween/{startDate}/{endDate}")
    public ResponseEntity<List<PackagePatientModel>> findByPurchaseDateBetween(@PathVariable Date startDate, @PathVariable Date endDate) {
        List<PackagePatientModel> packagePatients = packagePatientService.findByPurchaseDateBetween(startDate, endDate);
        return new ResponseEntity<>(packagePatients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackagePatientModel> getPackagePatientById(@PathVariable Long id) {
        Optional<PackagePatientModel> packagePatient = packagePatientService.getPackagePatientById(id);
        return packagePatient.map(pp -> new ResponseEntity<>(pp, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PackagePatientModel> createPackagePatient(@RequestBody PackagePatientModel packagePatientModel) {
        PackagePatientModel savedPackagePatient = packagePatientService.savePackagePatient(packagePatientModel);
        return new ResponseEntity<>(savedPackagePatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackagePatientModel> updatePackagePatient(@PathVariable Long id, @RequestBody PackagePatientModel packagePatientModel) {
        Optional<PackagePatientModel> existingPackagePatient = packagePatientService.getPackagePatientById(id);
        if (existingPackagePatient.isPresent()) {
            packagePatientModel.setId(id);
            PackagePatientModel updatedPackagePatient = packagePatientService.savePackagePatient(packagePatientModel);
            return new ResponseEntity<>(updatedPackagePatient, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackagePatient(@PathVariable Long id) {
        Optional<PackagePatientModel> existingPackagePatient = packagePatientService.getPackagePatientById(id);
        if (existingPackagePatient.isPresent()) {
            packagePatientService.deletePackagePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
