package com.passargecorp.nhl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class GameEntity {

    private String gameId;
    private TeamEntity awayTeam;
    private TeamEntity homeTeam;
    private StatusEntity status;
}
