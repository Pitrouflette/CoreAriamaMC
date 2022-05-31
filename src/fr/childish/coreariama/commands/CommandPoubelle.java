package fr.childish.coreariama.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandPoubelle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("poubelle") && sender instanceof Player){
            Inventory gui = Bukkit.createInventory(null, 27, "§eAriama§6MC §6» §ePoubelle");
            ((Player) sender).openInventory(gui);
        }
        return false;
    }
}
