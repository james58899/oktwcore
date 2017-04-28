package one.oktw.sponge.event;

import one.oktw.sponge.Core;
import one.oktw.sponge.internal.ConfigManager;
import one.oktw.sponge.internal.WorldManager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import static one.oktw.sponge.Core.getCore;

public class OnPlayerJoin {
    private Core core = getCore();
    private ConfigManager config = core.getConfigManager();
    private WorldManager worldManager = getCore().getWorldManager();

    @Listener
    public void onPlayerJoin(ClientConnectionEvent.Join event) throws Exception {
        Player player = event.getTargetEntity();
        player.sendTitle(config.getTitle());
        player.sendMessage(config.getJoinMessage());

//        if (!worldManager.checkExist(player.getUniqueId().toString())) {
//            worldManager.createWorld(player.getUniqueId().toString());
//        }
//
//        Inventory chest = Inventory.builder()
//                .of(InventoryArchetypes.CHEST)
//                .withCarrier(player)
//                .property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(Text.of("Test")))
//                .property(InventoryDimension.PROPERTY_NAME, InventoryDimension.of(9, 3))
//                .listener(ClickInventoryEvent.class, new Listener())
//                .build(core);
//        chest.offer(ItemStack.of(ItemTypes.APPLE, 314));
//        player.openInventory(chest, Cause.source(core).build());
//    }
//
//    private class Listener implements Consumer<ClickInventoryEvent> {
//
//        @Override
//        public void accept(ClickInventoryEvent clickInventoryEvent) {
//            clickInventoryEvent.setCancelled(true);
//            core.getLogger().info(clickInventoryEvent.toString());
//        }
    }
}
