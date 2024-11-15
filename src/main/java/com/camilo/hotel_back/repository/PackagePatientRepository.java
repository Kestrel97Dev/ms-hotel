package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.PackagePatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PackagePatientRepository extends JpaRepository<PackagePatientModel, Long> {

    @Query("SELECT pp FROM PackagePatientModel pp WHERE pp.packageModel.name LIKE %:packageName%")
    List<PackagePatientModel> findByPackageName(@Param("packageName") String packageName);

    @Query("SELECT pp FROM PackagePatientModel pp WHERE pp.patientModel.firstName LIKE %:patientFirstName%")
    List<PackagePatientModel> findByPatientFirstName(@Param("patientFirstName") String patientFirstName);

    @Query("SELECT pp FROM PackagePatientModel pp WHERE pp.patientModel.id = :patientId")
    List<PackagePatientModel> findByPatientModelId(@Param("patientId") Long patientId);

    @Query("SELECT pp FROM PackagePatientModel pp WHERE pp.packageModel.id = :packageId")
    List<PackagePatientModel> findByPackageModelId(@Param("packageId") Long packageId);

    @Query("SELECT pp FROM PackagePatientModel pp WHERE pp.purchaseDate BETWEEN :startDate AND :endDate")
    List<PackagePatientModel> findByPurchaseDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
