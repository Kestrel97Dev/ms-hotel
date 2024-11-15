package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.PackageModel;
import com.camilo.hotel_back.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<PackageModel> getAllPackages() {
        return packageRepository.findAll();
    }

    public List<PackageModel> findByName(String name) {
        return packageRepository.findByName(name);
    }

    public List<PackageModel> findByMinCost(Double minCost) {
        return packageRepository.findByMinCost(minCost);
    }

    public List<PackageModel> findByNameContaining(String name) {
        return packageRepository.findByNameContaining(name);
    }

    public List<PackageModel> findByTotalCostLessThan(Double cost) {
        return packageRepository.findByTotalCostLessThan(cost);
    }

    public List<PackageModel> findByDaysBetween(Integer startDays, Integer endDays) {
        return packageRepository.findByDaysBetween(startDays, endDays);
    }

    public Optional<PackageModel> getPackageById(Long id) {
        return packageRepository.findById(id);
    }

    public PackageModel savePackage(PackageModel packageModel) {
        return packageRepository.save(packageModel);
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }

}
