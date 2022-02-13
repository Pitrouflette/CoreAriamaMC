package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SwordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player payer = (Player) sender;

            //Item Sword Christmas
            ItemStack Hotte = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta HotteMeta = Hotte.getItemMeta();
            HotteMeta.setDisplayName("§4Christmas §1Sword");
            HotteMeta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
            HotteMeta.setLore(Arrays.asList("§4--------------------", "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐", "§1Item Illégal : Epée", "§1Cette Item est : §4 Inopptensible In-Game", "§1Elle vous permet de tuer toutes", "§4les entités dans un rayon de 25 block", "§4--------------------"));
            Hotte.setItemMeta(HotteMeta);

            payer.getInventory().addItem(Hotte);


            if(args.length == 0){
                payer.sendMessage("§4Veuillez spécifier l'objet voulu");
            }
            if(args.length == 1){
                if(args[0].equals("sword")){
                    payer.getInventory().addItem(Hotte);
                }
            }
        }
        return true;
    }
}
