package ru.studentCoursework.ZverevIKBO2021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.studentCoursework.ZverevIKBO2021.models.Dish;
import ru.studentCoursework.ZverevIKBO2021.services.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;


    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping()
    public List<Dish> getDishes() {
        return dishService.readAll();
    }

    @GetMapping("/{id}")
    public Optional<Dish> getOne(@PathVariable("id") int id) {
        return dishService.read(id);
    }

    @PostMapping()
    public Integer saveDish(@RequestBody Dish dish) {
        dishService.create(dish);
        return 1;

    }

    @DeleteMapping("/{id}")
    public boolean deleteDish(@PathVariable("id") int id) {
        return dishService.delete(id);
    }


}
