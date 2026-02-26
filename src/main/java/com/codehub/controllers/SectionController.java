package com.codehub.controllers;

import com.codehub.Entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codehub.services.sectionService;

import java.util.List;

@RestController

public class SectionController {
    @Autowired
    private sectionService secService;

    @GetMapping("/sections")
    public List<Section> getAllSections(){
        return secService.getAllSections();
    }
}
