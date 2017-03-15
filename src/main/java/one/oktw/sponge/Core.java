package one.oktw.sponge;

import com.google.inject.Inject;
import one.oktw.sponge.event.OnPlayerJoin;
import one.oktw.sponge.util.WorldManager;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Plugin(id = "oktwcore", name = "OKTW_Core", version = "1.0")
public class Core {
    private static Core core;

    @Inject
    private Logger logger;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path defaultConfig;

    private WorldManager worldManager;

    public static Core getCore() {
        return core;
    }

    @Listener
    public void construct(GameConstructionEvent event) {
        core = this;
    }

    @Listener
    public void onInit(GameInitializationEvent event) throws IOException {
        logger.info("Loading...");
        worldManager = new WorldManager();
        registerListeners();
        registerCommand();
        if (Files.notExists(defaultConfig)) {
            Sponge.getAssetManager().getAsset("oktwcore.conf").orElseThrow(FileNotFoundException::new).copyToFile(defaultConfig);
        }
        logger.info("Plugin Loaded!");
    }

    private void registerListeners() {
        EventManager eventManager = Sponge.getEventManager();
        eventManager.registerListener(this, ClientConnectionEvent.Join.class, new OnPlayerJoin());
    }

    private void registerCommand() {
        //TODO
    }

    public Logger getLogger() {
        return logger;
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }
}
