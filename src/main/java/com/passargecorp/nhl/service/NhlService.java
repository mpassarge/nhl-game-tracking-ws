package com.passargecorp.nhl.service;

import static com.passargecorp.nhl.entity.mapper.GameEntityMapper.gameEntityFromScheduleDTO;

import com.passargecorp.nhl.dto.ScheduleDto;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.repository.CacheRepository;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class NhlService {

    private static final String REDIS_KEY = "game-tracking";

    private final CacheRepository cacheRepository;
    private final NhlRepository nhlRepository;

    public GameEntity getGameById(final String gameId) {

        final GameEntity cachedGame = cacheRepository.get(gameId);

        if(cachedGame != null) {
            return cachedGame;
        }

        final GameEntity game = getEntityFromNhlRepository(gameId);
        cacheRepository.save(game);

        return game;
    }

    private void validateScheduleDto(final ScheduleDto scheduleDto) {

        Validate.isTrue(scheduleDto.getTotalItems() == 1, "Multiple events retrieved");
        Validate.isTrue(scheduleDto.getDates().get(0).getTotalItems() == 1,
                        "Multiple game retrieved");
    }

    private GameEntity getEntityFromNhlRepository(final String gameId) {

        final ScheduleDto scheduleDto = nhlRepository.getGame(gameId);
        validateScheduleDto(scheduleDto);
        return gameEntityFromScheduleDTO(scheduleDto);
    }
}