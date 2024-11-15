package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.GuestModel;
import com.camilo.hotel_back.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<GuestModel>> getAllGuests() {
        List<GuestModel> guests = guestService.getAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/patientFirstName/{firstName}")
    public ResponseEntity<List<GuestModel>> findByPatientFirstName(@PathVariable String firstName) {
        List<GuestModel> guests = guestService.findByPatientFirstName(firstName);
        if (guests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/roomNumber/{roomNumber}")
    public ResponseEntity<List<GuestModel>> findByRoomNumber(@PathVariable String roomNumber) {
        List<GuestModel> guests = guestService.findByRoomNumber(roomNumber);
        if (guests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/entryDateAfter/{entryDate}")
    public ResponseEntity<List<GuestModel>> findByEntryDateAfter(@PathVariable Date entryDate) {
        List<GuestModel> guests = guestService.findByEntryDateAfter(entryDate);
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/exitDateBefore/{exitDate}")
    public ResponseEntity<List<GuestModel>> findByExitDateBefore(@PathVariable Date exitDate) {
        List<GuestModel> guests = guestService.findByExitDateBefore(exitDate);
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/patientId/{patientId}")
    public ResponseEntity<List<GuestModel>> findByPatientId(@PathVariable Long patientId) {
        List<GuestModel> guests = guestService.findByPatientId(patientId);
        if (guests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestModel> getGuestById(@PathVariable Long id) {
        Optional<GuestModel> guest = guestService.getGuestById(id);
        return guest.map(g -> new ResponseEntity<>(g, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<GuestModel> createGuest(@RequestBody GuestModel guestModel) {
        GuestModel savedGuest = guestService.saveGuest(guestModel);
        return new ResponseEntity<>(savedGuest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestModel> updateGuest(@PathVariable Long id, @RequestBody GuestModel guestModel) {
        Optional<GuestModel> existingGuest = guestService.getGuestById(id);
        if (existingGuest.isPresent()) {
            guestModel.setId(id);
            GuestModel updatedGuest = guestService.saveGuest(guestModel);
            return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        Optional<GuestModel> existingGuest = guestService.getGuestById(id);
        if (existingGuest.isPresent()) {
            guestService.deleteGuest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
