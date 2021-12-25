package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ClearHandCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player myplayer = (Player) sender;
            ItemStack air = myplayer.getItemInHand();
            myplayer.getInventory().remove(air);
            myplayer.updateInventory();
            myplayer.sendMessage("§c[§bPluginBeen§c] §2Vous avez supprimé les items de votre main");
        }
        return true;
    }
}
