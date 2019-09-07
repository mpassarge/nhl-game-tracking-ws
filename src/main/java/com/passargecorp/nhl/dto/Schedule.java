package com.passargecorp.nhl.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@JsonAutoDetect
@NoArgsConstructor
@ToString
public class Schedule {

    private int totalItems;
    private List<GameDate> dates;
}
