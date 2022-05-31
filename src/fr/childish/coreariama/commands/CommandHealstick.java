package fr.childish.coreariama.commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CommandHealstick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(label.equalsIgnoreCase("healstick")){
                if(p.hasPermission("healstick.give")){

                    ItemStack itm = new ItemStack(Material.STICK);
                    ItemMeta itmM = itm.getItemMeta();
                    itmM.setDisplayName("§6§lHealStick");
                    ArrayList<String> itmlore = new ArrayList<>();
                    itmlore.add("Forger");
                    itmlore.add("Lointain");
                    itmM.setLore(itmlore);
                    itmM.addEnchant(Enchantment.DURABILITY, 3, true);
                    itm.setItemMeta(itmM);
                    p.getInventory().addItem(itm);
                    p.sendMessage("§6Vous venez de recevoir votre HealStick.");

                }
            }

        }else {
            sender.sendMessage("§cVous ne pouvez pas faire ceci.");
        }

        return false;
    }
}