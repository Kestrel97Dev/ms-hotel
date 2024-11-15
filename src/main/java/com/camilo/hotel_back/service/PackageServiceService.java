package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.PackageServiceModel;
import com.camilo.hotel_back.repository.PackageServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceService {

    private final PackageServiceRepository packageServiceRepository;

    @Autowired
    public PackageServiceService(PackageServiceRepository packageServiceRepository) {
        this.packageServiceRepository = packageServiceRepository;
    }

    public List<PackageServiceModel> getAllPackageServices() {
        return packageServiceRepository.findAll();
    }

    public List<PackageServiceModel> findByPackageName(String packageName) {
        return packageServiceRepository.findByPackageName(packageName);
    }

    public List<PackageServiceModel> findByServiceName(String serviceName) {
        return packageServiceRepository.findByServiceName(serviceName);
    }

    public List<PackageServiceModel> findByPackageModelId(Long packageId) {
        return packageServiceRepository.findByPackageModelId(packageId);
    }

    public List<PackageServiceModel> findByServiceModelId(Long serviceId) {
        return packageServiceRepository.findByServiceModelId(serviceId);
    }

    public Optional<PackageServiceModel> getPackageServiceById(Long id) {
        return packageServiceRepository.findById(id);
    }

    public PackageServiceModel savePackageService(PackageServiceModel packageServiceModel) {
        return packageServiceRepository.save(packageServiceModel);
    }

    public void deletePackageService(Long id) {
        packageServiceRepository.deleteById(id);
    }

}
