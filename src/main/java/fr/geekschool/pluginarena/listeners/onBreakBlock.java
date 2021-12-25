package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;


public class onBreakBlock implements Listener {

    @EventHandler
    public void onBreakBloc(BlockBreakEvent ev){
        Player player = ev.getPlayer();

        ItemStack pitrouFrag = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta pitrouFragM = pitrouFrag.getItemMeta();
        pitrouFragM.setDisplayName("§3Pitrouflette §6Fragment");
        pitrouFragM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pitrouFragM.addEnchant(Enchantment.DURABILITY, 1, true);
        pitrouFragM.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Fragement",
                "§3Elle vous permet de craft des lingots de",
                "§6Pitrouflette",
                "§6--------------------"));
        pitrouFrag.setItemMeta(pitrouFragM);

        if(ev.getBlock().getType().equals(Material.PRISMARINE)){
            Random randomno = new Random();
            int randomIndex = randomno.nextInt(1000);
            if(randomIndex == 3){
                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 4, 4);
                player.getInventory().addItem(pitrouFrag);
            }
        }
    }
}
