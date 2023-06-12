package ru.studentCoursework.ZverevIKBO2021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.studentCoursework.ZverevIKBO2021.services.StaffService;
import ru.studentCoursework.ZverevIKBO2021.models.Staff;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;


    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping()
    public List<Staff> getStaff() {
        return staffService.readAll();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getOne(@PathVariable("id") int id) {
        return staffService.read(id);
    }

    @PostMapping()
    public String saveStaff(@RequestBody Staff staff) {
        staffService.create(staff);
        return "200 OK";

    }

    @DeleteMapping("/{id}")
    public boolean deleteStaff(@PathVariable("id") int id) {
        return staffService.delete(id);
    }
}
