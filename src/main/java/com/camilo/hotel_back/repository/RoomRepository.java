package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {

    @Query("SELECT r FROM RoomModel r WHERE r.number LIKE %:roomNumber%")
    List<RoomModel> findByRoomNumber(@Param("roomNumber") String roomNumber);

    @Query("SELECT r FROM RoomModel r WHERE r.vacant = :vacant")
    List<RoomModel> findByVacant(@Param("vacant") Boolean vacant);

    @Query("SELECT r FROM RoomModel r WHERE r.category.id = :categoryId")
    List<RoomModel> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT r FROM RoomModel r WHERE r.floor = :floor")
    List<RoomModel> findByFloor(@Param("floor") Integer floor);

}
