package com.passargecorp.nhl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {

    private int id;
    private String name;
    private int score;
}