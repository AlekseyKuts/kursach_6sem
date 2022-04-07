package com.bsuir.kursach.service;

import com.bsuir.kursach.model.Car;
import com.bsuir.kursach.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{

    @Autowired
    private CarRepository repository;

    @Override
    public List<Car> findAll() {
        return (List<Car>) repository.findAll();
    }

    @Override
    public void save(Car car) {
        repository.save(car);
    }

    @Override
    public Car findById(Long id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) return car.get();
        else return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.removeById(id);
    }

    @Override
    public void delete(Car car) {
        repository.delete(car);
    }


}
