package one.oktw.sponge.event;

import one.oktw.sponge.Core;
import one.oktw.sponge.util.WorldManager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import static one.oktw.sponge.Core.getCore;

public class OnPlayerJoin implements EventListener<ClientConnectionEvent.Join> {
    private Core core = getCore();
    private WorldManager worldManager = getCore().getWorldManager();

    @Override
    @NonnullByDefault
    public void handle(ClientConnectionEvent.Join event) throws Exception {
        Player player = event.getTargetEntity();
        if (!worldManager.checkExist(player.getUniqueId().toString())) {
            worldManager.createWorld(player.getUniqueId().toString());
        }
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
