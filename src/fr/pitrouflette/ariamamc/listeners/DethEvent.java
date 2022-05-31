package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DethEvent implements Listener {

    final Main main;

    public DethEvent(Main main) {
        this.main = main;
    }

    Boolean swordV = false;
    Boolean bowV = false;
    Boolean rodV = false;

    @EventHandler
    public void OnDethEvent(PlayerDeathEvent ev){

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordM = sword.getItemMeta();
        swordM.setDisplayName(main.getConfig().getString("items.sword.name"));
        swordM.setLore(main.getConfig().getStringList("items.sword.lore"));
        swordM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        swordM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        swordM.addEnchant(Enchantment.DURABILITY, 3, true);
        sword.setItemMeta(swordM);

        ItemStack road = new ItemStack(Material.FISHING_ROD);
        ItemMeta roadM = road.getItemMeta();
        roadM.setDisplayName(main.getConfig().getString("items.rod.name"));
        roadM.setLore(main.getConfig().getStringList("items.rod.lore"));
        roadM.addEnchant(Enchantment.DURABILITY, 3, true);
        road.setItemMeta(roadM);

        ItemStack bow = new ItemStack(Material.FISHING_ROD);
        ItemMeta bowM = bow.getItemMeta();
        bowM.setDisplayName(main.getConfig().getString("items.bow.name"));
        bowM.setLore(main.getConfig().getStringList("items.bow.lore"));
        bowM.addEnchant(Enchantment.DURABILITY, 3, true);
        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowM);

        Player player = ev.getEntity();

        if(player.getInventory().contains(sword)){
            swordV = true;
        }
        if(player.getInventory().contains(road)){
            rodV = true;
        }
        if(player.getInventory().contains(bow)){
            rodV = true;
        }
    }

    @EventHandler
    public void OnRespawnEvent(PlayerRespawnEvent ev){

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordM = sword.getItemMeta();
        swordM.setDisplayName(main.getConfig().getString("items.sword.name"));
        swordM.setLore(main.getConfig().getStringList("items.sword.lore"));
        swordM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        swordM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        swordM.addEnchant(Enchantment.DURABILITY, 3, true);
        sword.setItemMeta(swordM);

        ItemStack road = new ItemStack(Material.FISHING_ROD);
        ItemMeta roadM = road.getItemMeta();
        roadM.setDisplayName(main.getConfig().getString("items.rod.name"));
        roadM.setLore(main.getConfig().getStringList("items.rod.lore"));
        roadM.addEnchant(Enchantment.DURABILITY, 3, true);
        road.setItemMeta(roadM);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowM = bow.getItemMeta();
        bowM.setDisplayName(main.getConfig().getString("items.bow.name"));
        bowM.setLore(main.getConfig().getStringList("items.bow.lore"));
        bowM.addEnchant(Enchantment.DURABILITY, 3, true);
        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowM);

        Player player = ev.getPlayer();

        if(swordV){
            player.getInventory().addItem(sword);
            //player.getInventory().removeItem(sword);
        }
        if(rodV){
            player.getInventory().addItem(road);
            //player.getInventory().removeItem(road);
        }
        if(bowV){
            player.getInventory().addItem(bow);
            //player.getInventory().removeItem(bow);
        }
    }

    @EventHandler
    public void DropItem(PlayerDropItemEvent ev){
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordM = sword.getItemMeta();
        swordM.setDisplayName(main.getConfig().getString("items.sword.name"));
        swordM.setLore(main.getConfig().getStringList("items.sword.lore"));
        swordM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        swordM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        swordM.addEnchant(Enchantment.DURABILITY, 3, true);
        sword.setItemMeta(swordM);

        ItemStack road = new ItemStack(Material.FISHING_ROD);
        ItemMeta roadM = road.getItemMeta();
        roadM.setDisplayName(main.getConfig().getString("items.rod.name"));
        roadM.setLore(main.getConfig().getStringList("items.rod.lore"));
        roadM.addEnchant(Enchantment.DURABILITY, 3, true);
        road.setItemMeta(roadM);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowM = bow.getItemMeta();
        bowM.setDisplayName(main.getConfig().getString("items.bow.name"));
        bowM.setLore(main.getConfig().getStringList("items.bow.lore"));
        bowM.addEnchant(Enchantment.DURABILITY, 3, true);
        bowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        bowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowM);
        if(ev.getItemDrop().getItemStack().equals(sword)){
            ev.setCancelled(true);
        }
        if(ev.getItemDrop().getItemStack().equals(road)){
            ev.setCancelled(true);
        }
        if(ev.getItemDrop().getItemStack().equals(bow)){
            ev.setCancelled(true);
        }
    }

}
