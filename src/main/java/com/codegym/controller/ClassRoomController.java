package com.codegym.controller;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.classRoom.IClassRoomService;
import com.codegym.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/classrooms")
public class ClassRoomController {
    @Autowired
    IClassRoomService classRoomService;
    @Autowired
    IStudentService studentService;
    @GetMapping
    public ResponseEntity<Iterable<ClassRoom>> findAllClassRoom() {
        List<ClassRoom> classRooms = (List<ClassRoom>) classRoomService.findAll();
        if (classRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

    @GetMapping("/view-classrooms/{id}")
    public ResponseEntity<Iterable<Student>> getProductByClassRoom(@PathVariable("id") Long id) {
        Optional<ClassRoom> classRoom = classRoomService.findById(id);
        if (!classRoom.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Student> students = (List<Student>) studentService.findAllByClassRoom(classRoom.get());
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);

    }
}
