package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.GuestModel;
import com.camilo.hotel_back.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestModel> getAllGuests() {
        return guestRepository.findAll();
    }

    public List<GuestModel> findByPatientFirstName(String firstName) {
        return guestRepository.findByPatientFirstName(firstName);
    }

    public List<GuestModel> findByRoomNumber(String roomNumber) {
        return guestRepository.findByRoomNumber(roomNumber);
    }

    public List<GuestModel> findByEntryDateAfter(Date entryDate) {
        return guestRepository.findByEntryDateAfter(entryDate);
    }

    public List<GuestModel> findByExitDateBefore(Date exitDate) {
        return guestRepository.findByExitDateBefore(exitDate);
    }

    public List<GuestModel> findByPatientId(Long patientId) {
        return guestRepository.findByPatientId(patientId);
    }

    public Optional<GuestModel> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public GuestModel saveGuest(GuestModel guestModel) {
        return guestRepository.save(guestModel);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }

}
