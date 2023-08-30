package com.AutoMarketdatabase.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class AutoController {

    @Autowired
    AutoRepository autoRepository;

    @GetMapping("")
    public List<Auto> getAll() {
        return autoRepository.getAll();
    }

    @GetMapping("/{id}")
    public Auto getById(@PathVariable("id") int id) {
        return autoRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Auto> cars) {
        return autoRepository.save(cars);
    }
}
