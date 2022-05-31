package fr.pitrouflette.ariamamc.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmureRepair implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        //         Helmet            //
        ItemStack Helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta HelmetM = Helmet.getItemMeta();
        HelmetM.setDisplayName("§1Casque de §bCrystal");
        Helmet.setItemMeta(HelmetM);
        //         Chestplate      //
        ItemStack Chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta ChestplateM = Chestplate.getItemMeta();
        ChestplateM.setDisplayName("§1Plastron de §bCrystal");
        Chestplate.setItemMeta(ChestplateM);
        //        Leggings          //
        ItemStack Leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta LeggingsM = Leggings.getItemMeta();
        LeggingsM.setDisplayName("§1Jambière de §bCrystal");
        Leggings.setItemMeta(LeggingsM);
        //         Boots            //
        ItemStack Boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta BootsM = Boots.getItemMeta();
        BootsM.setDisplayName("§1Chausure de §bCrystal");
        Boots.setItemMeta(BootsM);

        Player player = (Player) sender;

        if(!(player.getItemInHand().getType().equals(Material.CHAINMAIL_HELMET)) || !(player.getItemInHand().getType().equals(Material.CHAINMAIL_CHESTPLATE)) || !(player.getItemInHand().getType().equals(Material.CHAINMAIL_LEGGINGS)) || !(player.getItemInHand().getType().equals(Material.CHAINMAIL_BOOTS))){
            return true;
        }

        if (player.getItemInHand().getItemMeta().getDisplayName().contains("Crystal")) {
            if(player.getItemInHand().getType().equals(Material.CHAINMAIL_HELMET)){
                player.setItemInHand(new ItemStack(Material.AIR));
                player.setItemInHand(Helmet);
            }
            if(player.getItemInHand().getType().equals(Material.CHAINMAIL_CHESTPLATE)){
                player.setItemInHand(new ItemStack(Material.AIR));
                player.setItemInHand(Chestplate);
            }
            if(player.getItemInHand().getType().equals(Material.CHAINMAIL_LEGGINGS)){
                player.setItemInHand(new ItemStack(Material.AIR));
                player.setItemInHand(Leggings);
            }
            if(player.getItemInHand().getType().equals(Material.CHAINMAIL_BOOTS)){
                player.setItemInHand(new ItemStack(Material.AIR));
                player.setItemInHand(Boots);
            }

        }


    return true;
    }
}
