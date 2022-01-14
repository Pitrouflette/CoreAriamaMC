package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class onClickCustomCraftInv implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent ev) {

        ItemStack current = ev.getCurrentItem();

        if (ev.getView().getTitle().contains("Carte de")) {

            if (current != null) {

                if (current.getItemMeta().getDisplayName().equals(" ")) {
                    ev.setCancelled(true);
                }

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


            Player player = (Player) ev.getWhoClicked();

            if (ev.getView().getTitle().contains("Pitrouflette")) {


                if (current != null) {

                    if (current.getItemMeta().getDisplayName().equals(" ")) {
                        ev.setCancelled(true);
                    }
                    if (current.getItemMeta().getDisplayName().contains("§3Assembler")) {
                        ev.setCancelled(true);
                        int craft1 = 19;
                        int craft2 = 20;
                        int craft3 = 21;
                        int craft4 = 28;
                        int craft5 = 29;
                        int craft6 = 30;
                        int craft7 = 37;
                        int craft8 = 38;
                        int craft9 = 39;
                        String ingot = "Ingot";
                        String frag = "Fragment";
                        String assembler = "Assembler";
                        String stick = "Stick";
                        if (ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(28).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(38).getType().equals(Material.STICK)) {

                            ev.getInventory().setItem(34, Hotte);
                            ev.getInventory().setItem(19, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(20, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(21, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(28, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(29, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(30, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(37, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(38, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(39, new ItemStack(Material.AIR));

                        } else if (ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Fragment") && ev.getInventory().getItem(28).getItemMeta().getDisplayName().contains("Fragment") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Fragment") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Fragment")) {

                            ev.getInventory().setItem(34, pitrouIngot);
                            ev.getInventory().setItem(19, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(20, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(21, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(28, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(29, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(30, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(37, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(38, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(39, new ItemStack(Material.AIR));

                        } else if (ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(28).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(38).getType().equals(Material.STICK)) {

                            ev.getInventory().setItem(34, GodPickaxe);
                            ev.getInventory().setItem(19, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(20, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(21, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(28, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(29, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(30, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(37, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(38, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(39, new ItemStack(Material.AIR));

                        } else if ((ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(28).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(38).getType().equals(Material.STICK))) {

                            ev.getInventory().setItem(34, GodAxe);
                            ev.getInventory().setItem(19, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(20, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(21, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(28, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(29, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(30, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(37, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(38, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(39, new ItemStack(Material.AIR));

                        } else if(ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(21).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(38).getType().equals(Material.STICK)){
                            ev.getInventory().setItem(34, GodHoe);
                            ev.getInventory().setItem(19, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(20, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(21, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(28, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(29, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(30, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(37, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(38, new ItemStack(Material.AIR));
                            ev.getInventory().setItem(39, new ItemStack(Material.AIR));
                        }
                    }
                }
            }
        }
    }
}