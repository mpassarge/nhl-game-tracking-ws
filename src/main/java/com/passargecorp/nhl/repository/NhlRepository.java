package com.passargecorp.nhl.repository;

import com.passargecorp.nhl.dto.Game;
import com.passargecorp.nhl.dto.Schedule;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Log4j2
public class NhlRepository {

    private RestTemplate restTemplate;

    public NhlRepository(final RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    public Game getGame(final String gameId) {

        final String url = "https://statsapi.web.nhl.com/api/v1/schedule?gamePk=" + gameId;
        final Schedule schedule = restTemplate.getForObject(url, Schedule.class);

        log.info("Retrieved Schedule: {}", schedule);
        return new Game();
    }
}
