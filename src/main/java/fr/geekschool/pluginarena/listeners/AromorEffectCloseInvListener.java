package fr.geekschool.pluginarena.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("deprecation")
public class AromorEffectCloseInvListener implements Listener {

    @EventHandler
    public void onCloseInv(InventoryCloseEvent ev){

        Player player = (Player) ev.getPlayer();
        Inventory inv = ev.getInventory();

        if(ev.getView().getType().equals(InventoryType.PLAYER)) {

            if (player.getInventory().getBoots().hasItemMeta()) {

                if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Patin")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 4), true);
                } else {
                    player.removePotionEffect(PotionEffectType.SPEED);
                }
            }
        }
    }
}
