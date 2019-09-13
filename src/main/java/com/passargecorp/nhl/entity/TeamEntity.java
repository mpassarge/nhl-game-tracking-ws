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
public class TeamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int score;
}