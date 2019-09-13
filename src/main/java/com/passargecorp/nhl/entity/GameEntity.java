package com.passargecorp.nhl.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class GameEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gameId;
    private TeamEntity awayTeam;
    private TeamEntity homeTeam;
    private StatusEntity status;
}
