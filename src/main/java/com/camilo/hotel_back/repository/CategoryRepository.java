package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    @Query("SELECT c FROM CategoryModel c WHERE c.name LIKE %:name%")
    List<CategoryModel> findByName(@Param("name") String name);

}
