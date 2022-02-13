package fr.geekschool.pluginarena.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FragCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        ItemStack CrystalsFrag = new ItemStack(Material.PRISMARINE_CRYSTALS);
        ItemMeta CrystalsFragM = CrystalsFrag.getItemMeta();
        CrystalsFragM.setDisplayName("§3Crystals §9Fragment");
        CrystalsFragM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsFragM.addEnchant(Enchantment.DURABILITY, 1, true);
        CrystalsFragM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐",
                "§3Item Crystal : Fragement",
                "§3Ceci vous permet de craft des ",
                "§9Crystals",
                "§9--------------------"));
        CrystalsFrag.setItemMeta(CrystalsFragM);

        ItemStack CrystalsIngot = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta CrystalsIngotM = CrystalsIngot.getItemMeta();
        CrystalsIngotM.setDisplayName("§3Crystals §9Ingot");
        CrystalsIngotM.addEnchant(Enchantment.DURABILITY, 1, true);
        CrystalsIngotM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsIngotM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Crystal : Crystals",
                "§3Elle vous permet de craft des items en",
                "§9Crystals",
                "§9--------------------"));
        CrystalsIngot.setItemMeta(CrystalsIngotM);

        ItemStack CrystalsHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta CrystalsHelmetM = CrystalsHelmet.getItemMeta();
        CrystalsHelmetM.setDisplayName("§3Crystals §9Helmet");
        CrystalsHelmetM.addEnchant(Enchantment.DURABILITY, 5, true);
        CrystalsHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        CrystalsHelmetM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsHelmetM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Crystal : Helmet",
                "§3Ceci est un pièce de l'armure en :",
                "§9Crystals",
                "§9--------------------"));
        CrystalsHelmet.setItemMeta(CrystalsHelmetM);

        ItemStack CrystalsCHestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta CrystalsCHestplateM = CrystalsCHestplate.getItemMeta();
        CrystalsCHestplateM.setDisplayName("§3Crystals §9Chestplate");
        CrystalsCHestplateM.addEnchant(Enchantment.DURABILITY, 5, true);
        CrystalsCHestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        CrystalsCHestplateM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsCHestplateM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Crystal : Chestplate",
                "§3Ceci est un pièce de l'armure en :",
                "§9Crystals",
                "§9--------------------"));
        CrystalsCHestplate.setItemMeta(CrystalsCHestplateM);

        ItemStack CrystalsLegg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta CrystalsLeggM = CrystalsLegg.getItemMeta();
        CrystalsLeggM.setDisplayName("§3Crystals §9Leggings");
        CrystalsLeggM.addEnchant(Enchantment.DURABILITY, 5, true);
        CrystalsLeggM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        CrystalsLeggM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsLeggM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Crystal : Leggings",
                "§3Ceci est un pièce de l'armure en :",
                "§9Crystals",
                "§9--------------------"));
        CrystalsLegg.setItemMeta(CrystalsLeggM);

        ItemStack CrystalsBoot = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta CrystalsBootM = CrystalsBoot.getItemMeta();
        CrystalsBootM.setDisplayName("§3Crystals §9Boots");
        CrystalsBootM.addEnchant(Enchantment.DURABILITY, 5, true);
        CrystalsBootM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        CrystalsBootM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CrystalsBootM.setLore(Arrays.asList("§9--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Crystal : Boots",
                "§3Ceci est un pièce de l'armure en :",
                "§9Crystals",
                "§9--------------------"));
        CrystalsBoot.setItemMeta(CrystalsBootM);

        Player player = (Player) sender;

        player.getInventory().addItem(CrystalsBoot);
        player.getInventory().addItem(CrystalsHelmet);
        player.getInventory().addItem(CrystalsCHestplate);
        player.getInventory().addItem(CrystalsLegg);
        player.getInventory().addItem(CrystalsIngot);
        player.getInventory().addItem(CrystalsFrag);




        return true;
    }



}
