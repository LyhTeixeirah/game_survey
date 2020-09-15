package com.lyhteixeirah.game_survey.repositories;

import com.lyhteixeirah.game_survey.entities.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    

}
