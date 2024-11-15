package com.camilo.hotel_back.controller;

import com.camilo.hotel_back.model.RoomModel;
import com.camilo.hotel_back.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomModel>> getAllRooms() {
        List<RoomModel> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/roomNumber/{roomNumber}")
    public ResponseEntity<List<RoomModel>> findByRoomNumber(@PathVariable String roomNumber) {
        List<RoomModel> rooms = roomService.findByRoomNumber(roomNumber);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/vacant/{vacant}")
    public ResponseEntity<List<RoomModel>> findByVacant(@PathVariable Boolean vacant) {
        List<RoomModel> rooms = roomService.findByVacant(vacant);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<RoomModel>> findByCategoryId(@PathVariable Long categoryId) {
        List<RoomModel> rooms = roomService.findByCategoryId(categoryId);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/floor/{floor}")
    public ResponseEntity<List<RoomModel>> findByFloor(@PathVariable Integer floor) {
        List<RoomModel> rooms = roomService.findByFloor(floor);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomModel> getRoomById(@PathVariable Long id) {
        Optional<RoomModel> roomModel = roomService.getRoomById(id);
        return roomModel.map(room -> new ResponseEntity<>(room, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RoomModel> createRoom(@RequestBody RoomModel roomModel) {
        RoomModel savedRoom = roomService.saveRoom(roomModel);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomModel> updateRoom(@PathVariable Long id, @RequestBody RoomModel roomModel) {
        Optional<RoomModel> existingRoom = roomService.getRoomById(id);
        if (existingRoom.isPresent()) {
            roomModel.setId(id);
            RoomModel updatedRoom = roomService.saveRoom(roomModel);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        Optional<RoomModel> existingRoom = roomService.getRoomById(id);
        if (existingRoom.isPresent()) {
            roomService.deleteRoom(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
