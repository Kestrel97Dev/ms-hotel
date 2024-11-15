package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.PatientModel;
import com.camilo.hotel_back.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<PatientModel> findByFirstName(String firstName) {
        return patientRepository.findByFirstName(firstName);
    }

    public List<PatientModel> findByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    public List<PatientModel> findByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<PatientModel> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public PatientModel savePatient(PatientModel patientModel) {
        return patientRepository.save(patientModel);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
