package com.lyhteixeirah.game_survey.repositories;

import com.lyhteixeirah.game_survey.entities.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
    

}
