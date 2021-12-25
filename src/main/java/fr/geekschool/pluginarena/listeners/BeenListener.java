package fr.geekschool.pluginarena.listeners;
import fr.geekschool.pluginarena.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Arrays;
import java.util.logging.Logger;

public class BeenListener implements Listener {

    @EventHandler
    public void onClickInv(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();

        if(current == null) return;

        if(ev.getView().getTitle().contains("Poubelle")){
            if (current.getItemMeta().getDisplayName().contains("§bPoubelle")) {
                ev.setCancelled(true);
            }

        }
    }
}
