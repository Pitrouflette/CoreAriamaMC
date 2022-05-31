package fr.pitrouflette.ariamamc.commands;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AriamaMc implements CommandExecutor {

    final Main main;

    public AriamaMc(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordM = sword.getItemMeta();
        swordM.setDisplayName(main.getConfig().getString("items.sword.name"));
        swordM.setLore(main.getConfig().getStringList("items.sword.lore"));
        swordM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        swordM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        swordM.addEnchant(Enchantment.DURABILITY, 3, true);
        sword.setItemMeta(swordM);

        ItemStack road = new ItemStack(Material.FISHING_ROD);
        ItemMeta roadM = road.getItemMeta();
        roadM.setDisplayName(main.getConfig().getString("items.rod.name"));
        roadM.setLore(main.getConfig().getStringList("items.rod.lore"));
        roadM.addEnchant(Enchantment.DURABILITY, 3, true);
        road.setItemMeta(roadM);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowM = bow.getItemMeta();
        bowM.setDisplayName(main.getConfig().getString("items.bow.name"));
        bowM.setLore(main.getConfig().getStringList("items.bow.lore"));
        bowM.addEnchant(Enchantment.DURABILITY, 3, true);
        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowM);

        if(args.length > 0){
            if (args[0].equalsIgnoreCase("help")){

                sender.sendMessage(main.getConfig().getString("messages.help.line1").replace("&", "§"));
                sender.sendMessage(main.getConfig().getString("messages.help.line2").replace("&", "§"));
                sender.sendMessage(main.getConfig().getString("messages.help.line3").replace("&", "§"));
                sender.sendMessage(main.getConfig().getString("messages.help.line4").replace("&", "§"));

            }else if(args[0].equalsIgnoreCase("reload")){

                sender.sendMessage(main.getConfig().getString("messages.reload.succes").replace("&", "§"));

                main.reloadConfig();

            }else if(args[0].equalsIgnoreCase("items")){
                if(args[1].equalsIgnoreCase("sword") && args[2] != null){
                    String playerName = args[2];
                    if (Bukkit.getPlayer(playerName) != null) {
                        Bukkit.getPlayer(playerName).getInventory().addItem(sword);
                    }
                }

                if(args[1].equalsIgnoreCase("rod") && args[2] != null){
                    String playerName = args[2];
                    if (Bukkit.getPlayer(playerName) != null) {
                        Bukkit.getPlayer(playerName).getInventory().addItem(road);
                    }
                }
                if(args[1].equalsIgnoreCase("bow") && args[2] != null){
                    String playerName = args[2];
                    if (Bukkit.getPlayer(playerName) != null) {
                        Bukkit.getPlayer(playerName).getInventory().addItem(bow);
                    }
                }
            }
        }else{
            sender.sendMessage(main.getConfig().getString("messages.commands.commands_argument").replace("&", "§"));
            sender.sendMessage(main.getConfig().getString("messages.commands.ariama_command").replace("&", "§"));
        }

        return true;
    }


}