package fr.geekschool.pluginarena.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobSpawn implements Listener {

    @EventHandler
    public void onEndermanSpawn(EntitySpawnEvent e) {
        Entity  entity = e.getEntity();

        if(!(entity.getWorld().getEnvironment() == World.Environment.THE_END)) return;

        if(!(entity instanceof Enderman)) return;

        ((Enderman) entity).setMaxHealth(200);
        ((Enderman) entity).setHealth(200);
        entity.setCustomName("Gardien Perdu");
        ((Enderman) entity).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1 ));
    }
}
