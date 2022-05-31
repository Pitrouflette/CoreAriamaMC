package fr.pitrouflette.ariamamc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class SpawnCustomMobs implements Listener {

    @EventHandler
    public void OnSpawnMob(EntitySpawnEvent ev){

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Emerald Sword");
        item.setItemMeta(meta);

        ItemStack Chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta ChestplateM = Chestplate.getItemMeta();
        ChestplateM.setDisplayName("§1Plastron de §bCrystal");
        ChestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        ChestplateM.addEnchant(Enchantment.DURABILITY, 10, true);
        Chestplate.setItemMeta(ChestplateM);

        if(!ev.getEntity().getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END)){
            return;
        }

        if(!ev.getEntity().getType().equals(EntityType.ENDERMAN)){
            return;
        }

        Enderman enderman = (Enderman) ev.getEntity();
        enderman.setHealth(0);

        Skeleton skeleton = (Skeleton) ev.getEntity().getLocation().getWorld().spawnEntity(ev.getEntity().getLocation(), EntityType.SKELETON);

        ((Enderman) ev.getEntity()).setHealth(0);

        skeleton.setMaxHealth(100);
        skeleton.setHealth(100);
        skeleton.setCustomNameVisible(true);
        skeleton.setCustomName("§2⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        skeleton.getEquipment().setItemInHand(item);
        skeleton.getEquipment().setItemInHandDropChance(0f);
        skeleton.getEquipment().setHelmetDropChance(0f);
        skeleton.getEquipment().setChestplateDropChance(0f);
        skeleton.getEquipment().setChestplate(Chestplate);
    }

    @EventHandler
    public void OnEntityTackDamage(EntityDamageEvent ev){

        if(!ev.getEntity().getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END)){
            return;
        }

        Skeleton skeletonn = (Skeleton) ev.getEntity();

        if(skeletonn.getHealth() > 90){
            skeletonn.setCustomName("§2⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 80 && skeletonn.getHealth() < 90){
            skeletonn.setCustomName("§2⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 70 && skeletonn.getHealth() < 80){
            skeletonn.setCustomName("§a⬛⬛⬛⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 60 && skeletonn.getHealth() < 70){
            skeletonn.setCustomName("§6⬛⬛⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 50 && skeletonn.getHealth() < 60){
            skeletonn.setCustomName("§6⬛⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 40 && skeletonn.getHealth() < 50){
            skeletonn.setCustomName("§c⬛⬛⬛⬛");
        }else if(skeletonn.getHealth() > 30 && skeletonn.getHealth() < 40){
            skeletonn.setCustomName("§c⬛⬛⬛");
        }else if(skeletonn.getHealth() > 20 && skeletonn.getHealth() < 30){
            skeletonn.setCustomName("§4⬛⬛");
        }else if(skeletonn.getHealth() > 10 && skeletonn.getHealth() < 20){
            skeletonn.setCustomName("§4⬛");
        }
        ev.getEntity().setCustomNameVisible(true);
    }

    @EventHandler
    public void OnKillEntity(EntityDeathEvent ev){

        ItemStack fragment = new ItemStack(Material.PRISMARINE_CRYSTALS);
        ItemMeta fragmentMeta = fragment.getItemMeta();
        fragmentMeta.setDisplayName("§1Fragment de §bCrystal");
        fragmentMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        fragmentMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        fragment.setItemMeta(fragmentMeta);

        if(!ev.getEntity().getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END) && !ev.getEntity().equals(EntityType.ENDERMAN)){
            return;
        }

        Player player = (Player) ev.getEntity().getKiller();

        Random randomo = new Random();
        int randomIndex = randomo.nextInt(50);

        if(randomIndex == 1){
            player.sendTitle("§c§l §6§lFelicitation§c§l", "§eVous avez récupéré un §6§lfragement de crystal");
            player.getInventory().addItem(fragment);
        }
    }
}