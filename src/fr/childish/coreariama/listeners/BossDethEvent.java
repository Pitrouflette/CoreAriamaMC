package fr.childish.coreariama.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class BossDethEvent implements Listener {

    @EventHandler
    public void onMobDeath(EntityDeathEvent e){


        if (e.getEntity() instanceof Giant && e.getEntity().getKiller() instanceof Player){
            String tueur = e.getEntity().getKiller().getName();

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + tueur + " " + 750000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate gk " + tueur + " Event 1");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "classement " + tueur + " 30");

        }
    }
}
