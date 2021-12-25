package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InteractCarteInvListener implements Listener {

    @EventHandler
    public void onClickInv(InventoryClickEvent ev){
        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();

        if(current == null) return;

        if(ev.getView().getTitle().contains("Carte")){
            if (current.getType().equals(Material.LEATHER)){

                player.chat("/home base");
                ev.setCancelled(true);

            }
            if (current.getItemMeta().getDisplayName().contains("§bSpawn")) {

                player.chat("/spawn");
                ev.setCancelled(true);

            }
            if (current.getItemMeta().getDisplayName().contains("§bWarZone")) {

                player.chat("/warzone");
                ev.setCancelled(true);

            }
            if (current.getItemMeta().getDisplayName().contains("§bBedWar")){

                player.chat("/tuto");
                ev.setCancelled(true);

            }
        }
    }
}
