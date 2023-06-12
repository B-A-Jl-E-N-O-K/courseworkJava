package ru.studentCoursework.ZverevIKBO2021.services;


import ru.studentCoursework.ZverevIKBO2021.models.Place;
import ru.studentCoursework.ZverevIKBO2021.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public void create(Place place) {
        placeRepository.save(place);
    }

    public List<Place>  readAll() {
        return placeRepository.findAll();
    }

    public Optional<Place> read(int id) {
        return placeRepository.findById(id);
    }

    public boolean update(Place place, int id) {
        if (placeRepository.existsById(id)) {
            place.setId(id);
            placeRepository.save(place);
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        if (placeRepository.existsById(id)) {
            placeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
