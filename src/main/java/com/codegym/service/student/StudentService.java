package com.codegym.service.student;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findAllByNameContaining(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Student> findAllByOrderByScore() {
        return studentRepository.findAllByOrderByScore();
    }

    @Override
    public Iterable<Student> getTop3() {
        return studentRepository.getTop3();
    }

    @Override
    public Iterable<Student> findAllByClassRoom(ClassRoom classRoom) {
        return studentRepository.findAllByClassRoom(classRoom);
    }
}
