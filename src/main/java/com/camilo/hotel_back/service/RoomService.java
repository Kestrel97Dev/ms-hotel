package com.camilo.hotel_back.service;

import com.camilo.hotel_back.model.RoomModel;
import com.camilo.hotel_back.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<RoomModel> findByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public List<RoomModel> findByVacant(Boolean vacant) {
        return roomRepository.findByVacant(vacant);
    }

    public List<RoomModel> findByCategoryId(Long categoryId) {
        return roomRepository.findByCategoryId(categoryId);
    }

    public List<RoomModel> findByFloor(Integer floor) {
        return roomRepository.findByFloor(floor);
    }

    public Optional<RoomModel> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public RoomModel saveRoom(RoomModel roomModel) {
        return roomRepository.save(roomModel);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

}
