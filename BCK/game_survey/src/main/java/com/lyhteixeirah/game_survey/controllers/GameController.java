package com.lyhteixeirah.game_survey.controllers;

import java.util.List;

import com.lyhteixeirah.game_survey.dto.GameDto;
import com.lyhteixeirah.game_survey.services.GameServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    /**Teste
     * Injeção de dependencia
     */

    @Autowired
    private GameServices service; 
   

    @GetMapping()
    public ResponseEntity<List<GameDto>> findAll() {
        List<GameDto> games = service.findAll();
        return ResponseEntity.ok().body(games);
    }
}

