package fr.childish.coreariama.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class HealStick implements Listener {

    @EventHandler
    public  void  onInterract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack itm = e.getItem();

        if(itm == null) return;

        if((p.getGameMode().equals(GameMode.SURVIVAL)) &&
        p.getItemInHand().getType() == Material.STICK &&
        p.getItemInHand().getItemMeta().hasDisplayName() &&
        p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lHealStick")){

            if(p.getHealth() + 10.0D >= 20.0D){
                p.setHealth(20.0D);
            }else {
                p.setHealth(p.getHealth() + 10.0D);
            }
        }
    }

}
