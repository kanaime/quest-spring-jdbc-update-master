package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {

    @Autowired
    private SchoolRepository repository;

    @GetMapping("/school/update")
    public String getSchoolUpdate(Model model,
            @RequestParam Long id) {
        model.addAttribute("school", repository.findById(id).get());

        return "school_update";
    }

    @PostMapping("/school/update")
    public String postSchoolUpdate(Model model,
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam Long capacity,
            @RequestParam String country) {
        School school = repository.findById(id).get();
        school.setName(name);
        school.setCapacity(capacity);
        school.setCountry(country);

        model.addAttribute("school", repository.save(school));

        return "school_get";
    }
}
