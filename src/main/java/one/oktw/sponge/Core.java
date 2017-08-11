package one.oktw.sponge;

import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import one.oktw.sponge.internal.*;
import org.slf4j.Logger;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.IOException;
import java.nio.file.Path;

@Plugin(id = "oktwcore", name = "OKTW_Core", version = "1.0.0")
public class Core {
    private static Core core;

    @Inject
    private Logger logger;

    @Inject
    @DefaultConfig(sharedRoot = false)
    private ConfigurationLoader<CommentedConfigurationNode> configLoader;

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path privatePluginDir;

    @Inject
    private PluginContainer plugin;

    private CommandManager commandManager;
    private ConfigManager configManager;
    private DatabaseManager databaseManager;
    private EventManager eventManager;
    private WorldManager worldManager;

    public static Core getCore() {
        return core;
    }

    @Listener
    public void construct(GameConstructionEvent event) {
        core = this;
    }

    @Listener
    public void onInit(GameInitializationEvent event) {
        logger.info("Loading...");
        commandManager = new CommandManager();
        configManager = new ConfigManager(configLoader);
        databaseManager = new DatabaseManager();
        eventManager = new EventManager();
        worldManager = new WorldManager();
        logger.info("Plugin loaded!");
    }

    @Listener
    public void onReload(GameReloadEvent event) throws IOException {
        //TODO
    }

    public Logger getLogger() {
        return logger;
    }

    public PluginContainer getPlugin() {
        return plugin;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}