package com.lyhteixeirah.game_survey.dto;

import java.io.Serializable;
import java.time.Instant;

import com.lyhteixeirah.game_survey.entities.Record;
import com.lyhteixeirah.game_survey.entities.enums.Platform;

public class RecordDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public RecordDTO() {}
    
    public RecordDTO(Record entity) {
        id = entity.getId();
        moment = entity.getMoment();
        name = entity.getName();
        age = entity.getAge();

        gameTitle = entity.getGame().getTitle();
        gamePlatform = entity.getGame().getPlatform();
        genreName = entity.getGame().getGenre().getName();

    }

    

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param moment the moment to set
     */
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return String return the gameTitle
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * @param gameTitle the gameTitle to set
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * @return Platform return the gamePlatform
     */
    public Platform getGamePlatform() {
        return gamePlatform;
    }

    /**
     * @param gamePlatform the gamePlatform to set
     */
    public void setGamePlatform(Platform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    /**
     * @return String return the genreName
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * @param genreName the genreName to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}
