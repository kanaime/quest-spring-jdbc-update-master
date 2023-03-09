package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class WizardController {

    @Autowired
    private WizardRepository repository;

    @GetMapping("/wizard/update")
    public String getWizardUpdate(Model model,
            @RequestParam Long id) {

        model.addAttribute("wizard", repository.findById(id).get());

        return "wizard_update";
    }

    @PostMapping("/wizard/update")
    public String postWizardUpdate(Model model,
            @RequestParam Long id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Date birthday,
            @RequestParam String birthPlace,
            @RequestParam(required = false, defaultValue = "") String biography,
            @RequestParam(required = false, defaultValue = "false") boolean muggle) {
        Wizard wizard = repository.findById(id).get();

        wizard.setFirstName(firstName);
        wizard.setLastName(lastName);
        wizard.setBirthday(birthday);
        wizard.setBirthPlace(birthPlace);
        wizard.setBiography(biography);
        wizard.setMuggle(muggle);
        model.addAttribute("wizard", repository.save(wizard));

        return "wizard_get";
    }
}
