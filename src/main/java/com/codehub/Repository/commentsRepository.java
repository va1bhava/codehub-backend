package com.codehub.Repository;

import com.codehub.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface commentsRepository extends JpaRepository<Comments,Integer> {
    List<Comments> findByPost_Id(Integer postId);
}
