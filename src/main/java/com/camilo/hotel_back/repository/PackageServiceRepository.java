package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.PackageServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageServiceRepository extends JpaRepository<PackageServiceModel, Long> {

    @Query("SELECT ps FROM PackageServiceModel ps WHERE ps.packageModel.name LIKE %:packageName%")
    List<PackageServiceModel> findByPackageName(@Param("packageName") String packageName);

    @Query("SELECT ps FROM PackageServiceModel ps WHERE ps.serviceModel.name LIKE %:serviceName%")
    List<PackageServiceModel> findByServiceName(@Param("serviceName") String serviceName);

    @Query("SELECT ps FROM PackageServiceModel ps WHERE ps.packageModel.id = :packageId")
    List<PackageServiceModel> findByPackageModelId(@Param("packageId") Long packageId);

    @Query("SELECT ps FROM PackageServiceModel ps WHERE ps.serviceModel.id = :serviceId")
    List<PackageServiceModel> findByServiceModelId(@Param("serviceId") Long serviceId);

}
