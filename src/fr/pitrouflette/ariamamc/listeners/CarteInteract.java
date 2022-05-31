package fr.pitrouflette.ariamamc.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CarteInteract implements Listener {

    @EventHandler
    public void OnPlayerInterateInvCarte(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();

        Location LocArene = new Location(player.getLocation().getWorld(), 143, -21, -368);

        Location locSpawn = new Location(player.getLocation().getWorld(), 140, 26, -219);

        Location locSkyCity = new Location(player.getLocation().getWorld(), -991, 69, -2349);

        Location locTreeCity = new Location(player.getLocation().getWorld(), -1440, 64, -288);

        Location locFlamCity = new Location(player.getLocation().getWorld(), -3544, 64, 1210);

        if(!ev.getView().getTitle().contains("§bCarte")){
            return;
        }

        if (current == null) return;

        if (current.getItemMeta().getDisplayName().contains("Spawn")) {
            player.closeInventory();
            player.teleport(locSpawn);
            ev.setCancelled(true);
        }

        if (current.getItemMeta().getDisplayName().contains("Faction")) {
            player.closeInventory();
            player.chat("/rtp");
            ev.setCancelled(true);
        }

        if (current.getItemMeta().getDisplayName().contains("Farm")) {
            player.closeInventory();
            player.chat("/rtp");
            ev.setCancelled(true);
        }

        if (current.getItemMeta().getDisplayName().contains("Arene")) {
            ev.setCancelled(true);
            player.teleport(LocArene);
        }

        if (current.getItemMeta().getDisplayName().contains("Quitter")) {
            player.closeInventory();
            ev.setCancelled(true);
        }

        if (current.getItemMeta().getDisplayName().contains("SkyCity")) {
            player.closeInventory();
            player.teleport(locSkyCity);
            ev.setCancelled(true);
        }


        if (current.getItemMeta().getDisplayName().contains("FlamCity")) {
            player.closeInventory();
            player.teleport(locFlamCity);
            ev.setCancelled(true);
        }

        if (current.getItemMeta().getDisplayName().contains("TreeCity")) {
            player.closeInventory();
            player.teleport(locTreeCity);
            ev.setCancelled(true);
        }

    }

}
