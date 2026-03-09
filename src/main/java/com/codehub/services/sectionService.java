package com.codehub.services;
import com.codehub.Entity.Post;
import com.codehub.Entity.Section;
import com.codehub.Exception.ResourceNotFound;
import com.codehub.Repository.sectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class sectionService {
    private sectionRepository sectionRepo;
    @Autowired
     public  sectionService(sectionRepository sectionRepo){

        this.sectionRepo=sectionRepo;
    }
    public List<Section>getAllSections(){

        return sectionRepo.findAll();
    }
    public Section getSectionbyId(Integer id){
        return sectionRepo.findById(id).orElseThrow(()->new ResourceNotFound("Unable to find the Section!!"));
    }

}
