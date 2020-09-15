package com.lyhteixeirah.game_survey.repositories;

import com.lyhteixeirah.game_survey.entities.Record;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
    

}
