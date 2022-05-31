package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    final Main main;

    public QuitListener(Main main) {

        this.main = main;

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage("§7[§c-§7] " + player.getName());

        if (player.isOp() && !main.getConfig().getStringList("security.whitlist-op").contains(player.getName())) {
            player.setOp(false);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-op").replace("<player>", player.getName()));
        }

        if (player.getGameMode() == GameMode.CREATIVE && !main.getConfig().getStringList("security.whitlist-op").contains(player.getName())) {
            player.setGameMode(GameMode.SURVIVAL);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-gm").replace("<player>", player.getName()));
        }

    }

}
