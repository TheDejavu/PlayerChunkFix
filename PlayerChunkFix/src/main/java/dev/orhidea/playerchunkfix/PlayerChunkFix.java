package dev.orhidea.playerchunkfix;

import dev.orhidea.playerchunkfix.listeners.PlayerMoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerChunkFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }
}
