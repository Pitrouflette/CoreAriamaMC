package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class ProtectOpGM implements Listener {

    final Main main;

    public ProtectOpGM(Main main) {

        this.main = main;

    }

    @EventHandler(
            priority = EventPriority.HIGH,
            ignoreCancelled = true
    )
    private void onCommandDisabled(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        main.getConfig().getStringList("security.blocked-commands").forEach((command) -> {
            if (event.getMessage().equalsIgnoreCase(command) && !main.getConfig().getStringList("security.whitlist-commands").contains(player.getName())) {
                event.setCancelled(true);
                player.sendMessage(main.getConfig().getString("security.messages.command-blocked-message").replace("&", "§"));
            }
        });
    }

    @EventHandler
    public void onOPBlocked(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        String[] args = event.getMessage().split(" ");
        Player player = event.getPlayer();
        if (args.length != 1) {
            main.getConfig().getStringList("security.commands-op").forEach((commands) -> {
                if (args.length >= 1 && message.startsWith(commands)) {
                    String playerName = args[1];
                    if (!main.getConfig().getStringList("security.whitlist-op").contains(playerName)) {
                        event.setCancelled(true);
                        player.sendMessage(main.getConfig().getString("security.messages.oped-blocked-message"));
                        if (Bukkit.getPlayer(playerName) != null) {
                            Bukkit.getPlayer(playerName).setOp(false);
                        }

                        main.getServer().getScheduler().scheduleSyncDelayedTask(main, () -> {
                            if (Bukkit.getPlayer(playerName) != null && Bukkit.getPlayer(playerName).isOp()) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-op").replace("<player>", playerName));
                            }

                        }, 20L);
                    }
                }
            });
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.isOp() && !main.getConfig().getStringList("security.whitlist-op").contains(player.getName())) {
            player.setOp(false);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-op").replace("<player>", player.getName()));
        }

        if (player.getGameMode() == GameMode.CREATIVE && !main.getConfig().getStringList("security.whitlist-gm").contains(player.getName())) {
            player.setGameMode(GameMode.SURVIVAL);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-gm").replace("<player>", player.getName()));
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = event.getNewGameMode();
        if (!main.getConfig().getStringList("security.whitlist-gm").contains(player.getName())) {
            event.setCancelled(true);
            if (gameMode == GameMode.CREATIVE) {
                player.setGameMode(GameMode.SURVIVAL);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), main.getConfig().getString("security.punish-hack-try-gm").replace("<player>", player.getName()));
            }
            player.sendMessage(main.getConfig().getString("security.messages.gm-blocked").replace("&", "§"));
        }
    }
}