package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomCraftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory invCraft =  Bukkit.createInventory(null, 54, "§3Pitrouflette §6Assembler");

            //Item Border
            ItemStack border = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
            ItemMeta borderM = border.getItemMeta();
            borderM.setDisplayName(" ");
            borderM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            borderM.addEnchant(Enchantment.DURABILITY, 1, false);
            border.setItemMeta(borderM);

            //Item Assembler
            ItemStack Assembler = new ItemStack(Material.SLIME_BLOCK);
            ItemMeta AssemblerM =Assembler.getItemMeta();
            AssemblerM.setDisplayName("§3Assembler les §6éléments");
            AssemblerM.addEnchant(Enchantment.DURABILITY, 1, true);
            AssemblerM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Assembler.setItemMeta(AssemblerM);

            invCraft.setItem(0, border);
            invCraft.setItem(1, border);
            invCraft.setItem(2, border);
            invCraft.setItem(3, border);
            invCraft.setItem(4, border);
            invCraft.setItem(5, border);
            invCraft.setItem(6, border);
            invCraft.setItem(7, border);
            invCraft.setItem(8, border);
            invCraft.setItem(9, border);
            invCraft.setItem(10, border);
            invCraft.setItem(11, border);
            invCraft.setItem(12, border);
            invCraft.setItem(13, border);
            invCraft.setItem(14, border);
            invCraft.setItem(15, border);
            invCraft.setItem(16, border);
            invCraft.setItem(17, border);
            invCraft.setItem(18, border);
            invCraft.setItem(22, border);
            invCraft.setItem(23, border);
            invCraft.setItem(24, border);
            invCraft.setItem(25, border);
            invCraft.setItem(26, border);
            invCraft.setItem(27, border);
            invCraft.setItem(31, border);
            invCraft.setItem(32, Assembler);
            invCraft.setItem(33, border);
            invCraft.setItem(35, border);
            invCraft.setItem(36, border);
            invCraft.setItem(40, border);
            invCraft.setItem(41, border);
            invCraft.setItem(42, border);
            invCraft.setItem(43, border);
            invCraft.setItem(44, border);
            invCraft.setItem(45, border);
            invCraft.setItem(46, border);
            invCraft.setItem(47, border);
            invCraft.setItem(48, border);
            invCraft.setItem(49, border);
            invCraft.setItem(50, border);
            invCraft.setItem(51, border);
            invCraft.setItem(52, border);
            invCraft.setItem(53, border);

            player.openInventory(invCraft);
        }

        return true;
    }


}
