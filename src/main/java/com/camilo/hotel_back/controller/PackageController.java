package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.PackageModel;
import com.camilo.hotel_back.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<PackageModel>> getAllPackages() {
        List<PackageModel> packages = packageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PackageModel>> findByName(@PathVariable String name) {
        List<PackageModel> packages = packageService.findByName(name);
        if (packages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/minCost/{minCost}")
    public ResponseEntity<List<PackageModel>> findByMinCost(@PathVariable Double minCost) {
        List<PackageModel> packages = packageService.findByMinCost(minCost);
        if (packages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/nameContaining/{name}")
    public ResponseEntity<List<PackageModel>> findByNameContaining(@PathVariable String name) {
        List<PackageModel> packages = packageService.findByNameContaining(name);
        if (packages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/totalCostLessThan/{cost}")
    public ResponseEntity<List<PackageModel>> findByTotalCostLessThan(@PathVariable Double cost) {
        List<PackageModel> packages = packageService.findByTotalCostLessThan(cost);
        if (packages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/daysBetween/{startDays}/{endDays}")
    public ResponseEntity<List<PackageModel>> findByDaysBetween(@PathVariable Integer startDays, @PathVariable Integer endDays) {
        List<PackageModel> packages = packageService.findByDaysBetween(startDays, endDays);
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageModel> getPackageById(@PathVariable Long id) {
        Optional<PackageModel> packageModel = packageService.getPackageById(id);
        return packageModel.map(pm -> new ResponseEntity<>(pm, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PackageModel> createPackage(@RequestBody PackageModel packageModel) {
        PackageModel savedPackage = packageService.savePackage(packageModel);
        return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageModel> updatePackage(@PathVariable Long id, @RequestBody PackageModel packageModel) {
        Optional<PackageModel> existingPackage = packageService.getPackageById(id);
        if (existingPackage.isPresent()) {
            packageModel.setId(id);
            PackageModel updatedPackage = packageService.savePackage(packageModel);
            return new ResponseEntity<>(updatedPackage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        Optional<PackageModel> existingPackage = packageService.getPackageById(id);
        if (existingPackage.isPresent()) {
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
