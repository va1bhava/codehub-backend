package com.codehub.Repository;

import com.codehub.Entity.PostVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface postVotesRepository extends JpaRepository<PostVotes,Integer> {
    Optional<PostVotes> findByPost_IdAndNickname(Integer postId, String Nickname);
    @Query("SELECT COALESCE(SUM(p.voteType),0) FROM PostVotes p WHERE p.post.id = :postId")
    Integer getPostVoteScore(Integer postId);
}
