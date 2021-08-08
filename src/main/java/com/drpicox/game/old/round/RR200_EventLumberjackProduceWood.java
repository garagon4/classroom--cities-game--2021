package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventLumberjackProduceWood extends EachPlayerSquareRoundRule {

    public RR200_EventLumberjackProduceWood(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var events = allCards.atPile("event").ofType("event").ofName("forest");
        var workers = allCards.atSquare(oldPlayer, square).ofType("worker").ofName("lumberjack");
        events.forEach(event -> workers.forEach(farmer ->
                cardController.pickCard(oldPlayer, Positions.HAND, "material", "wood")
        ));
    }
}
