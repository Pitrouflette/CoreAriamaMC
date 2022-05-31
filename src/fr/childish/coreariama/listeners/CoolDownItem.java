package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;


import java.io.File;

public class CoolDownItem implements Listener {

    static File files = new File(Main.instance.getDataFolder(),"config.yml");
    static FileConfiguration configs = new YamlConfiguration().loadConfiguration(files);

    @EventHandler
    public void onItemEat(PlayerItemConsumeEvent e){
        Player p = e.getPlayer();

        if(e.getItem().getType().equals(Material.GOLDEN_APPLE)){
            if(e.getItem().getDurability()==1){
                p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cLes pommes cheat sont désactivées sur le serveur !");
                e.setCancelled(true);
                return;
            }else return;

        }else if(e.getItem().getType().equals(Material.POTION)){
            if(e.getItem().getDurability()==8233){
                p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cLes potions de Force II sont désactivées sur le serveur !");
                e.setCancelled(true);
                return;
            }else {
                return;
            }
        }else return;
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(p.getItemInHand().getType() == Material.GOLDEN_APPLE){
            if(event.getItem().getDurability()==1){
                int nombre = p.getItemInHand().getAmount();
                ItemStack pommeDoree = new ItemStack(Material.GOLDEN_APPLE, nombre);
                p.getInventory().setItemInHand(pommeDoree);
                return;
            }else {
                return;
            }
        }else {
            return;
        }
    }
}