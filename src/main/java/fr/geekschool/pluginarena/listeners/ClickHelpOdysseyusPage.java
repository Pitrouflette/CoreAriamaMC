package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickHelpOdysseyusPage implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();

        if(current == null) return;

        if(ev.getView().getTitle().contains("Help")){

            if(current.getType().equals(Material.CYAN_STAINED_GLASS_PANE)){
                ev.setCancelled(true);
            }else if(current.getItemMeta().getDisplayName().contains("Faction")){

                ev.setCancelled(true);
                player.chat("/f help");

            }else if(current.getItemMeta().getDisplayName().contains("Entreprise")){

                ev.setCancelled(true);
                player.chat("/entreprises");

            }else if(current.getItemMeta().getDisplayName().contains("Jobs")){

                ev.setCancelled(true);
                player.chat("/jobs help");

            }

        }
    }
}
