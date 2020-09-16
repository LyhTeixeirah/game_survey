package com.lyhteixeirah.game_survey.services;

import java.time.Instant;

import com.lyhteixeirah.game_survey.dto.RecordDTO;
import com.lyhteixeirah.game_survey.dto.RecordInsertDTO;
import com.lyhteixeirah.game_survey.entities.Game;
import com.lyhteixeirah.game_survey.entities.Record;
import com.lyhteixeirah.game_survey.repositories.GameRepository;
import com.lyhteixeirah.game_survey.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordServices {
    
    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        
        /**
         * Spring Data JPA, 
         * .getOne --> instancia objeto, do tipo relacionado 
         * Ainda não vai no banco ele instancia so para referenciar
         * depois ele vai salvar
         */
        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);

        entity = repository.save(entity);
        return new RecordDTO(entity);
    }

}

