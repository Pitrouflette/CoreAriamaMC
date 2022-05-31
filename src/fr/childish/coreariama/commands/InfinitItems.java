package fr.childish.coreariama.commands;

import fr.childish.coreariama.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class InfinitItems implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        File filees = new File(Main.instance.getDataFolder(), "config.yml");
        FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

        if (args.length != 0 && args.length != 1 && args.length != 2) {
            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                Player player = Bukkit.getPlayer(args[1]);
                if (player != null) {
                    String item = args[2];
                    if (item.equalsIgnoreCase("Sword-level-1")) {
                        ItemStack swordL1 = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta swordL1M = swordL1.getItemMeta();
                        swordL1M.setDisplayName(configaa.getString("items.sword1.name"));
                        swordL1M.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                        swordL1M.addEnchant(Enchantment.DURABILITY, 3, true);
                        swordL1M.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
                        swordL1M.setLore(configaa.getStringList("items.sword1.lore"));
                        swordL1.setItemMeta(swordL1M);
                        player.getInventory().addItem(swordL1);
                        player.sendMessage(configaa.getString("items.messages.given").replace("<items>", "épée infini de niveau 1"));
                    } else if (item.equalsIgnoreCase("Sword-level-2")) {
                        ItemStack swordL2 = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta swordL2M = swordL2.getItemMeta();
                        swordL2M.setDisplayName(configaa.getString("items.sword2.name"));
                        swordL2M.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                        swordL2M.addEnchant(Enchantment.DURABILITY, 5, true);
                        swordL2M.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                        swordL2M.setLore(configaa.getStringList("items.sword2.lore"));
                        swordL2.setItemMeta(swordL2M);
                        player.getInventory().addItem(swordL2);
                        player.sendMessage(configaa.getString("items.messages.given").replace("<items>", "épée infini de niveau 2"));
                    } else if (item.equalsIgnoreCase("bow")) {
                        ItemStack bow = new ItemStack(Material.getMaterial(configaa.getString("items.bow.material")));
                        ItemMeta bowM = bow.getItemMeta();
                        bowM.setDisplayName(configaa.getString("items.bow.name"));
                        bowM.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
                        bowM.addEnchant(Enchantment.ARROW_FIRE, 5, true);
                        bowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
                        bowM.setLore(configaa.getStringList("items.bow.lore"));
                        bow.setItemMeta(bowM);
                        player.getInventory().addItem(bow);
                        player.sendMessage(configaa.getString("items.messages.given").replace("<items>", "l'arc infini"));
                    } else if (item.equalsIgnoreCase("FarmTool-level-1")) {
                        ItemStack farm1 = new ItemStack(Material.getMaterial(configaa.getString("items.farm-tool-1.material")));
                        ItemMeta farm1M = farm1.getItemMeta();
                        farm1M.setDisplayName(configaa.getString("items.farm-tool-1.name"));
                        farm1M.addEnchant(Enchantment.DURABILITY, 10, true);
                        farm1M.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                        farm1M.setLore(configaa.getStringList("items.farm-tool-1.lore"));
                        farm1.setItemMeta(farm1M);
                        player.getInventory().addItem(farm1);
                        player.sendMessage(configaa.getString("items.messages.given").replace("<items>", "FarmTool niveau 1"));
                    }else if (item.equalsIgnoreCase("FarmTool-level-2")) {
                        ItemStack farm2 = new ItemStack(Material.getMaterial(configaa.getString("items.farm-tool-2.material")));
                        ItemMeta farm2M = farm2.getItemMeta();
                        farm2M.setDisplayName(configaa.getString("items.farm-tool-2.name"));
                        farm2M.addEnchant(Enchantment.DURABILITY, 10, true);
                        farm2M.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
                        farm2M.setLore(configaa.getStringList("items.farm-tool-2.lore"));
                        farm2.setItemMeta(farm2M);
                        player.getInventory().addItem(farm2);
                        player.sendMessage(configaa.getString("items.messages.given").replace("<items>", "FarmTool niveau 2"));
                    }
                }

                return true;
            } else {
                sender.sendMessage(configaa.getString("items.messages.help").replace("&", "§"));
                return true;
            }
        }
        return true;
    }
}

//        ###############################################################
//        ##  														 ##
//        ##							Items						  ##
//        ##															 ##
//        ###############################################################
//        #<PlaceHolders>
//        #items : items given when someone execute the command : /infinit-item
//
//        items:
//
//        messages:
//        given: "§8[§6Ariama§eMC§8]Vous avez reçu : <items> !"
//
//        sword1:
//        material: "DIAMOND_SWORD"
//        name: "Infinit Sword level.1"
//        lore:
//        - "lore"
//
//        swors2:
//        material: "DIAMOND_SWORD"
//        name: "Infinit Sword level.2"
//        lore:
//        - "lore"
//
//        bow:
//        material: "BOW"
//        name: "Infinit Sword level.2"
//        lore:
//        - "lore"
//
//        farm-tool-1:
//        material: "GOLD_HOE"
//        name: "Infinit Sword level.2"
//        lore:
//        - "lore"
//
//        farm-tool-2:
//        material: "GOLD_HOE"
//        name: "Infinit Sword level.2"
//        lore:
//        - "lore"
