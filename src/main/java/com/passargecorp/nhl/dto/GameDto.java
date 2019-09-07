package com.passargecorp.nhl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class GameDto {

    private String gamePk;
    private TeamsDto teams;
}
