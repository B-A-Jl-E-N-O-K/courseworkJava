package ru.studentCoursework.ZverevIKBO2021.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.studentCoursework.ZverevIKBO2021.models.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
