package com.f1shy312.werbeding.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class OpCommand implements CommandExecutor {
    private final FileConfiguration config;

    public OpCommand(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDieser Befehl kann nur von Spielern verwendet werden!");
            return true;
        }

        Player player = (Player) sender;
        String playerUUID = player.getUniqueId().toString();

        if (config.getBoolean("claimed." + playerUUID, false)) {
            player.sendMessage("§cDu hast deine Belohnung bereits erhalten!");
            return true;
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco add " + player.getName() + " 10000");
        
        config.set("claimed." + playerUUID, true);
        
        player.sendTitle("§a+10000$", "", 10, 70, 20);
        player.sendMessage("§aErfolgreich 10.000 Dollar erhalten!");
        return true;
    }
} 