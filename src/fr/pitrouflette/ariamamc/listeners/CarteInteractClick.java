package fr.pitrouflette.ariamamc.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CarteInteractClick implements Listener {


    @EventHandler
    public void GuiPrincipale(PlayerInteractEvent ev){

        if (ev.getAction() == Action.LEFT_CLICK_BLOCK || ev.getAction() == Action.LEFT_CLICK_AIR || ev.getAction() == Action.RIGHT_CLICK_BLOCK || ev.getAction() == Action.RIGHT_CLICK_AIR){
            if (ev.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Carte")) {
                Player player = ev.getPlayer();

                Inventory inv = Bukkit.createInventory(null, 54, "            §c~~§bCarte§c~~");

                //ItemSpawn
                ItemStack Spawn = new ItemStack(Material.BED);
                ItemMeta SpawnMeta = Spawn.getItemMeta();
                SpawnMeta.setDisplayName("§c~~§bSpawn§c~~");
                SpawnMeta.setLore(Arrays.asList("Vous téléporte au Spawn"));
                SpawnMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Spawn.setItemMeta(SpawnMeta);

                //Item Faction
                ItemStack Faction = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta FactionMeata = Faction.getItemMeta();
                FactionMeata.setDisplayName("§c~~§bRTP§c~~");
                FactionMeata.setLore(Arrays.asList("Vous téléporte aléatoirement sur le monde..."));
                FactionMeata.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Faction.setItemMeta(FactionMeata);

                //Item Minage
                ItemStack Minage = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta MinageMeta = Spawn.getItemMeta();
                MinageMeta.setDisplayName("§c~~§bFarm§c~~");
                MinageMeta.setLore(Arrays.asList("Vous téléporte aléatoirement pour farmer/miner"));
                MinageMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Minage.setItemMeta(MinageMeta);


                //SkyCity
                ItemStack SkyCity = new ItemStack(Material.FEATHER);
                ItemMeta SkyCityMeta = SkyCity.getItemMeta();
                SkyCityMeta.setDisplayName("§c~~§bSkyCity§c~~");
                SkyCityMeta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
                SkyCityMeta.setLore(Arrays.asList("Vous téléporte à l'acceuil de la ville SkyCity"));
                SkyCityMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                SkyCityMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                SkyCity.setItemMeta(SkyCityMeta);

                //Arène
                ItemStack Arena = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta ArenaMeta = Arena.getItemMeta();
                ArenaMeta.setDisplayName("§c~~§bArene§c~~");
                ArenaMeta.setLore(Arrays.asList("Vous téléporte au monde Arène", "Attention, le PvP est activé"));
                ArenaMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Arena.setItemMeta(ArenaMeta);

                //FlamCity
                ItemStack FlamCity = new ItemStack(Material.FLINT_AND_STEEL);
                ItemMeta FlamCityMeta = SkyCity.getItemMeta();
                FlamCityMeta.setDisplayName("§c~~§bFlamCity§c~~");
                FlamCityMeta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
                FlamCityMeta.setLore(Arrays.asList("Vous téléporte à l'acceuil de la ville FlamCity"));
                FlamCityMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                FlamCityMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                FlamCity.setItemMeta(FlamCityMeta);

                //Ville3
                ItemStack Ville3 = new ItemStack(Material.WOOD);
                ItemMeta Ville3Meta = Ville3.getItemMeta();
                Ville3Meta.setDisplayName("§c~~§bTreeCity3§c~~");
                Ville3Meta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
                Ville3Meta.setLore(Arrays.asList("Vous téléporte à l'acceuil de TreeCity"));
                Ville3Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Ville3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Ville3.setItemMeta(Ville3Meta);

                //Item QUIT
                ItemStack Quitter = new ItemStack(Material.BARRIER);
                ItemMeta QuitterMeta = Quitter.getItemMeta();
                QuitterMeta.setDisplayName("§c~~§bQuitter§c~~");
                QuitterMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                Quitter.setItemMeta(QuitterMeta);

                inv.setItem(10, Spawn);
                inv.setItem(13, Faction);
                inv.setItem(16, Minage);
                inv.setItem(28, SkyCity);
                inv.setItem(31, FlamCity);
                inv.setItem(34, Ville3);
                inv.setItem(49, Arena);
                inv.setItem(53, Quitter);

                player.openInventory(inv);

            }
        }
    }
}
