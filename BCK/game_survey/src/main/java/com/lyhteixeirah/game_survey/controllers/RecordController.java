package com.lyhteixeirah.game_survey.controllers;

import java.time.Instant;

import com.lyhteixeirah.game_survey.dto.RecordDTO;
import com.lyhteixeirah.game_survey.dto.RecordInsertDTO;
import com.lyhteixeirah.game_survey.services.RecordServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping()
    public ResponseEntity<Page<RecordDTO>> findAll(
        @RequestParam(value = "min", defaultValue = "") String min,
        @RequestParam(value = "max", defaultValue = "") String max,

        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,

        @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
        @RequestParam(value = "direction", defaultValue = "DESC") String direction
        ) {

            /**
             * convert String para Instant
             * Ternario para verificar se null ou parse
             * 
             */
            Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
            Instant maxDate = ("".equals(min)) ? null : Instant.parse(max);

            if(linesPerPage == 0) {
                linesPerPage = Integer.MAX_VALUE;
            }
        
            PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

            Page<RecordDTO> record = service.findByMoments(minDate, maxDate, pageRequest);
            return ResponseEntity.ok().body(record);
        }
    }
