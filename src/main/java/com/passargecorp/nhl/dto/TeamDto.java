package com.passargecorp.nhl.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.passargecorp.nhl.util.TeamDeserialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@JsonDeserialize(using = TeamDeserialization.class)
@NoArgsConstructor
@ToString
public class TeamDto {

    private int id;
    private String name;
    private int score;
}
