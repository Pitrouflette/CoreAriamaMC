package fr.geekschool.pluginarena.commands;

import fr.geekschool.pluginarena.listeners.onFindGift;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.logging.Logger;

public class GiftCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            ItemStack gift = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta giftSkullMeta = (SkullMeta) gift.getItemMeta();
            giftSkullMeta.setOwner("HypixelGifting");
            giftSkullMeta.setDisplayName("§eGift");
            gift.setItemMeta(giftSkullMeta);
            player.getInventory().addItem(gift);

        }else{
            Logger.getLogger("PluginArena").warning("Vous devez etre un joueur pour utiliser cette command");
        }
        return true;
    }
}
