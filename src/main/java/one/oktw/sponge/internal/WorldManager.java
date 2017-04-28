package one.oktw.sponge.internal;

import one.oktw.sponge.Core;
import org.slf4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;

import static one.oktw.sponge.Core.getCore;

public class WorldManager {
    private Core core = getCore();
    private Logger logger = core.getLogger();
    private Server server = Sponge.getServer();

//    public void createWorld(String name) {
//        logger.info("Create World: " + name);
//        try {
//            WorldProperties worldProperties = server.createWorldProperties(name, WorldArchetype.builder()
//                    .keepsSpawnLoaded(false)
//                    .enabled(true)
//                    .generateSpawnOnLoad(false)
//                    .loadsOnStartup(false)
//                    .randomSeed()
//                    .build(name, name)
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean checkExist(String name) {
//        return server.getWorldProperties(name).isPresent();
//    }
//
//    public Collection<WorldProperties> listWorld() {
//        //TODO
//    }
}
