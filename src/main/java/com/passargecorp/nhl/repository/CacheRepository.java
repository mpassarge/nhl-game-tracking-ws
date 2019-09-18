package com.passargecorp.nhl.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.exception.GameTrackingException;
import java.io.IOException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Log4j2
@Repository
@AllArgsConstructor
public class CacheRepository {

    private static final String REDIS_KEY = "game-tracking";

    private final Jedis jedis;
    private final ObjectMapper objectMapper;

    public void save(final GameEntity gameEntity) {

        if(!gameEntity.getStatus().isGameFinal()) {
            try {
                final String gameString = objectMapper.writeValueAsString(gameEntity);
                jedis.set(buildCacheKey(gameEntity.getGameId()), gameString);
            } catch(JsonProcessingException e) {
                log.error("Error serializing game entity", e);
                throw new GameTrackingException("Error serializing game entity");
            }
        }
    }

    public void update(final GameEntity gameEntity) {}

    public Optional<GameEntity> get(final String gameId) {

        GameEntity gameEntity = null;
        final String gameString = jedis.get(buildCacheKey(gameId));

        if(StringUtils.isBlank(gameString)) {
            return Optional.empty();
        }

        try {
            gameEntity = objectMapper.readValue(gameString, GameEntity.class);
        } catch(IOException e) {
            log.error("Failed to transform cache string into class", e);
        }
        return Optional.ofNullable(gameEntity);
    }

    private String buildCacheKey(final String gameId) {

        return REDIS_KEY + "::" + gameId;
    }
}
