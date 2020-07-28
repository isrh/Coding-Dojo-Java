package com.ignaciorivera.studentlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.studentlist.models.Contact;
import com.ignaciorivera.studentlist.models.Room;
import com.ignaciorivera.studentlist.models.Student;
import com.ignaciorivera.studentlist.models.Subject;
import com.ignaciorivera.studentlist.repositories.ContactRepository;
import com.ignaciorivera.studentlist.repositories.RoomRepository;
import com.ignaciorivera.studentlist.repositories.StudentRepository;
import com.ignaciorivera.studentlist.repositories.SubjectRepository;



@Service
public class MainService {

	
private final  StudentRepository studentRepository;
private final  ContactRepository contactRepository;
private final  RoomRepository roomRepository;
private final SubjectRepository subjectRepository;
	
	public  MainService(StudentRepository  studentRepository,ContactRepository contactRepository, 
			RoomRepository roomRepository, SubjectRepository subjectRepository) {
		this.studentRepository=studentRepository;
		this.contactRepository=contactRepository;
		this.roomRepository=roomRepository;
		this.subjectRepository=subjectRepository;
		
	}
	
	//Devolviendo todas las canciones
    public List<Student> allStudent() {
        return studentRepository.findAll();
    }
    
  //Devolviendo todos los estudiantes
    public List<Contact> allContact() {
        return contactRepository.findAll();
    }
    
  //Devolviendo todos las Rooms
    public List<Room> allRooms() {
        return roomRepository.findAll();
    }
    
  //Devolviendo todos las materias
    public List<Subject> allSubjects() {
        return subjectRepository.findAll();
    }
    
    //Creando un nuevo estudiante
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
  //Creando un nuevo contacto
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
    
    //Creando un nuevo contacto
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    
  //Creando un nuevo contacto
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    
    //Buscar estudiante por id
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    
  //Buscar pieza por id
    public Room findRoom(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(optionalRoom.isPresent()) {
            return optionalRoom.get();
        } else {
            return null;
        }
    }
    
  //Buscar una clase por su id
    public Subject findSubject(Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()) {
            return optionalSubject.get();
        } else {
            return null;
        }
    }
    
  //Actualizar Datos de una Persona.
    public Student updateStudent(Student b) {
    	Optional<Student> user = studentRepository.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setRoom(b.getRoom());
        
        	return studentRepository.save(user.get());
        } else {
            return null;
        }   
    }
}
