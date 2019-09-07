package com.passargecorp.nhl.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class GameDateDto {

    private int totalItems;
    private List<GameDto> games;
}
