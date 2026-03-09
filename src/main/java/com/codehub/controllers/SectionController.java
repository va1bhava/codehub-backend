package com.codehub.controllers;

import com.codehub.Entity.Post;
import com.codehub.Entity.Section;
import com.codehub.services.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codehub.services.sectionService;

import java.util.List;

@RestController

public class SectionController {
    private sectionService secService;
    private postService postservice;
    @Autowired
    private void SectionController(sectionService secService, postService postservice){
        this.secService=secService;
        this.postservice=postservice;
    }

    @GetMapping("/sections")
    public List<Section> getAllSections(){
        return secService.getAllSections();
    }

}
