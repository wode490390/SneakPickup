package cn.wode490390.nukkit.sneakpickup;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryPickupArrowEvent;
import cn.nukkit.event.inventory.InventoryPickupItemEvent;
import cn.nukkit.plugin.PluginBase;

public class SneakPickup extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        try {
            new MetricsLite(this);
        } catch (Exception ignore) {

        }
    }

    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        Player player = (Player) event.getInventory().getHolder();
        if (!player.hasPermission("sneakpickup.whitelist") && !player.isSneaking()) {
            event.setCancelled();
        }
    }

    @EventHandler
    public void onInventoryPickupArrow(InventoryPickupArrowEvent event) {
        Player player = (Player) event.getInventory().getHolder();
        if (!player.hasPermission("sneakpickup.whitelist") && !player.isSneaking()) {
            event.setCancelled();
        }
    }
}
