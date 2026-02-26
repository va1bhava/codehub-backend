package com.codehub.Repository;
import com.codehub.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface postRepository extends JpaRepository<Post,Integer> {
    List<Post> findBySection_Id(Integer sectionId);

    Optional<Post> findById(int id);
}
