package edu.jhu.fcriscu1.immutables;

import org.immutables.value.Value;

/**
 * Created by fcriscuolo on 4/19/16.
 */
public abstract class PlayerInfo {

    @Value.Parameter
    public abstract long id();

    @Value.Default
    public String name() {
        return "Anonymous_" + id();
    }

    @Value.Default
    public int gamesPlayed() {
        return 0;
    }
}
