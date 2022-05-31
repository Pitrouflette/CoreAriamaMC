package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class AppleGold implements Listener {

    @EventHandler
    public void onInterract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(p.getItemInHand().getType() == Material.GOLDEN_APPLE){
            if(!Main.cooldown.containsKey(p.getUniqueId())){
                e.setCancelled(true);
                p.sendMessage("§6§lManger votre pomme");
                Main.cooldown.put(p.getUniqueId(), Integer.valueOf(300));
            }else {
                p.sendMessage("§6§lTu ne peux pas manger ta pomme");
            }
        }
    }
}
