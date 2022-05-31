package fr.pitrouflette.ariamamc;

import fr.pitrouflette.ariamamc.commands.AriamaMc;
import fr.pitrouflette.ariamamc.commands.ArmureRepair;
import fr.pitrouflette.ariamamc.commands.ArmureUpUnbreaking;
import fr.pitrouflette.ariamamc.commands.UpPro;
import fr.pitrouflette.ariamamc.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        getCommand("armureupunbreaking").setExecutor(new ArmureUpUnbreaking());
        getCommand("armureupprotection").setExecutor(new UpPro());
        getCommand("armurerepair").setExecutor(new ArmureRepair());
        getCommand("ariamamc").setExecutor(new AriamaMc(this));

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(this), this);
        manager.registerEvents(new QuitListener(this), this);
        manager.registerEvents(new SpawnCustomMobs(), this);
        manager.registerEvents(new TeleportPadEvent(this), this);
        manager.registerEvents(new LinkedChest(this), this);
        manager.registerEvents(new BlockedWordsUsage(this), this);
        manager.registerEvents(new ProtectOpGM(this), this);

        getServer().getConsoleSender().sendMessage("§1[PluginAriamaMC]§b-------------------------------------------------------------------");
        getServer().getConsoleSender().sendMessage("§1[PluginAriamaMC] §6Le plugin PluginAriamaMC fait par Pitrouflette a été initialisé avec succès");
        getServer().getConsoleSender().sendMessage("§1[PluginAriamaMC]§b-------------------------------------------------------------------");

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Emerald Sword");
        item.setItemMeta(meta);
        item.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape(" E ", " E ", " S ");
        recipe.setIngredient('E', Material.EMERALD);
        recipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(recipe);

        //------------------------------Items---------------------------------------//
        //         Ingot            //
        ItemStack Ingot = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta IngotM = Ingot.getItemMeta();
        IngotM.setDisplayName("§1Lingot de §bCrystal");
        IngotM.addEnchant(Enchantment.DURABILITY, 1, true);
        IngotM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Ingot.setItemMeta(IngotM);
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

        //------------------------------Recipes---------------------------------------//
        //         Ingot            //
        ShapedRecipe scingot = new ShapedRecipe(Ingot);
        scingot.shape("FFF", "FFF", "FFF");
        scingot.setIngredient('F', Material.PRISMARINE_CRYSTALS);
        Bukkit.getServer().addRecipe(scingot);
        //         Helmet            //
        ShapedRecipe crH = new ShapedRecipe(Helmet);
        crH.shape("III", "I I", "   ");
        crH.setIngredient('I', Material.PRISMARINE_SHARD);
        Bukkit.getServer().addRecipe(crH);
        //         Chestplate      //
        ShapedRecipe crC = new ShapedRecipe(Chestplate);
        crC.shape("I I", "III", "III");
        crC.setIngredient('I', Material.PRISMARINE_SHARD);
        Bukkit.getServer().addRecipe(crC);
        //        Leggings          //
        ShapedRecipe crL = new ShapedRecipe(Leggings);
        crL.shape("III", "I I", "I I");
        crL.setIngredient('I', Material.PRISMARINE_SHARD);
        Bukkit.getServer().addRecipe(crL);
        //         Boots            //
        ShapedRecipe crB = new ShapedRecipe(Boots);
        crB.shape("   ", "I I", "I I");
        crB.setIngredient('I', Material.PRISMARINE_SHARD);
        Bukkit.getServer().addRecipe(crB);

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§1[PluginAriamMC]§b-------------------------------------------------------------------");
        getServer().getConsoleSender().sendMessage("§1[PluginAriamMC] §6Le plugin PluginAriamaMC fait par Pitrouflette a été éteint avec succès");
        getServer().getConsoleSender().sendMessage("§1[PluginAriamaMC]§b-------------------------------------------------------------------");
    }
}