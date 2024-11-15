package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.PackageServiceModel;
import com.camilo.hotel_back.service.PackageServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") // Permite solicitudes de cualquier origen
@RestController
@RequestMapping("/packageServices") // Ruta base para el controlador
public class PackageServiceController {

    private final PackageServiceService packageServiceService;

    @Autowired
    public PackageServiceController(PackageServiceService packageServiceService) {
        this.packageServiceService = packageServiceService;
    }

    // Obtener todos los servicios de paquete
    @GetMapping
    public ResponseEntity<List<PackageServiceModel>> getAllPackageServices() {
        List<PackageServiceModel> packageServices = packageServiceService.getAllPackageServices();
        return new ResponseEntity<>(packageServices, HttpStatus.OK);
    }

    // Buscar servicios de paquete por nombre de paquete
    @GetMapping("/packageName/{packageName}")
    public ResponseEntity<List<PackageServiceModel>> findByPackageName(@PathVariable String packageName) {
        List<PackageServiceModel> packageServices = packageServiceService.findByPackageName(packageName);
        if (packageServices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packageServices, HttpStatus.OK);
    }

    // Buscar servicios de paquete por nombre de servicio
    @GetMapping("/serviceName/{serviceName}")
    public ResponseEntity<List<PackageServiceModel>> findByServiceName(@PathVariable String serviceName) {
        List<PackageServiceModel> packageServices = packageServiceService.findByServiceName(serviceName);
        if (packageServices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(packageServices, HttpStatus.OK);
    }

    // Buscar servicios de paquete por ID de modelo de paquete
    @GetMapping("/packageModelId/{packageId}")
    public ResponseEntity<List<PackageServiceModel>> findByPackageModelId(@PathVariable Long packageId) {
        List<PackageServiceModel> packageServices = packageServiceService.findByPackageModelId(packageId);
        return new ResponseEntity<>(packageServices, HttpStatus.OK);
    }

    // Buscar servicios de paquete por ID de modelo de servicio
    @GetMapping("/serviceModelId/{serviceId}")
    public ResponseEntity<List<PackageServiceModel>> findByServiceModelId(@PathVariable Long serviceId) {
        List<PackageServiceModel> packageServices = packageServiceService.findByServiceModelId(serviceId);
        return new ResponseEntity<>(packageServices, HttpStatus.OK);
    }

    // Obtener un servicio de paquete por ID
    @GetMapping("/{id}")
    public ResponseEntity<PackageServiceModel> getPackageServiceById(@PathVariable Long id) {
        Optional<PackageServiceModel> packageServiceModel = packageServiceService.getPackageServiceById(id);
        return packageServiceModel.map(psm -> new ResponseEntity<>(psm, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo servicio de paquete
    @PostMapping
    public ResponseEntity<PackageServiceModel> createPackageService(@RequestBody PackageServiceModel packageServiceModel) {
        PackageServiceModel savedPackageService = packageServiceService.savePackageService(packageServiceModel);
        return new ResponseEntity<>(savedPackageService, HttpStatus.CREATED);
    }

    // Actualizar un servicio de paquete existente
    @PutMapping("/{id}")
    public ResponseEntity<PackageServiceModel> updatePackageService(@PathVariable Long id, @RequestBody PackageServiceModel packageServiceModel) {
        Optional<PackageServiceModel> existingPackageService = packageServiceService.getPackageServiceById(id);
        if (existingPackageService.isPresent()) {
            packageServiceModel.setId(id);
            PackageServiceModel updatedPackageService = packageServiceService.savePackageService(packageServiceModel);
            return new ResponseEntity<>(updatedPackageService, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un servicio de paquete por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackageService(@PathVariable Long id) {
        Optional<PackageServiceModel> existingPackageService = packageServiceService.getPackageServiceById(id);
        if (existingPackageService.isPresent()) {
            packageServiceService.deletePackageService(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
