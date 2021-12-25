package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.logging.Logger;

public class CadeauCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory giftGift = Bukkit.createInventory(null, 27, "             §bRécompenses");


            //ItemHotte
            ItemStack Hotte = new ItemStack(Material.NETHER_STAR);
            ItemMeta HotteMeta = Hotte.getItemMeta();
            HotteMeta.setDisplayName("§4Christmas §1Hotte");
            HotteMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            HotteMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            HotteMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : Hotte", "§1Prix : §4 5 cadeaux", "§1Cette hotte vous permet d'ouvrir un §4sac a dos", "§4--------------------"));
            Hotte.setItemMeta(HotteMeta);

            //ItemHotte
            ItemStack Hottep = new ItemStack(Material.NETHER_STAR);
            ItemMeta HotteMetap = Hottep.getItemMeta();
            HotteMetap.setDisplayName("§4Christmas §1Hotte : 5 cadeaux");
            HotteMetap.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            HotteMetap.addEnchant(Enchantment.DURABILITY, 5, true);
            HotteMetap.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : Hotte", "§1Prix : §4 5 cadeaux", "§1Cette hotte vous permet d'ouvrir un §4sac a dos", "§4--------------------"));
            Hottep.setItemMeta(HotteMetap);

            //ItemSnowLancheur
            ItemStack SnowLancheur = new ItemStack(Material.STICK);
            ItemMeta SonwLancheurMeta = SnowLancheur.getItemMeta();
            SonwLancheurMeta.setDisplayName("§bLanceur De Boules De §eNeiges");
            SonwLancheurMeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
            SonwLancheurMeta.setLore(Arrays.asList("§e--------------------", "§bLanceur De Boules De §eNeiges", "§e--------------------"));
            SnowLancheur.setItemMeta(SonwLancheurMeta);

            //ItemSnowLancheur
            ItemStack SnowLancheurp = new ItemStack(Material.STICK);
            ItemMeta SonwLancheurpMeta = SnowLancheurp.getItemMeta();
            SonwLancheurpMeta.setDisplayName("§bLanceur De Boules De §eNeiges : 5 cadeaux");
            SonwLancheurpMeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
            SonwLancheurpMeta.setLore(Arrays.asList("§e--------------------", "§bLanceur De Boules De §eNeiges", "§1Prix : §4 5 cadeaux", "§e--------------------"));
            SnowLancheurp.setItemMeta(SonwLancheurpMeta);


            //HelmetGod
            ItemStack HelmetGod = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta HelmetGodMeta = HelmetGod.getItemMeta();
            HelmetGodMeta.setDisplayName("§4Christmas §1Helmet");
            HelmetGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            HelmetGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            HelmetGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : casque", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            HelmetGod.setItemMeta(HelmetGodMeta);

            //ChestGod
            ItemStack ChestGod = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta ChestGodMeta = ChestGod.getItemMeta();
            ChestGodMeta.setDisplayName("§4Christmas §1Chestplate");
            ChestGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            ChestGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            ChestGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : plastron", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            ChestGod.setItemMeta(ChestGodMeta);

            //LeggGod
            ItemStack LeggGod = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta LeggGodMeta = LeggGod.getItemMeta();
            LeggGodMeta.setDisplayName("§4Christmas §1Leggings");
            LeggGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            LeggGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            LeggGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : jambière", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            LeggGod.setItemMeta(LeggGodMeta);

            //BootsGod
            ItemStack BootsGod = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta BootsGodMeta = BootsGod.getItemMeta();
            BootsGodMeta.setDisplayName("§4Christmas §1Boots");
            BootsGodMeta.addEnchant(Enchantment.FROST_WALKER, 5, true);
            BootsGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            BootsGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            BootsGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : bottes", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            BootsGod.setItemMeta(BootsGodMeta);

            //Patin a Glace
            ItemStack PatinGlace = new ItemStack(Material.IRON_BOOTS);
            ItemMeta PatinGlaceMeta = PatinGlace.getItemMeta();
            PatinGlaceMeta.setDisplayName("§4Patin à §1Glace");
            PatinGlaceMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            PatinGlaceMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            PatinGlaceMeta.addEnchant(Enchantment.FROST_WALKER, 5, true);
            PatinGlaceMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : Patin A Glace", "§4--------------------"));
            PatinGlace.setItemMeta(PatinGlaceMeta);

            //Item back
            ItemStack Leave = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta LeaveMeta = Leave.getItemMeta();
            LeaveMeta.setDisplayName("§bRécompenses");
            Leave.setItemMeta(LeaveMeta);

            //Item QUIT
            ItemStack Quitter = new ItemStack(Material.BARRIER);
            ItemMeta QuitterMeta = Quitter.getItemMeta();
            QuitterMeta.setDisplayName("§c~~§bQuitter§c~~");
            QuitterMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Quitter.setItemMeta(QuitterMeta);

            //HelmetGod
            ItemStack HelmetGodp = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta HelmetGodpMeta = HelmetGodp.getItemMeta();
            HelmetGodpMeta.setDisplayName("§4Christmas §1Helmet : §4 5 cadeaux");
            HelmetGodpMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            HelmetGodpMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            HelmetGodpMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : casque", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            HelmetGodp.setItemMeta(HelmetGodpMeta);

            //ChestGod
            ItemStack ChestGodp = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta ChestGodpMeta = ChestGodp.getItemMeta();
            ChestGodpMeta.setDisplayName("§4Christmas §1Chestplate : §4 5 cadeaux");
            ChestGodpMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            ChestGodpMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            ChestGodpMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : plastron", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            ChestGodp.setItemMeta(ChestGodpMeta);

            //LeggGod
            ItemStack LeggGodp = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemMeta LeggGodpMeta = LeggGodp.getItemMeta();
            LeggGodpMeta.setDisplayName("§4Christmas §1Leggings : §4 5 cadeaux");
            LeggGodpMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            LeggGodpMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            LeggGodpMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : jambière", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            LeggGodp.setItemMeta(LeggGodpMeta);

            //BootsGod
            ItemStack BootsGodp = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta BootsGodpMeta = BootsGodp.getItemMeta();
            BootsGodpMeta.setDisplayName("§4Christmas §1Boots : §4 5 cadeaux");
            BootsGodpMeta.addEnchant(Enchantment.FROST_WALKER, 5, true);
            BootsGodpMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
            BootsGodpMeta.addEnchant(Enchantment.DURABILITY, 5, true);
            BootsGodpMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : bottes", "§1Prix : §4 5 cadeaux", "§4--------------------"));
            BootsGodp.setItemMeta(BootsGodpMeta);

            giftGift.setItem(0, Leave);
            giftGift.setItem(1, Leave);
            giftGift.setItem(2, Leave);
            giftGift.setItem(3, Leave);
            giftGift.setItem(4, Leave);
            giftGift.setItem(5, Leave);
            giftGift.setItem(6, Leave);
            giftGift.setItem(7, Leave);
            giftGift.setItem(8, Leave);
            giftGift.setItem(9, Leave);
            giftGift.setItem(10, SnowLancheurp);
            giftGift.setItem(11, HelmetGodp);
            giftGift.setItem(12, ChestGodp);
            giftGift.setItem(13, LeggGodp);
            giftGift.setItem(14, BootsGodp);
            giftGift.setItem(15, PatinGlace);
            giftGift.setItem(16, Hottep);
            giftGift.setItem(17, Leave);
            giftGift.setItem(18, Leave);
            giftGift.setItem(19, Leave);
            giftGift.setItem(20, Leave);
            giftGift.setItem(21, Leave);
            giftGift.setItem(22, Leave);
            giftGift.setItem(23, Leave);
            giftGift.setItem(24, Leave);
            giftGift.setItem(25, Leave);
            giftGift.setItem(26, Quitter);

            player.openInventory(giftGift);

        }else{
            Logger.getLogger("PluginArena").warning("Vous devez etre un joueur pour utiliser cette command");
        }
        return true;
    }
}
