package com.bsuir.kursach.service;

import com.bsuir.kursach.model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    List<Car> findAll();
    void save(Car car);
    Car findById(Long id);
    void deleteById(Long id);
    void delete(Car car);
}
