package com.passargecorp.nhl.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.passargecorp.nhl.dto.Team;
import java.io.IOException;

public class TeamDeserialization extends StdDeserializer {

    TeamDeserialization() {

        this(null);
    }

    TeamDeserialization(Class<?> vc) {

        super(vc);
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext context)
            throws IOException, JsonProcessingException {

        final JsonNode teamNode = p.getCodec().readTree(p);
        final JsonNode team = teamNode.get("team");

        final int score = teamNode.get("score").asInt();
        final int teamId = team.get("id").asInt();
        final String teamName = team.get("name").asText();

        return new Team(teamId, teamName, score);
    }
}
