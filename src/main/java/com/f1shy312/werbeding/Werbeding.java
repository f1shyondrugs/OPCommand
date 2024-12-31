package com.f1shy312.werbeding;

import com.f1shy312.werbeding.commands.OpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Werbeding extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        
        getCommand("op").setExecutor(new OpCommand(getConfig()));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
