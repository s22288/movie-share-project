package com.example.movieshare.repositories;

import com.example.movieshare.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Rating,Long> {

}
