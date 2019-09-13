package com.passargecorp.nhl.service;

import com.passargecorp.nhl.dto.ScheduleDto;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.entity.mapper.GameEntityMapper;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.Validate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class NhlService {

    private NhlRepository nhlRepository;

    @Cacheable(cacheNames = "game-tracking", key = "#gameId", unless = "#result == null")
    public GameEntity getGameById(final String gameId) {

        final ScheduleDto scheduleDto = nhlRepository.getGame(gameId);
        validateScheduleDto(scheduleDto);
        final GameEntity game = GameEntityMapper.gameEntityFromScheduleDTO(scheduleDto);
        log.info("{}", game);

        return game;
    }

    private void validateScheduleDto(final ScheduleDto scheduleDto) {

        Validate.isTrue(scheduleDto.getTotalItems() == 1, "Multiple events retrieved");
        Validate.isTrue(scheduleDto.getDates().get(0).getTotalItems() == 1,
                        "Multiple game retrieved");
    }
}