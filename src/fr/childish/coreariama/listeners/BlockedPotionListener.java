package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class BlockedPotionListener implements Listener {

    private final Main main;

    File filees = new File(Main.instance.getDataFolder(), "config.yml");
    FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

    public BlockedPotionListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        ItemMeta itemM = itemStack.getItemMeta();
        if (itemStack != null && itemStack.getType() != Material.AIR && itemStack.getType() == Material.POTION) {
            if (main.getPotionManager().isBlocked(itemStack)) {
                event.setCancelled(true);
                player.setItemInHand(new ItemStack(Material.AIR));
                player.sendMessage(configaa.getString("blocked-potions-message"));
            }
        }
    }
}
