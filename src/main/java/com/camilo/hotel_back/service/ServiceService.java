package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.ServiceModel;
import com.camilo.hotel_back.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<ServiceModel> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    public List<ServiceModel> findByMinCost(Double minCost) {
        return serviceRepository.findByMinCost(minCost);
    }

    public List<ServiceModel> findByCostLessThan(Double cost) {
        return serviceRepository.findByCostLessThan(cost);
    }

    public List<ServiceModel> findByNameContainingIgnoreCase(String name) {
        return serviceRepository.findByNameContainingIgnoreCase(name);
    }

    public Optional<ServiceModel> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public ServiceModel saveService(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

}
