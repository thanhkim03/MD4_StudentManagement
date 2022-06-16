package com.codegym.repository;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    //tìm kiếm theo tên
    Iterable<Student> findAllByNameContaining(String name);

    //sắp xếp theo điểm
    Iterable<Student> findAllByOrderByScore();

    //tìm kiếm theo lớp học
    Iterable<Student> findAllByClassRoom(ClassRoom classRoom);

    //tìm kiếm top 3 điểm cao nhất
    @Query(value = "select * from students order by score desc LIMIT 3", nativeQuery = true)
    Iterable<Student> getTop3();
}
