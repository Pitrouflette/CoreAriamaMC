package fr.pitrouflette.ariamamc.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvArmorIntercat implements Listener {

    @EventHandler
    public void onInteractInv(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();

        if(ev.getView().getTitle().contains("Amélioration")){
            if(ev.getCurrentItem().getItemMeta().getDisplayName().contains("• §9Amélioration de la résisstance")){
                player.chat("/armureupprotection");
                ev.setCancelled(true);
            }
            if(ev.getCurrentItem().getItemMeta().getDisplayName().contains("• §9Amélioration de la durabilité")){
                player.chat("/armureupunbreaking");
                ev.setCancelled(true);
            }
            if(ev.getCurrentItem().getItemMeta().getDisplayName().contains("• §9Réparation de l'armure")){
                player.chat("/armurerepair");
                ev.setCancelled(true);
            }
        }
    }
}
