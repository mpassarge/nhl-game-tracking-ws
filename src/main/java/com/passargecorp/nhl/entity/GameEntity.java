package com.passargecorp.nhl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GameEntity {

    private String gameId;
    private TeamEntity awayTeam;
    private TeamEntity homeTeam;
    private StatusEntity status;
}
