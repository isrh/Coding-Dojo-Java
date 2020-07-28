package com.ignaciorivera.studentlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignaciorivera.studentlist.models.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	List<Room> findAll();
}
