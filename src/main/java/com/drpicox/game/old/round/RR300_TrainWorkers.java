package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RR300_TrainWorkers extends EachPlayerRoundRule {

    public RR300_TrainWorkers(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayer(OldPlayer oldPlayer, CardListFilter<Card> allCards) {
        var scenario = oldPlayer.getGame().getScenario();
        var trainCards = allCards.atPile("train").ofOwner(oldPlayer);
        if (trainCards.isEmpty()) return;

        var combination = trainCards.stream()
                .map(c -> c.toSimpleString()).sorted()
                .collect(Collectors.joining(","));

        var mayKey = scenario.findKey("train.", ($, value) -> value.equals(combination));
        // if (mayKey.isEmpty()) return;

        var parts = mayKey.get().split("\\.");
        var type = parts[1];
        var name = parts[2];
        cardController.pickCard(oldPlayer, 0, type, name);
        trainCards.forEach(cardController::discardCard);
    }
}
