package com.lyhteixeirah.game_survey.repositories;

import com.lyhteixeirah.game_survey.entities.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Poderiamos ter usado @Component mas vamos seguir a semantica
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
    


}
