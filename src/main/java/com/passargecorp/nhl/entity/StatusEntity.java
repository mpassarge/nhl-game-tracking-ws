package com.passargecorp.nhl.entity;

import static org.apache.commons.lang3.StringUtils.startsWith;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class StatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String state;

    public boolean isGameFinal() {

        return "Final".equals(state);
    }

    public boolean isGameInProgress() {

        return startsWith(state, "In Progress");
    }
}