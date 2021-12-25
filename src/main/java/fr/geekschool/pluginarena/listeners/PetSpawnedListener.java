package fr.geekschool.pluginarena.listeners;

import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PetSpawnedListener implements Listener {

    @EventHandler
    public void onClickInv(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();
        Location loc = player.getLocation();

        if(current == null) return;

        if(ev.getView().getTitle().contains("Pet")){

            if (current.getItemMeta().getDisplayName().contains("bPig")) {
                player.getWorld().spawnEntity(loc, EntityType.PIG);
                player.sendMessage("§c[§bPluginPet§c] §2Vous avez summon votre §cPig §2avec succès");
                ev.setCancelled(true);
            }
            if (current.getItemMeta().getDisplayName().contains("bWolf")) {
                player.getWorld().spawnEntity(loc, EntityType.WOLF);
                player.sendMessage("§c[§bPluginPet§c] §2Vous avez summon votre §cWolf §2avec succès");
                ev.setCancelled(true);
                ev.setCancelled(true);
            }
            if (current.getItemMeta().getDisplayName().contains("bCat")) {
                player.getWorld().spawnEntity(loc, EntityType.CAT);
                player.sendMessage("§c[§bPluginPet§c] §2Vous avez summon votre §cCat §2avec succès");
                ev.setCancelled(true);
                ev.setCancelled(true);
            }
            if (current.getItemMeta().getDisplayName().contains("bFox")) {
                player.getWorld().spawnEntity(loc, EntityType.FOX);
                player.sendMessage("§c[§bPluginPet§c] §2Vous avez summon votre §cFox §2avec succès");
                ev.setCancelled(true);
                ev.setCancelled(true);
            }
            if (current.getItemMeta().getDisplayName().contains("bPanda")) {
                player.getWorld().spawnEntity(loc, EntityType.PANDA);
                player.sendMessage("§c[§bPluginPet§c] §2Vous avez summon votre §cPanda §2avec succès");
                ev.setCancelled(true);
                ev.setCancelled(true);
            }
        }
    }


    @EventHandler
    public void onSpawnEVent(CreatureSpawnEvent ev) {

        if (ev.getEntity() instanceof Pig) {

            Pig pig = (Pig) ev.getEntity();

            pig.setCustomName("§c[§bOdysseyus§c]PigPet");
            pig.setGlowing(true);
            pig.setBaby();
            pig.setCollidable(false);
        }

        if (ev.getEntity() instanceof Wolf) {

            Wolf wolf = (Wolf) ev.getEntity();

            wolf.setCustomName("§c[§bOdysseyus§c]WolfPet");
            wolf.setGlowing(true);
            wolf.setBaby();
            wolf.setCollidable(false);
        }

        if (ev.getEntity() instanceof Cat) {

            Cat cat = (Cat) ev.getEntity();

            cat.setCustomName("§c[§bOdysseyus§c]CatPet");
            cat.setGlowing(true);
            cat.setBaby();
            cat.setCanPickupItems(true);
            cat.setCollidable(false);
        }

        if (ev.getEntity() instanceof Panda) {

            Panda panda = (Panda) ev.getEntity();

            panda.setCustomName("§c[§bOdysseyus§c]PandaPet");
            panda.setGlowing(true);
            panda.setBaby();
            panda.setCollidable(false);
        }

        if (ev.getEntity() instanceof Fox) {

            Fox fox = (Fox) ev.getEntity();

            fox.setCustomName("§c[§bOdysseyus§c]FoxPet");
            fox.setGlowing(true);
            fox.setBaby();
            fox.setCollidable(false);
        }
    }

}
