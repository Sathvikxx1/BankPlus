package me.pulsi_.bankplus.listeners;

import com.tcoded.folialib.wrapper.task.WrappedTask;
import me.pulsi_.bankplus.account.BPPlayer;
import me.pulsi_.bankplus.account.PlayerRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        BPPlayer player = PlayerRegistry.get(p);
        if (player == null) return;

        WrappedTask updating = player.getBankUpdatingTask();
        if (updating != null) updating.cancel();

        player.setOpenedBank(null);
    }
}