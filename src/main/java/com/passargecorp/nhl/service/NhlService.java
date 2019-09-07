package com.passargecorp.nhl.service;

import com.passargecorp.nhl.entity.Game;
import com.passargecorp.nhl.repository.NhlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@AllArgsConstructor
@Service
public class NhlService {

    private NhlRepository nhlRepository;

    public Game getGameById(final String gameId) {

        nhlRepository.getGame(gameId);
        return new Game();
    }
}