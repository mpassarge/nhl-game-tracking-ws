package com.passargecorp.nhl.entity.mapper;

import com.passargecorp.nhl.dto.GameDto;
import com.passargecorp.nhl.dto.ScheduleDto;
import com.passargecorp.nhl.dto.StatusDto;
import com.passargecorp.nhl.dto.TeamDto;
import com.passargecorp.nhl.dto.TeamsDto;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.entity.StatusEntity;
import com.passargecorp.nhl.entity.TeamEntity;

public final class GameEntityMapper {

    public static GameEntity gameEntityFromScheduleDTO(final ScheduleDto schedule) {

        final GameDto game = schedule.getDates().get(0).getGames().get(0);
        final TeamsDto teams = game.getTeams();

        new StatusEntity(game.getStatus().getDetailedState());
        return new GameEntity(game.getGamePk(), teamEntityFromTeamDTO(teams.getAway()),
                              teamEntityFromTeamDTO(teams.getHome()),
                              statusEntityFromStatusDTO(game.getStatus()));
    }

    private static TeamEntity teamEntityFromTeamDTO(final TeamDto team) {

        return new TeamEntity(team.getId(), team.getName(), team.getScore());
    }

    private static StatusEntity statusEntityFromStatusDTO(final StatusDto status) {

        return new StatusEntity(status.getDetailedState());
    }
}
