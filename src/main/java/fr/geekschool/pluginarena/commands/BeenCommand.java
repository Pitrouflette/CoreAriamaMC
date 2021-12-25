package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BeenCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player myplayer = (Player) sender;

            Inventory inv = Bukkit.createInventory(null, 27, "               §bPoubelle");

            //Item QUIT
            ItemStack Quitter = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta quitMeta = Quitter.getItemMeta();
            quitMeta.setDisplayName("§bPoubelle");
            Quitter.setItemMeta(quitMeta);

            inv.setItem(0, Quitter);
            inv.setItem(1, Quitter);
            inv.setItem(2, Quitter);
            inv.setItem(3, Quitter);
            inv.setItem(4, Quitter);
            inv.setItem(5, Quitter);
            inv.setItem(6, Quitter);
            inv.setItem(7, Quitter);
            inv.setItem(8, Quitter);
            inv.setItem(9, Quitter);
            inv.setItem(17, Quitter);
            inv.setItem(18, Quitter);
            inv.setItem(19, Quitter);
            inv.setItem(20, Quitter);
            inv.setItem(21, Quitter);
            inv.setItem(22, Quitter);
            inv.setItem(23, Quitter);
            inv.setItem(24, Quitter);
            inv.setItem(25, Quitter);
            inv.setItem(26, Quitter);

            myplayer.openInventory(inv);
        }
        return true;
    }
}
