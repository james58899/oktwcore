package one.oktw.sponge.internal;

import one.oktw.sponge.event.PlayerJoin;
import org.spongepowered.api.Sponge;

import static one.oktw.sponge.Core.getCore;

public class EventManager {

    public EventManager() {
        org.spongepowered.api.event.EventManager eventManager = Sponge.getEventManager();

        eventManager.registerListeners(getCore(), new PlayerJoin());
    }
}
