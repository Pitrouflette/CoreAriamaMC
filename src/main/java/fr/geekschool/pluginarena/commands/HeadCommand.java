package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta headSkullMeta = (SkullMeta) head.getItemMeta();
            if (args == null){
                headSkullMeta.setOwner(player.getName());
            }else if (args.length == 1){
                headSkullMeta.setOwner(args[0]);
            }else{
                player.sendMessage("§c[§bHeadg§c] §2Argument incorrect");
            }

            headSkullMeta.setDisplayName("§e" + args[0] + "'s §1Head");
            head.setItemMeta(headSkullMeta);

            player.getInventory().addItem(head);

        }
        return true;
    }
}

