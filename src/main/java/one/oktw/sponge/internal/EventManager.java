package one.oktw.sponge.internal;

import one.oktw.sponge.event.PlayerJoin;
import org.spongepowered.api.Sponge;

import static one.oktw.sponge.Core.getCore;

public class EventManager {
    private org.spongepowered.api.event.EventManager eventManager = Sponge.getEventManager();

    public EventManager() {
        eventManager.registerListeners(getCore(), new PlayerJoin());
    }
}
