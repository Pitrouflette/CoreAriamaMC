package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class TeleportPadEvent implements Listener {

    final Main main;

    public TeleportPadEvent(Main main) {

        this.main = main;

    }

    @EventHandler
    public void onJump(PlayerMoveEvent ev) {
        Player player = ev.getPlayer();
        if (ev.getTo().getY() > ev.getFrom().getY() && player.isOnline()) {
            Location loc = player.getLocation();
            Block block = loc.add(0, -1, 0).getBlock();
            if(block.getType().equals(Material.NOTE_BLOCK)){
                block = block.getLocation().add(0, 1, 0).getBlock();
                while (block.getY() < 256 && !block.getType().equals(Material.NOTE_BLOCK)){
                    block = block.getLocation().add(0, 1, 0).getBlock();
                }
                if(block.getType().equals(Material.NOTE_BLOCK)){
                    if(main.getConfig().getBoolean("teleportpad.status.allow")){
                        Location teleportLoc = block.getLocation().add(0.5, 1.1, 0.5);
                        teleportLoc.setPitch(loc.getPitch());
                        teleportLoc.setYaw(loc.getYaw());
                        player.teleport(teleportLoc);
                        player.playSound(loc, Sound.ENDERMAN_TELEPORT, 3.0f, 0.5f);
                    }else{
                        ev.getPlayer().sendMessage(main.getConfig().getString("teleportpad.status.deny").replace("&", "§"));
                    }
                }else{
                    if(main.getConfig().getBoolean("teleportpad.status.allow")){
                        player.sendMessage(main.getConfig().getString("messages.teleportpad.teleportpaddeny").replace("&", "§"));
                    }else{
                        ev.getPlayer().sendMessage(main.getConfig().getString("teleportpad.status.deny").replace("&", "§"));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent ev) {
        Player player = ev.getPlayer();
        if (ev.isSneaking() && player.isOnline()) {
            Location loc = player.getLocation();
            Block block = loc.add(0, -1, 0).getBlock();
            if(block.getType().equals(Material.NOTE_BLOCK)){
                block = block.getLocation().add(0, -1, 0).getBlock();
                while (block.getY() > 0 && !block.getType().equals(Material.NOTE_BLOCK)){
                    block = block.getLocation().add(0, -1, 0).getBlock();
                }

                if(block.getType().equals(Material.NOTE_BLOCK)){
                    if(main.getConfig().getBoolean("teleportpad.status.allow")){
                        Location teleportLoc = block.getLocation().add(0.5, 1.1, 0.5);
                        teleportLoc.setPitch(loc.getPitch());
                        teleportLoc.setYaw(loc.getYaw());
                        player.teleport(teleportLoc);
                    }else{
                        ev.getPlayer().sendMessage(main.getConfig().getString("teleportpad.status.deny").replace("&", "§"));
                    }
                }else{
                    if(main.getConfig().getBoolean("teleportpad.status.allow")){
                        player.sendMessage(main.getConfig().getString("messages.teleportpad.teleportpaddeny").replace("&", "§"));
                    }else{
                        ev.getPlayer().sendMessage(main.getConfig().getString("teleportpad.status.deny").replace("&", "§"));
                    }
                }
            }
        }
    }
}
