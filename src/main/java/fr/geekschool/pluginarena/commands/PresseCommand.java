package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PresseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){

            Player player = (Player) sender;
            //Item Crad
            ItemStack Card = new ItemStack(Material.PAPER);
            ItemMeta CardM = Card.getItemMeta();
            CardM.setDisplayName("§3Carte De §6Journaliste");
            Card.setItemMeta(CardM);

            player.getInventory().addItem(Card);
        }
        return true;
    }
}
