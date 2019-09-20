package com.passargecorp.nhl.util;

import com.passargecorp.nhl.entity.GameEntity;

public final class GameEntityValidators {

    public static boolean isGameEntityCacheable(final GameEntity gameEntity) {

        // game must be started to be able to track
        return gameEntity.getStatus().isGameFinal();
    }
}
