package dev.orhidea.playerchunkfix.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.logging.Level;

public class PlayerMoveListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerMoveEvent(PlayerMoveEvent playerMoveEvent){
        Location toLocation = playerMoveEvent.getTo();
        if (toLocation == null){
            return;
        }
        Chunk chunk = toLocation.getChunk();
        if (toLocation.getWorld() == null){
            return;
        }
        if(!chunk.isLoaded() || !toLocation.getWorld().isChunkLoaded(chunk)){
            playerMoveEvent.setCancelled(true);
            Bukkit.getLogger().log(Level.INFO, playerMoveEvent.getPlayer().getName() + "Tried to move in unloaded chunk");
        }
    }
}
