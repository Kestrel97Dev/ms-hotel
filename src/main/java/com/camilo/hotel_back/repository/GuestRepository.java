package com.camilo.hotel_back.repository;

import com.camilo.hotel_back.model.GuestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestModel, Long> {

    @Query("SELECT g FROM GuestModel g WHERE g.patient.firstName LIKE %:firstName%")
    List<GuestModel> findByPatientFirstName(@Param("firstName") String firstName);

    @Query("SELECT g FROM GuestModel g WHERE g.room.number LIKE %:roomNumber%")
    List<GuestModel> findByRoomNumber(@Param("roomNumber") String roomNumber);

    @Query("SELECT g FROM GuestModel g WHERE g.entryDate > :entryDate")
    List<GuestModel> findByEntryDateAfter(@Param("entryDate") Date entryDate);

    @Query("SELECT g FROM GuestModel g WHERE g.exitDate < :exitDate")
    List<GuestModel> findByExitDateBefore(@Param("exitDate") Date exitDate);

    @Query("SELECT g FROM GuestModel g WHERE g.patient.id = :patientId")
    List<GuestModel> findByPatientId(@Param("patientId") Long patientId);

}
