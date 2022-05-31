package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DethEvent implements Listener {

    HashMap playersUUID = new HashMap();

    File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
    FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);

    File file = new File(Main.instance.getDataFolder(),"factions.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

    File filees = new File(Main.instance.getDataFolder(),"config.yml");
    FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        List<ItemStack> itemStacks = new ArrayList();

        for (int i = 0; i < player.getInventory().getSize(); ++i) {
            ItemStack itemStack = player.getInventory().getItem(i);
            if (itemStack != null && itemStack.getType() != null && itemStack.getType() == Material.getMaterial(configaa.getString("items.sword1.material")) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(configaa.getString("items.sword1.name"))) {
                itemStacks.add(itemStack);
                event.getDrops().remove(itemStack);
                playersUUID.put(player.getUniqueId(), itemStacks);
            } else if (itemStack != null && itemStack.getType() != null && itemStack.getType() == Material.getMaterial(configaa.getString("items.sword2.material")) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(configaa.getString("items.sword2.name"))) {
                itemStacks.add(itemStack);
                event.getDrops().remove(itemStack);
                playersUUID.put(player.getUniqueId(), itemStacks);
            }

        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (this.playersUUID.containsKey(player.getUniqueId())) {
            ((List)playersUUID.get(player.getUniqueId())).forEach((itemStack) -> {
                player.getInventory().addItem(new ItemStack[] {(ItemStack) itemStack});
            });
            this.playersUUID.remove(player.getUniqueId());
        }
    }
}