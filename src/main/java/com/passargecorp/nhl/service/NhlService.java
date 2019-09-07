package com.passargecorp.nhl.service;

import com.passargecorp.nhl.dto.ScheduleDto;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.entity.mapper.GameEntityMapper;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class NhlService {

    private NhlRepository nhlRepository;

    public GameEntity getGameById(final String gameId) {

        final ScheduleDto scheduleDto = nhlRepository.getGame(gameId);
        // TODO: Validations on schedule DTO(only 1 game available, etc...)
        final GameEntity game = GameEntityMapper.gameEntityFromScheduleDTO(scheduleDto);
        // TODO: Validation on Game Entity(status is inprogress)
        log.info("{}", game);
        return game;
    }
}