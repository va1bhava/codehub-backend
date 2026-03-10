package com.codehub.Repository;

import com.codehub.Entity.PostVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface postVotesRepository extends JpaRepository<PostVotes,Integer> {
    Optional<PostVotes> findByPostIdAndNickname(Integer postId, String Nickname);
}
