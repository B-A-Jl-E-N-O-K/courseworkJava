package ru.studentCoursework.ZverevIKBO2021.services;


import ru.studentCoursework.ZverevIKBO2021.models.Dish;
import ru.studentCoursework.ZverevIKBO2021.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public void create(Dish dish) {
        dishRepository.save(dish);
    }

    public List<Dish>  readAll() {
        return dishRepository.findAll();
    }

    public Optional<Dish> read(int id) {
        return dishRepository.findById(id);
    }

    public boolean delete(int id) {
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
