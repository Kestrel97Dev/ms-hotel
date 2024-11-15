package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.ServiceModel;
import com.camilo.hotel_back.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceModel>> getAllServices() {
        List<ServiceModel> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ServiceModel>> findByName(@PathVariable String name) {
        List<ServiceModel> services = serviceService.findByName(name);
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/minCost/{minCost}")
    public ResponseEntity<List<ServiceModel>> findByMinCost(@PathVariable Double minCost) {
        List<ServiceModel> services = serviceService.findByMinCost(minCost);
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/costLessThan/{cost}")
    public ResponseEntity<List<ServiceModel>> findByCostLessThan(@PathVariable Double cost) {
        List<ServiceModel> services = serviceService.findByCostLessThan(cost);
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/nameContainingIgnoreCase/{name}")
    public ResponseEntity<List<ServiceModel>> findByNameContainingIgnoreCase(@PathVariable String name) {
        List<ServiceModel> services = serviceService.findByNameContainingIgnoreCase(name);
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceModel> getServiceById(@PathVariable Long id) {
        Optional<ServiceModel> serviceModel = serviceService.getServiceById(id);
        return serviceModel.map(service -> new ResponseEntity<>(service, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ServiceModel> createService(@RequestBody ServiceModel serviceModel) {
        ServiceModel savedService = serviceService.saveService(serviceModel);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceModel> updateService(@PathVariable Long id, @RequestBody ServiceModel serviceModel) {
        Optional<ServiceModel> existingService = serviceService.getServiceById(id);
        if (existingService.isPresent()) {
            serviceModel.setId(id);
            ServiceModel updatedService = serviceService.saveService(serviceModel);
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        Optional<ServiceModel> existingService = serviceService.getServiceById(id);
        if (existingService.isPresent()) {
            serviceService.deleteService(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
