package com.lyhteixeirah.game_survey.controllers;

import java.io.Serializable;

import com.lyhteixeirah.game_survey.dto.RecordDTO;
import com.lyhteixeirah.game_survey.dto.RecordInsertDTO;
import com.lyhteixeirah.game_survey.services.RecordServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

 
    @Autowired
    private RecordServices service; 
   

    @PostMapping()
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        RecordDTO record = service.insert(dto);
        return ResponseEntity.ok().body(record);
    }
}


