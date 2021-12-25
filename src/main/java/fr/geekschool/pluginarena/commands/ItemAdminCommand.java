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

public class ItemAdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory invItem =  Bukkit.createInventory(null, 54, " §e⭐⭐§4Admin Items AvariaMC§e⭐⭐");

            //Item Sword Christmas
            ItemStack Hotte = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta HotteMeta = Hotte.getItemMeta();
            HotteMeta.setDisplayName("§4Christmas §1Sword");
            HotteMeta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
            HotteMeta.setLore(Arrays.asList("§4--------------------", "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐", "§1Item Illégal : Epée", "§1Cette Item est : §4 Inopptensible In-Game", "§1Elle vous permet de tuer toutes", "§4les entités dans un rayon de 25 block", "§4--------------------"));
            Hotte.setItemMeta(HotteMeta);

            //ItemPiocheLegendaire
            ItemStack ItemPiocheLegendaire = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta ItemPiocheLegendaireM = ItemPiocheLegendaire.getItemMeta();
            ItemPiocheLegendaireM.setDisplayName("§bLégendary Pickaxe");
            ItemPiocheLegendaireM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ItemPiocheLegendaireM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ItemPiocheLegendaireM.setLore(Arrays.asList("§4Pioche Légendaire §e⭐⭐⭐⭐⭐", "§1Cette Item fait partie de la gamme légendaire !!"));
            ItemPiocheLegendaireM.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
            ItemPiocheLegendaireM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
            ItemPiocheLegendaireM.addEnchant(Enchantment.DIG_SPEED, 9, true);
            ItemPiocheLegendaireM.addEnchant(Enchantment.DURABILITY, 7, true);
            ItemPiocheLegendaire.setItemMeta(ItemPiocheLegendaireM);

            //ItemPiocheSupreme
            ItemStack PiocheSupreme = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta PiocheSupremeM = ItemPiocheLegendaire.getItemMeta();
            PiocheSupremeM.setDisplayName("§bSuprême Pickaxe");
            PiocheSupremeM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            PiocheSupremeM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            PiocheSupremeM.setLore(Arrays.asList("§4Pioche suprême §e⭐⭐⭐", "§1Cette Item fait partie de la gamme Suprême !!"));
            PiocheSupremeM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
            PiocheSupremeM.addEnchant(Enchantment.DIG_SPEED, 6, true);
            PiocheSupremeM.addEnchant(Enchantment.DURABILITY, 4, true);
            PiocheSupreme.setItemMeta(PiocheSupremeM);

            //ItemPiocheEpique
            ItemStack ItemPiocheEpique = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta ItemPiocheEpiqueM = ItemPiocheLegendaire.getItemMeta();
            ItemPiocheEpiqueM.setDisplayName("§bEpique Pickaxe");
            ItemPiocheEpiqueM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ItemPiocheEpiqueM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ItemPiocheEpiqueM.setLore(Arrays.asList("§4Pioche épique §e⭐⭐", "§1Cette Item fait partie de la gamme Epique !!"));
            ItemPiocheEpiqueM.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
            ItemPiocheEpiqueM.addEnchant(Enchantment.DIG_SPEED, 4, true);
            ItemPiocheEpiqueM.addEnchant(Enchantment.DURABILITY, 3, true);
            ItemPiocheEpique.setItemMeta(ItemPiocheEpiqueM);

            //ItemBorder
            ItemStack ItemBorder = new ItemStack(Material.STONE);
            ItemMeta ItemBorderMeta = ItemBorder.getItemMeta();
            ItemBorderMeta.setDisplayName("§bItemAdmin");
            ItemBorderMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ItemBorderMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ItemBorderMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            ItemBorder.setItemMeta(ItemBorderMeta);

            //Items KBstick
            ItemStack KBstick = new ItemStack(Material.STICK);
            ItemMeta KBstickMeta = KBstick.getItemMeta();
            KBstickMeta.setDisplayName("§bKB stick");
            KBstickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            KBstickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            KBstickMeta.setLore(Arrays.asList("§4KB stick §e⭐⭐⭐⭐⭐", "§1Cette Item fait partie de la gamme légendaire !!"));
            KBstickMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 6, true);
            KBstick.setItemMeta(KBstickMeta);

            //item Sword
            ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta SwordMeta = Sword.getItemMeta();
            SwordMeta.setDisplayName("§bLégendary Sword");
            SwordMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            SwordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            SwordMeta.setLore(Arrays.asList("§4Epée légendaire §e⭐⭐⭐⭐⭐", "§1Cette Item fait partie de la gamme légendaire !!"));
            SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
            SwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
            SwordMeta.addEnchant(Enchantment.KNOCKBACK, 4, true);
            SwordMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 4, true);
            Sword.setItemMeta(SwordMeta);

            //item Bow
            ItemStack Bow = new ItemStack(Material.BOW);
            ItemMeta BowMeta = Bow.getItemMeta();
            BowMeta.setDisplayName("§bLégendary Bow");
            BowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            BowMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            BowMeta.setLore(Arrays.asList("§4Arc légendaire §e⭐⭐⭐⭐⭐", "§1Cette Item fait partie de la gamme légendaire !!"));
            BowMeta.addEnchant(Enchantment.ARROW_FIRE, 3, true);
            BowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 7, true);
            BowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            BowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 4, true);
            Bow.setItemMeta(BowMeta);

            //Item VoteKeys
            ItemStack VoteKeys = new ItemStack(Material.TRIPWIRE_HOOK);
            ItemMeta VoteKeysMeta = VoteKeys.getItemMeta();
            VoteKeysMeta.setDisplayName("§e⭐⭐§4Clée de Vote§e⭐⭐");
            VoteKeysMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
            VoteKeysMeta.setLore(Arrays.asList("§4Clée de vote §e⭐⭐⭐", "§1Obtenez des récompense quotidiennes !!"));
            VoteKeys.setItemMeta(VoteKeysMeta);

            //                  ARMURE AVARIENNE

            //Plastron
            ItemStack Plastron = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta PlastronMeta = Plastron.getItemMeta();
            PlastronMeta.setDisplayName("§bAvarienne chestplate");
            PlastronMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            PlastronMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            PlastronMeta.setLore(Arrays.asList("§3----------------------------", "§4Avarienne Chestplate §3⭐⭐⭐⭐⭐", "§1Cette Item fait partie de la gamme §3Avarienne !!", "§3----------------------------"));
            PlastronMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            PlastronMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
            PlastronMeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
            PlastronMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
            PlastronMeta.addEnchant(Enchantment.DURABILITY, 20, true);
            PlastronMeta.addEnchant(Enchantment.THORNS, 3, true);
            Plastron.setItemMeta(PlastronMeta);

            //Helmet
            ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta HelmetMeta = Helmet.getItemMeta();
            HelmetMeta.setDisplayName("§bAvarienne helmet");
            HelmetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            HelmetMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            HelmetMeta.setLore(Arrays.asList("§3----------------------------", "§4Avarienne helmet §3⭐⭐⭐⭐⭐",  "§1Cette Item fait partie de la gamme §3Avarienne !!", "§3----------------------------"));
            HelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            HelmetMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
            HelmetMeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
            HelmetMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
            HelmetMeta.addEnchant(Enchantment.DURABILITY, 20, true);
            HelmetMeta.addEnchant(Enchantment.THORNS, 3, true);
            HelmetMeta.addEnchant(Enchantment.OXYGEN, 5, true);
            Helmet.setItemMeta(HelmetMeta);

            //Leggings
            ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta LeggingsMeta = Leggings.getItemMeta();
            LeggingsMeta.setDisplayName("§bAvarienne helmet");
            LeggingsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            LeggingsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            LeggingsMeta.setLore(Arrays.asList("§3----------------------------", "§4Avarienne leggings §3⭐⭐⭐⭐⭐",  "§1Cette Item fait partie de la gamme §3Avarienne !!", "§3----------------------------"));
            LeggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            LeggingsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
            LeggingsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
            LeggingsMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
            LeggingsMeta.addEnchant(Enchantment.DURABILITY, 20, true);
            LeggingsMeta.addEnchant(Enchantment.THORNS, 3, true);
            Leggings.setItemMeta(LeggingsMeta);

            //Boots
            ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta BootsMeta = Boots.getItemMeta();
            BootsMeta.setDisplayName("§bAvarienne boots");
            BootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            BootsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            BootsMeta.setLore(Arrays.asList("§3----------------------------", "§4Avarienne boots §3⭐⭐⭐⭐⭐",  "§1Cette Item fait partie de la gamme §3Avarienne !!", "§3----------------------------"));
            BootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            BootsMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
            BootsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
            BootsMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
            BootsMeta.addEnchant(Enchantment.DURABILITY, 20, true);
            BootsMeta.addEnchant(Enchantment.WATER_WORKER, 2, true);
            BootsMeta.addEnchant(Enchantment.THORNS, 3, true);
            Boots.setItemMeta(BootsMeta);

            invItem.setItem(0, KBstick);
            invItem.setItem(1, Sword);
            invItem.setItem(2, Bow);
            invItem.setItem(3, VoteKeys);
            invItem.setItem(4, ItemPiocheLegendaire);
            invItem.setItem(5, PiocheSupreme);
            invItem.setItem(6, ItemPiocheEpique);
            invItem.setItem(7, Helmet);
            invItem.setItem(8, Plastron);
            invItem.setItem(9, Leggings);
            invItem.setItem(10, Boots);
            invItem.setItem(11, Hotte);

            player.openInventory(invItem);
        }
            return true;
    }
}
