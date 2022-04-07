package com.bsuir.kursach.controllers;

import com.bsuir.kursach.model.Car;
import com.bsuir.kursach.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private ICarService carService;

    @GetMapping
    public String showCars(Model model) {

        List<Car> cars = (List<Car>) carService.findAll();

        model.addAttribute("cars", cars);

        return "cars/showCars";
    }

    @GetMapping("/add")
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        return "cars/addCar";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") Long id, Model model){
        Car car = carService.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "cars/showCarById";
        }
        else {
            return "cars/noCarById";
        }
    }


    @PostMapping
    public String add(@ModelAttribute("car") Car car){
        carService.save(car);

        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String updateCar(Model model, @PathVariable("id") Long id){
        Car car = carService.findById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "cars/updateCar";
        }
        else {
            return "cars/noCarById";
        }
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("id") Long id){
        carService.save(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }
}
