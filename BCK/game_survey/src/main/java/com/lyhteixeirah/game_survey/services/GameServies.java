package com.lyhteixeirah.game_survey.services;

import java.util.List;
import java.util.stream.Collectors;

import com.lyhteixeirah.game_survey.dto.GameDto;
import com.lyhteixeirah.game_survey.entities.Game;
import com.lyhteixeirah.game_survey.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameServies {
    
    @Autowired
    private GameRepository repository;

    /**
     * Nivel de bloqueio baixo readOnly evitar o locking do banco
     */
    @Transactional(readOnly = true)
    public List<GameDto> findAll(){
        List<Game> games = repository.findAll();
        return games.stream().map(x -> new GameDto(x)).collect(Collectors.toList());
    }
}
