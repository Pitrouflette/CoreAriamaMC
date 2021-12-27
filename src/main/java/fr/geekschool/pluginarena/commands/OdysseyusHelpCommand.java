package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class OdysseyusHelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Inventory inv = Bukkit.createInventory(null, 9, "Odysseyus Help Page");
            //Item Border
            ItemStack border = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
            ItemMeta borderM = border.getItemMeta();
            borderM.setDisplayName(" ");
            borderM.addEnchant(Enchantment.DURABILITY, 1, true);
            borderM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            border.setItemMeta(borderM);

            //Item HelpFaction
            ItemStack faction = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta factionM = faction.getItemMeta();
            factionM.setDisplayName("Help Faction (/f help)");
            factionM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            factionM.addEnchant(Enchantment.DURABILITY, 1, true);
            faction.setItemMeta(factionM);

            //Item HelpEntreprise
            ItemStack enter = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta enterM = faction.getItemMeta();
            enterM.setDisplayName("Help Entreprises (/companies)");
            enterM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            enterM.addEnchant(Enchantment.DURABILITY, 1, true);
            enter.setItemMeta(factionM);

            inv.setItem(0, border);
            inv.setItem(2, border);
            inv.setItem(3, border);
            inv.setItem(4, border);
            inv.setItem(5, border);
            inv.setItem(6, border);
            inv.setItem(7, border);
            inv.setItem(8, border);
            sender.sendMessage("OdysseyusHelp page");
        }

        return true;
    }

}
