package fr.pitrouflette.ariamamc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class UpPro implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        ItemMeta playerHandMeta = player.getInventory().getItemInHand().getItemMeta();

        if (playerHandMeta.hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)){
            player.sendMessage("§4Vous possédez déjà cette enchantement sur cette pièce d'armure");
        }else if(playerHandMeta.getDisplayName().contains("Crystal")){
            playerHandMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 15, true);
            playerHandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            playerHandMeta.setLore(Arrays.asList("§7protection §4XV"));

            player.getItemInHand().setItemMeta(playerHandMeta);
        }else{
            player.sendMessage("§4Vous ne pouvez pas améliorer cette pièce d'armure");
        }
        return true;
    }
}
