package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {

    @Query("SELECT p FROM PatientModel p WHERE p.firstName LIKE %:firstName%")
    List<PatientModel> findByFirstName(@Param("firstName") String firstName);

    @Query("SELECT p FROM PatientModel p WHERE p.lastName LIKE %:lastName%")
    List<PatientModel> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM PatientModel p WHERE p.firstName LIKE %:firstName% AND p.lastName LIKE %:lastName%")
    List<PatientModel> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
