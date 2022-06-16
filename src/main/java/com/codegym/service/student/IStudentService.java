package com.codegym.service.student;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByNameContaining(String name);

    Iterable<Student> findAllByOrderByScore();

    Iterable<Student> getTop3();

    Iterable<Student> findAllByClassRoom(ClassRoom classRoom);
}
