package fr.geekschool.pluginarena.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("§7[§a+§7]" + event.getPlayer().getName());


        //String titel1 = "§c§l☬ §6§lAvariaMC§c§l ☬";
        //String titel2 = "§ePvP-Faction §6§lFarm2Win";

        //player.sendTitle(titel1, titel2);

    }
}