package com.passargecorp.nhl.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passargecorp.nhl.entity.GameEntity;
import com.passargecorp.nhl.util.GameEntityValidators;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Log4j2
@Repository
@AllArgsConstructor
public class CacheRepository {

    private static final String REDIS_KEY = "game-tracking";

    private final Jedis jedis;
    private final ObjectMapper objectMapper;

    public GameEntity get(final String gameId) {

        final String gameString = getGameEntityFromCacheOrDefault(gameId);
        return transformGameEntity(gameString);
    }

    public void save(final GameEntity gameEntity) {

        if(GameEntityValidators.isGameEntityCacheable(gameEntity)) {
            saveGameEntity(gameEntity);
        }
    }

    private void saveGameEntity(final GameEntity gameEntity) {

        try {
            final String gameString = objectMapper.writeValueAsString(gameEntity);
            jedis.set(buildCacheKey(gameEntity.getGameId()), gameString);
        } catch(JsonProcessingException e) {
            log.error("Error serializing game entity", e);
        }
    }

    public void update(final GameEntity gameEntity) {}

    private GameEntity transformGameEntity(final String gameString) {

        try {
            return objectMapper.readValue(gameString, GameEntity.class);
        } catch(IOException e) {
            final String message = "Failed to transform GameEntity \"" + gameString + "\"";
            log.error(message, e);
        }
        return null;
    }

    private String getGameEntityFromCacheOrDefault(final String gameId) {

        final String gameString = jedis.get(buildCacheKey(gameId));
        if(gameString == null) {
            return "";
        }
        return gameString;
    }

    private String buildCacheKey(final String gameId) {

        return REDIS_KEY + "::" + gameId;
    }
}