package com.codehub.Repository;

import com.codehub.Entity.Post;
import com.codehub.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface sectionRepository extends JpaRepository<Section,Integer> {

}
