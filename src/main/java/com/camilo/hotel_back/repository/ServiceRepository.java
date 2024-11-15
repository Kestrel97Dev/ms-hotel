package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {

    @Query("SELECT s FROM ServiceModel s WHERE s.name LIKE %:name%")
    List<ServiceModel> findByName(@Param("name") String name);

    @Query("SELECT s FROM ServiceModel s WHERE s.cost >= :minCost")
    List<ServiceModel> findByMinCost(@Param("minCost") Double minCost);

    @Query("SELECT s FROM ServiceModel s WHERE s.cost < :cost")
    List<ServiceModel> findByCostLessThan(@Param("cost") Double cost);

    @Query("SELECT s FROM ServiceModel s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ServiceModel> findByNameContainingIgnoreCase(@Param("name") String name);

}
