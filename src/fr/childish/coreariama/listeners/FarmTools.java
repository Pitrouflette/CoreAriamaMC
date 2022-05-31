package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FarmTools implements Listener {
    private List<Material> allowed;

    public FarmTools(Main main) {
        allowed = Arrays.asList(Material.NETHER_WARTS, Material.POTATO, Material.CARROT);
    }

    File filees = new File(Main.instance.getDataFolder(),"config.yml");
    FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        Block block = event.getBlock();
        if (itemStack != null && itemStack.getType() != null && itemStack.hasItemMeta()) {
            if (itemStack.getItemMeta().getDisplayName().equals(configaa.getString("items.farm-tool-1.name"))) {
                event.setCancelled(true);
                this.use(player, event.getBlock(), 1);
            } else if (itemStack.getItemMeta().getDisplayName().equals(configaa.getString("items.farm-tool-2.name"))) {
                event.setCancelled(true);
                for(int x = block.getLocation().getBlockX() - 1; x <= block.getLocation().getBlockX() + 1; ++x) {
                    for(int z = block.getLocation().getBlockZ() - 1; z <= block.getLocation().getBlockZ() + 1; ++z) {
                        this.use(player, (new Location(event.getBlock().getLocation().getWorld(), (double)x, (double)event.getBlock().getLocation().getBlockY(), (double)z)).getBlock(), 2);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHoe(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        if (itemStack != null && itemStack.getType() != null && itemStack.hasItemMeta()) {
            if (itemStack.getItemMeta().getDisplayName().equals(configaa.getString("items.farm-tools-condiation"))) {
                event.setCancelled(true);
            }

        }
    }

    private void use(Player player, Block block, int levelTools) {
        if (this.allowed.contains(block.getType())) {
            Material drop = block.getType();
            ItemStack itemStack = player.getItemInHand();
            if ((drop != Material.NETHER_WARTS || block.getData() >= 3) && (drop != Material.POTATO || block.getData() >= 6) && (drop != Material.CARROT || block.getData() >= 6)) {
                if(levelTools == 2){
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    block.setType(drop);
                    int lootingLevel = (Integer)itemStack.getEnchantments().getOrDefault(Enchantment.LOOT_BONUS_BLOCKS, 0);
                    int amount = (lootingLevel + 1) * 5 ;
                    Material item = null;
                    if(drop.equals(Material.NETHER_WARTS)){
                        item = Material.NETHER_WARTS;
                    }else if(drop.equals(Material.POTATO)){
                        item = Material.POTATO_ITEM;
                    }else if(drop.equals(Material.CARROT)){
                        item = Material.CARROT_ITEM;
                    }else{
                        item = Material.NETHER_STALK;
                    }

                    ItemStack itemReslut = new ItemStack(item, amount);

                    if (player.getInventory().firstEmpty() == -1) {
                        Bukkit.getWorld(block.getWorld().getName()).dropItemNaturally(block.getLocation(), itemReslut);
                    } else {
                        player.getInventory().addItem(itemReslut);
                        player.updateInventory();
                    }
                }else{
                    block.setType(drop);
                    int lootingLevel = (Integer)itemStack.getEnchantments().getOrDefault(Enchantment.LOOT_BONUS_BLOCKS, 0);
                    int amount = lootingLevel + 1;
                    Material item = null;
                    if(drop.equals(Material.NETHER_WARTS)){
                        item = Material.NETHER_WARTS;
                    }else if(drop.equals(Material.POTATO)){
                        item = Material.POTATO_ITEM;
                    }else if(drop.equals(Material.CARROT)){
                        item = Material.CARROT_ITEM;
                    }else{
                        item = Material.NETHER_STALK;
                    }

                    ItemStack itemReslut = new ItemStack(item, amount);

                    if (player.getInventory().firstEmpty() == -1) {
                        Bukkit.getWorld(block.getWorld().getName()).dropItemNaturally(block.getLocation(), itemReslut);
                    } else {
                        player.getInventory().addItem(itemReslut);
                        player.updateInventory();
                    }
                }

            }
        }
    }
}