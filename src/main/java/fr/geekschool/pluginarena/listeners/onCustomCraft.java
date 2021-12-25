package fr.geekschool.pluginarena.listeners;

import fr.geekschool.pluginarena.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.HashMap;

public class onCustomCraft implements Listener {


    @EventHandler
    public void onPlayerCraft(PrepareItemCraftEvent ev){
        if(ev.getInventory().getMatrix().length > 9){
            return;
        }

        //Godaxe
        ItemStack GodAxe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta GodAxeMeta = GodAxe.getItemMeta();
        GodAxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GodAxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        GodAxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        GodAxeMeta.setUnbreakable(true);
        GodAxeMeta.setDisplayName("§3Pitrouflette §6Axe");
        GodAxeMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Axe",
                "§3Vous téléport la ou vous regardez",
                "§6--------------------"));
        GodAxe.setItemMeta(GodAxeMeta);

        //GodPickaxe
        ItemStack GodPickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta GodPickaxeMeta = GodPickaxe.getItemMeta();
        GodPickaxeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GodPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        GodPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        GodPickaxeMeta.setUnbreakable(true);
        GodPickaxeMeta.setDisplayName("§3Pitrouflette §6Pickaxe");
        GodPickaxeMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Pickaxe",
                "§3Summon des éclaires",
                "§6--------------------"));
        GodPickaxe.setItemMeta(GodPickaxeMeta);

        //GodHoe
        ItemStack GodHoe = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta GodHoeMeta = GodHoe.getItemMeta();
        GodHoeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GodHoeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        GodHoeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        GodHoeMeta.setUnbreakable(true);
        GodHoeMeta.setDisplayName("§3Pitrouflette §6Hoe");
        GodHoeMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Hoe",
                "§3fait apparaitre des oeufs",
                "§6--------------------"));
        GodHoe.setItemMeta(GodHoeMeta);


        //HelmetGod
        ItemStack HelmetGod = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta HelmetGodMeta = HelmetGod.getItemMeta();
        HelmetGodMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        HelmetGodMeta.addEnchant(Enchantment.THORNS, 5, true);
        HelmetGodMeta.addEnchant(Enchantment.OXYGEN, 5, true);
        HelmetGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        HelmetGodMeta.setUnbreakable(true);
        HelmetGodMeta.setDisplayName("§3Pitrouflette §6Helmet");
        HelmetGodMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Helmet",
                "§3Vous procure différents effets",
                "§6--------------------"));
        HelmetGod.setItemMeta(HelmetGodMeta);

        //ChestGod
        ItemStack ChestGod = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta ChestGodMeta = ChestGod.getItemMeta();
        ChestGodMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChestGodMeta.addEnchant(Enchantment.THORNS, 5, true);
        ChestGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        ChestGodMeta.setUnbreakable(true);
        ChestGodMeta.setDisplayName("§3Pitrouflette §6Chestplate");
        ChestGodMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Chestplate",
                "§3Vous procure différents effets",
                "§6--------------------"));
        ChestGod.setItemMeta(ChestGodMeta);

        //LeggGod
        ItemStack LeggGod = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta LeggGodMeta = LeggGod.getItemMeta();
        LeggGodMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChestGodMeta.addEnchant(Enchantment.THORNS, 5, true);
        ChestGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        ChestGodMeta.setUnbreakable(true);
        LeggGodMeta.setDisplayName("§3Pitrouflette §6Lessgins");
        LeggGodMeta.addEnchant(Enchantment.THORNS, 5, true);
        LeggGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        LeggGodMeta.setUnbreakable(true);
        LeggGodMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Leggings",
                "§3Vous procure différents effets",
                "§6--------------------"));
        LeggGod.setItemMeta(LeggGodMeta);

        //BootsGod
        ItemStack BootsGod = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta BootsGodMeta = BootsGod.getItemMeta();
        BootsGodMeta.setDisplayName("§3Pitrouflette §6Boots");
        BootsGodMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        BootsGodMeta.addEnchant(Enchantment.THORNS, 5, true);
        BootsGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
        BootsGodMeta.addEnchant(Enchantment.WATER_WORKER, 5, true);
        BootsGodMeta.addEnchant(Enchantment.SOUL_SPEED, 5, true);
        BootsGodMeta.setUnbreakable(true);
        BootsGodMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Boots",
                "§3Vous procure différents effets",
                "§6--------------------"));
        BootsGod.setItemMeta(BootsGodMeta);

        ItemStack Hotte = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta HotteMeta = Hotte.getItemMeta();
        HotteMeta.setDisplayName("§3Pitrouflette §6Sword");
        HotteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        HotteMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        HotteMeta.addEnchant(Enchantment.DAMAGE_ALL, 32000, true);
        HotteMeta.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Epée",
                "§3Elle vous permet de tuer toutes",
                "§6les entités dans un rayon de 200 blocks",
                "§6--------------------"));
        Hotte.setItemMeta(HotteMeta);

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

        ItemStack pitrouIngot = new ItemStack(Material.BRICK);
        ItemMeta pitrouIngotM = pitrouFrag.getItemMeta();
        pitrouIngotM.setDisplayName("§3Pitrouflette §6Ingot");
        pitrouIngotM.addEnchant(Enchantment.DURABILITY, 1, true);
        pitrouIngotM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pitrouIngotM.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Lingots",
                "§3Elle vous permet de craft des items en",
                "§6Pitrouflette",
                "§6--------------------"));
        pitrouIngot.setItemMeta(pitrouIngotM);

        ItemStack pitrouAssembler = new ItemStack(Material.SEA_LANTERN);
        ItemMeta pitrouAssemblerM = pitrouFrag.getItemMeta();
        pitrouAssemblerM.setDisplayName("§3Pitrouflette §6Assembler");
        pitrouAssemblerM.addEnchant(Enchantment.DURABILITY, 1, true);
        pitrouAssemblerM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pitrouAssemblerM.setLore(Arrays.asList("§6--------------------",
                "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                "§3Item Pitrouflette : Assembler",
                "§3Elle vous permet d'assembler des items en ",
                "§6Pitrouflette",
                "§6--------------------"));
        pitrouAssembler.setItemMeta(pitrouAssemblerM);

        ItemStack stick = new ItemStack(Material.STICK);

        ItemStack Sharp = new ItemStack(Material.PRISMARINE_SHARD);

        checkCrat(new ItemStack(pitrouIngot), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouFrag);
            put(3, pitrouFrag);
            put(4, pitrouAssembler);
            put(5, pitrouFrag);
            put(7, pitrouFrag);
        }});
        checkCrat(new ItemStack(pitrouAssembler), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouFrag);
            put(3, pitrouFrag);
            put(4, pitrouFrag);
            put(5, pitrouFrag);
            put(7, pitrouFrag);
        }});
        checkCrat(new ItemStack(Hotte), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouIngot);
            put(3, pitrouAssembler);
            put(4, pitrouIngot);
            put(5, pitrouAssembler);
            put(7, stick);
        }});
        checkCrat(new ItemStack(GodPickaxe), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouAssembler);
            put(3, pitrouIngot);
            put(4, pitrouIngot);
            put(5, pitrouIngot);
            put(7, stick);
        }});
        checkCrat(new ItemStack(GodAxe), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouIngot);
            put(2, pitrouIngot);
            put(4, pitrouAssembler);
            put(5, pitrouIngot);
            put(7, stick);
        }});
        checkCrat(new ItemStack(GodHoe), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(1, pitrouIngot);
            put(2, pitrouIngot);
            put(4, pitrouAssembler);
            put(7, stick);
        }});
        checkCrat(new ItemStack(HelmetGod), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(0, pitrouIngot);
            put(1, pitrouIngot);
            put(2, pitrouIngot);
            put(3, pitrouIngot);
            put(4, pitrouAssembler);
            put(5, pitrouIngot);
        }});
        checkCrat(new ItemStack(ChestGod), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(0, pitrouIngot);
            put(1, pitrouAssembler);
            put(2, pitrouIngot);
            put(3, pitrouIngot);
            put(4, pitrouIngot);
            put(5, pitrouIngot);
            put(6, pitrouIngot);
            put(7, pitrouIngot);
            put(8, pitrouIngot);
        }});
        checkCrat(new ItemStack(LeggGod), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(0, pitrouIngot);
            put(1, pitrouIngot);
            put(2, pitrouIngot);
            put(3, pitrouIngot);
            put(4, pitrouAssembler);
            put(5, pitrouIngot);
            put(6, pitrouIngot);
            put(8, pitrouIngot);
        }});
        checkCrat(new ItemStack(BootsGod), ev.getInventory(), new HashMap<Integer, ItemStack>(){{
            put(3, pitrouIngot);
            put(5, pitrouIngot);
            put(4, pitrouAssembler);
            put(6, pitrouIngot);
            put(8, pitrouIngot);
        }});

    }
    public void checkCrat(ItemStack result, CraftingInventory inv, HashMap<Integer, ItemStack> ingredients){
        ItemStack[] matrix = inv.getMatrix();
        for(int i = 0; i < 9; i++){
            if(ingredients.containsKey(i)){
                if(matrix[i] == null || !matrix[i].equals(ingredients.get(i))){
                    return;
                }
            } else {
                if(matrix[i] != null){
                    return;
                }
            }
        }
        inv.setResult(result);
    }
}