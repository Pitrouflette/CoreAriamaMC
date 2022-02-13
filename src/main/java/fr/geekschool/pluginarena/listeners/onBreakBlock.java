package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;


public class onBreakBlock implements Listener {

    @EventHandler
    public void onBreakBloc(EntityDeathEvent ev){
        Player player = ev.getEntity().getKiller();

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

        if(ev.getEntity().getType().equals(EntityType.ENDERMAN)){
            Random randomno = new Random();
            int randomIndex = randomno.nextInt(10);
            if(randomIndex == 3){
                player.sendTitle("Vous avez récupéré", " Un fragement de ???");
                player.getInventory().addItem(CrystalsFrag);
            }
        }
    }
}
