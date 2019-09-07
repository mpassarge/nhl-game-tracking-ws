package com.passargecorp.nhl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class TeamsDto {

    private TeamDto away;
    private TeamDto home;
}
