package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<PackageModel, Long> {

    @Query("SELECT p FROM PackageModel p WHERE p.name LIKE %:name%")
    List<PackageModel> findByName(@Param("name") String name);

    @Query("SELECT p FROM PackageModel p WHERE p.totalCost >= :minCost")
    List<PackageModel> findByMinCost(@Param("minCost") Double minCost);

    @Query("SELECT p FROM PackageModel p WHERE p.name LIKE %:name%")
    List<PackageModel> findByNameContaining(@Param("name") String name);

    @Query("SELECT p FROM PackageModel p WHERE p.totalCost < :cost")
    List<PackageModel> findByTotalCostLessThan(@Param("cost") Double cost);

    @Query("SELECT p FROM PackageModel p WHERE p.days BETWEEN :startDays AND :endDays")
    List<PackageModel> findByDaysBetween(@Param("startDays") Integer startDays, @Param("endDays") Integer endDays);

}
