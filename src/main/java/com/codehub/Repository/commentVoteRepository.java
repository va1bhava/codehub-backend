package com.codehub.Repository;


import com.codehub.Entity.CommentVotes;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface commentVoteRepository extends JpaRepository<CommentVotes,Integer> {
    Optional<CommentVotes>findByComments_IdAndNickname(Integer commentID,String Nickname);
}
