package com.drpicox.game.games.api;

import com.drpicox.game.ecs.ComponentResponse;
import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.games.Game;

import java.util.*;
import java.util.stream.Stream;

public class GameResponse {
    private String gameName;
    private String creatorName;
    private String playerName;
    private String token;
    private int roundNumber;
    private Map<String, EntityResponse> entities = new LinkedHashMap<>();

    public GameResponse(Game game, String playerName, String token) {
        this.gameName = game.getGameName();
        this.creatorName = game.getCreator().getPlayerName();
        this.roundNumber = game.getRoundNumber();
        this.playerName = playerName;
        this.token = token;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getToken() {
        return this.token;
    }

    public void addEntity(EntityResponse entityResponse) {
        entities.put(entityResponse.getId(), entityResponse);
    }

    public Stream<EntityResponse> streamEntities() {
        return entities.values().stream();
    }

    public Optional<EntityResponse> findEntityById(String id) {
        return Optional.ofNullable(entities.get(id));
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public <T extends EntityResponse> T getEntityResponse(String id) {
        return (T) findEntityById(id).get();
    }

    public void addComponent(ComponentResponse componentResponse) {
        var id = componentResponse.getId();
        var entity = entities.get(id);
        if (entity == null) {
            entity = new EntityResponse(id);
            entities.put(id, entity);
        }
        entity.addComponent(componentResponse);
    }
}
