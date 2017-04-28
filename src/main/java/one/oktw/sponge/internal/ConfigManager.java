package one.oktw.sponge.internal;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.text.title.Title;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static one.oktw.sponge.Core.getCore;

public class ConfigManager {
    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private ConfigurationNode node;

    public ConfigManager(Path privatePluginDir) {
        Path configPath = privatePluginDir.resolve("config.conf");
        loader = HoconConfigurationLoader.builder().setPath(configPath).build();
        Logger logger = getCore().getLogger();
        if (Files.exists(configPath)) {
            try {
                node = loader.load();
            } catch (IOException e) {
                logger.error("Load config failed!");
                logger.error(e.getMessage());
            }
        } else {
            logger.info("Creating new config file...");
            try {
                Files.createDirectories(privatePluginDir);
            } catch (IOException e) {
                logger.error("Can't create plugin config directory!");
                logger.error(e.getMessage());
            }
            try {
                getCore().getPlugin().getAsset("config.conf").get().copyToFile(configPath);
            } catch (IOException e) {
                logger.error("Can't create config.conf!");
                logger.error(e.getMessage());
            }
            try {
                node = loader.load();
            } catch (IOException e) {
                logger.error("Load config failed!");
                logger.error(e.getMessage());
            }
        }
    }

    public Title getTitle() {
        ConfigurationNode titleNode = node.getNode("Title");
        if (titleNode.getNode("enable").getBoolean()) {
            String title = titleNode.getNode("title").getString();
            String subtitle = titleNode.getNode("subtitle").getString();
            return Title.of(TextSerializers.FORMATTING_CODE.deserialize(title), TextSerializers.FORMATTING_CODE.deserialize(subtitle));
        } else {
            return Title.EMPTY;
        }
    }

    public Text getJoinMessage() {
        ConfigurationNode titleNode = node.getNode("JoinMessage");
        if (titleNode.getNode("enable").getBoolean()) {
            return TextSerializers.FORMATTING_CODE.deserialize(titleNode.getNode("message").getString());
        } else {
            return Text.EMPTY;
        }
    }

    public void reload() throws IOException {
        node = loader.load();
    }
}
