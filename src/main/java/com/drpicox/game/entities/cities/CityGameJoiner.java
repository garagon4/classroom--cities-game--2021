package com.drpicox.game.entities.cities;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.entities.buildings.BuildingBuilderFactory;
import com.drpicox.game.entities.ships.ShipFactory;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class CityGameJoiner implements GameJoiner {

    private final CityFactory cityFactory;
    private final ShipFactory shipFactory;
    private final BuildingBuilderFactory buildingBuilderFactory;
    private final LocatedsController locatedsController;

    public CityGameJoiner(CityFactory cityFactory, ShipFactory shipFactory, BuildingBuilderFactory buildingBuilderFactory, LocatedsController locatedsController) {
        this.cityFactory = cityFactory;
        this.shipFactory = shipFactory;
        this.buildingBuilderFactory = buildingBuilderFactory;
        this.locatedsController = locatedsController;
    }

    @Override
    public void joinGame(Player owner) {
        var initialName = "Capital";
        int initialPopulation = 10;

        var cityId = cityFactory.buildCity(owner, initialName, initialPopulation);
        var initialLocation = locatedsController.getLocation(cityId);

        buildingBuilderFactory.buildBuildingBuilder(cityId);
        shipFactory.buildShip(owner, cityId, "Beagle", initialLocation);
    }
}
