package com.codegym.controller;


import com.codegym.model.Student;
import com.codegym.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
//    hiện thị tất cả học sinh
    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllStudent(){
        List<Student> students=(List<Student>) studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
//    thêm học sinh
    @PostMapping("")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    tìm kiếm học sinh theo tên
    @GetMapping("/search")
    public ResponseEntity<Iterable<Student>> findAllByNameContainingStudent(@RequestParam String name) {
        Iterable<Student> products = studentService.findAllByNameContaining(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    top 3 điểm cao nhất
    @GetMapping("/getTop3")
    public ResponseEntity<Iterable<Student>> getTop3() {
        Iterable<Student> students = studentService.getTop3();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
//    sắp xếp theo điểm
    @GetMapping("/sortByScore")
    public ResponseEntity<Iterable<Student>> findAllByOrderByScore() {
        Iterable<Student> students = studentService.findAllByOrderByScore();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
//    tìm kiếm theo id
    @GetMapping("/{id}")
    public ResponseEntity<Student> findProductById(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }
//    sửa
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateProduct(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(studentOptional.get().getId());
        studentService.save(student);
        return new ResponseEntity<>( HttpStatus.OK);
    }
//    xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteProduct(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
    }
}
