package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CarteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            Inventory Carte = Bukkit.createInventory(null, 27,              "§bCarte");


            //ItemSpawn
            ItemStack Spawn = new ItemStack(Material.HEART_OF_THE_SEA);
            ItemMeta SpawnMeta = Spawn.getItemMeta();
            SpawnMeta.setDisplayName("§bSpawn");
            SpawnMeta.setLore(Arrays.asList("Vous téléporte au Spawn"));
            SpawnMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Spawn.setItemMeta(SpawnMeta);

            //Arène
            ItemStack Arena = new ItemStack(Material.SHIELD);
            ItemMeta ArenaMeta = Arena.getItemMeta();
            ArenaMeta.setDisplayName("§bWarZone");
            ArenaMeta.setLore(Arrays.asList("Vous téléporte au monde WarZone", "Attention, le PvP est activé"));
            ArenaMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Arena.setItemMeta(ArenaMeta);

            //Bw
            ItemStack Bw = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta BwMeta = Bw.getItemMeta();
            BwMeta.setDisplayName("§bZonTuto");
            BwMeta.setLore(Arrays.asList("Vous téléporte à la zone Tuto"));
            BwMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Bw.setItemMeta(BwMeta);

            //Item QUIT
            ItemStack Quitter = new ItemStack(Material.BARRIER);
            ItemMeta QuitterMeta = Quitter.getItemMeta();
            QuitterMeta.setDisplayName("§bQuitter");
            QuitterMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Quitter.setItemMeta(QuitterMeta);

            //Item Base
            ItemStack Base = new ItemStack(Material.LEATHER);
            ItemMeta BaseMeta = Base.getItemMeta();
            BaseMeta.setDisplayName("§b/f home");
            BaseMeta.setLore(Arrays.asList("Vous téléporte a votre home de faction", "Attention, vous devez avoir défini votre f home"));
            BaseMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Base.setItemMeta(BaseMeta);

            //Item back
            ItemStack Leave = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta LeaveMeta = Leave.getItemMeta();
            LeaveMeta.setDisplayName("§bCarte");
            Leave.setItemMeta(LeaveMeta);

            Carte.setItem(0, Leave);
            Carte.setItem(1, Leave);
            Carte.setItem(2, Leave);
            Carte.setItem(3, Leave);
            Carte.setItem(4, Leave);
            Carte.setItem(5, Leave);
            Carte.setItem(6, Leave);
            Carte.setItem(7, Leave);
            Carte.setItem(8, Leave);
            Carte.setItem(9, Leave);
            Carte.setItem(10, Spawn);
            Carte.setItem(12, Arena);
            Carte.setItem(14, Base);
            Carte.setItem(16, Bw);
            Carte.setItem(17, Leave);
            Carte.setItem(18, Leave);
            Carte.setItem(19, Leave);
            Carte.setItem(20, Leave);
            Carte.setItem(21, Leave);
            Carte.setItem(22, Leave);
            Carte.setItem(23, Leave);
            Carte.setItem(24, Leave);
            Carte.setItem(25, Leave);
            Carte.setItem(26, Quitter);

            player.openInventory(Carte);


        }
        return true;
    }
}