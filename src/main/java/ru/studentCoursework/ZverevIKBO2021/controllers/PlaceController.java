package ru.studentCoursework.ZverevIKBO2021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.studentCoursework.ZverevIKBO2021.models.Place;
import ru.studentCoursework.ZverevIKBO2021.services.PlaceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;


    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping()
    public List<Place> getPlaces() {
        return placeService.readAll();
    }

    @GetMapping("/{id}")
    public Optional<Place> getOne(@PathVariable("id") int id) {
        return placeService.read(id);
    }

    @PostMapping()
    public String savePlace(@RequestBody Place place) {
        placeService.create(place);
        return "200 OK";

    }

    @DeleteMapping("/{id}")
    public boolean deletePlace(@PathVariable("id") int id) {
        return placeService.delete(id);
    }
}
