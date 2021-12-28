package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CryptoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            //ItemlStack CubeCoin
            ItemStack CubeCoin = new ItemStack(Material.SUNFLOWER);
            ItemMeta CubeCoinM = CubeCoin.getItemMeta();
            CubeCoinM.setDisplayName("§3Cube§6Coin");
            CubeCoinM.setLore(Arrays.asList("§3Par Pitrouflette - CubeCoin©", "§6/bourse §3pour voir le cour de cette crypto-momaie"));
            CubeCoin.setItemMeta(CubeCoinM);

            if(args.length == 0){
                sender.sendMessage("§4Veuillez présiser quelle Crypto-Monaie voulez vous recevoir : CubeCoin / ");
            }else if(args.length == 1){
                if (args[0].equals("CubeCoin")){
                    ((Player) sender).getInventory().addItem(CubeCoin);
                }

            }else{
                sender.sendMessage("§4Argument incorrect");
            }


        }
        return true;
    }
}
