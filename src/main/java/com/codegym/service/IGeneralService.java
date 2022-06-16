package com.codegym.service;

import java.util.Optional;

public interface IGeneralService<T> {
    //   hiển thị tất cả
    Iterable<T> findAll();

    //tìm kiếm theo id
    Optional<T> findById(Long id);

    //thêm mới
    T save(T t);

    //xóa
    void remove(Long id);
}
