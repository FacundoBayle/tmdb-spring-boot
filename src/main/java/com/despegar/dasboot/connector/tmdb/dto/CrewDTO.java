package com.despegar.dasboot.connector.tmdb.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CrewDTO {
    private Long id;
    private String job;
    private String name;
    private String profilePath;

    @JsonCreator
    public CrewDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("job") String job,
            @JsonProperty("name") String name,
            @JsonProperty("profile_path") String profilePath) {
        this.id = id;
        this.job = job;
        this.name = name;
        this.profilePath = profilePath;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
