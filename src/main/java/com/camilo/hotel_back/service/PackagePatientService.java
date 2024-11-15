package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.PackagePatientModel;
import com.camilo.hotel_back.repository.PackagePatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PackagePatientService {

    private final PackagePatientRepository packagePatientRepository;

    @Autowired
    public PackagePatientService(PackagePatientRepository packagePatientRepository) {
        this.packagePatientRepository = packagePatientRepository;
    }

    public List<PackagePatientModel> getAllPackagePatients() {
        return packagePatientRepository.findAll();
    }

    public List<PackagePatientModel> findByPackageName(String packageName) {
        return packagePatientRepository.findByPackageName(packageName);
    }

    public List<PackagePatientModel> findByPatientFirstName(String patientFirstName) {
        return packagePatientRepository.findByPatientFirstName(patientFirstName);
    }

    public List<PackagePatientModel> findByPatientModelId(Long patientId) {
        return packagePatientRepository.findByPatientModelId(patientId);
    }

    public List<PackagePatientModel> findByPackageModelId(Long packageId) {
        return packagePatientRepository.findByPackageModelId(packageId);
    }

    public List<PackagePatientModel> findByPurchaseDateBetween(Date startDate, Date endDate) {
        return packagePatientRepository.findByPurchaseDateBetween(startDate, endDate);
    }

    public Optional<PackagePatientModel> getPackagePatientById(Long id) {
        return packagePatientRepository.findById(id);
    }

    public PackagePatientModel savePackagePatient(PackagePatientModel packagePatientModel) {
        return packagePatientRepository.save(packagePatientModel);
    }

    public void deletePackagePatient(Long id) {
        packagePatientRepository.deleteById(id);
    }

}
