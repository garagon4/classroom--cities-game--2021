package com.drpicox.game.testMocks;

import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.RandomPlayerPicker;
import com.drpicox.game.testPost.AfterPostTest;
import com.drpicox.game.testPost.BeforePostTest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

@Component
public class RandomPlayerPickerMock extends RandomPlayerPicker implements BeforePostTest, AfterPostTest {

    private final List<String> cheats = new LinkedList<>();

    public RandomPlayerPickerMock() {
        super(new Random(0));
    }

    public void beforePostTest() {
        cheats.clear();
    }

    public void afterPostTest() {
        assertThat(cheats).isEmpty();
    }

    @Override
    public OldPlayer pickOne(List<OldPlayer> oldPlayers) {
        if (cheats.isEmpty()) return super.pickOne(oldPlayers);

        var name = cheats.remove(0);
        var player = oldPlayers.stream().filter(p -> p.getName().equals(name)).findAny().orElse(null);
        if (player == null)
            throw new AssertionError(
                    "Cheating player '"+name+
                            "' does not work because that player is not in the pick list: "+
                            oldPlayers.stream().map(p -> p.getName()).collect(Collectors.toList())
            );

        return player;
    }

    public void cheatPick(String player) {
        this.cheats.add(player);
    }
}
