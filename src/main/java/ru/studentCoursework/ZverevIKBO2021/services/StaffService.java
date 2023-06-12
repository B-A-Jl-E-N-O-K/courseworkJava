package ru.studentCoursework.ZverevIKBO2021.services;


import ru.studentCoursework.ZverevIKBO2021.models.Staff;
import ru.studentCoursework.ZverevIKBO2021.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public void create(Staff staff) {
        staffRepository.save(staff);
    }

    public List<Staff>  readAll() {
        return staffRepository.findAll();
    }

    public Optional<Staff> read(int id) {
        return staffRepository.findById(id);
    }

    public boolean update(Staff staff, int id) {
        if (staffRepository.existsById(id)) {
            staff.setId(id);
            staffRepository.save(staff);
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
