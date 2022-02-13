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

            ItemStack CrystalsIngot = new ItemStack(Material.PRISMARINE_SHARD);
            ItemMeta CrystalsIngotM = CrystalsIngot.getItemMeta();
            CrystalsIngotM.setDisplayName("§3Crystals §9Ingot");
            CrystalsIngotM.addEnchant(Enchantment.DURABILITY, 1, true);
            CrystalsIngotM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CrystalsIngotM.setLore(Arrays.asList("§9--------------------",
                    "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                    "§3Item Crystal : Crystals",
                    "§3Elle vous permet de craft des items en",
                    "§9Crystals",
                    "§9--------------------"));
            CrystalsIngot.setItemMeta(CrystalsIngotM);

            ItemStack CrystalsHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
            ItemMeta CrystalsHelmetM = CrystalsHelmet.getItemMeta();
            CrystalsHelmetM.setDisplayName("§3Crystals §9Helmet");
            CrystalsHelmetM.addEnchant(Enchantment.DURABILITY, 5, true);
            CrystalsHelmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            CrystalsHelmetM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CrystalsHelmetM.setLore(Arrays.asList("§9--------------------",
                    "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                    "§3Item Crystal : Helmet",
                    "§3Ceci est un pièce de l'armure en :",
                    "§9Crystals",
                    "§9--------------------"));
            CrystalsHelmet.setItemMeta(CrystalsHelmetM);

            ItemStack CrystalsCHestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            ItemMeta CrystalsCHestplateM = CrystalsCHestplate.getItemMeta();
            CrystalsCHestplateM.setDisplayName("§3Crystals §9Chestplate");
            CrystalsCHestplateM.addEnchant(Enchantment.DURABILITY, 5, true);
            CrystalsCHestplateM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            CrystalsCHestplateM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CrystalsCHestplateM.setLore(Arrays.asList("§9--------------------",
                    "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                    "§3Item Crystal : Chestplate",
                    "§3Ceci est un pièce de l'armure en :",
                    "§9Crystals",
                    "§9--------------------"));
            CrystalsCHestplate.setItemMeta(CrystalsCHestplateM);

            ItemStack CrystalsLegg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            ItemMeta CrystalsLeggM = CrystalsLegg.getItemMeta();
            CrystalsLeggM.setDisplayName("§3Crystals §9Leggings");
            CrystalsLeggM.addEnchant(Enchantment.DURABILITY, 5, true);
            CrystalsLeggM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            CrystalsLeggM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CrystalsLeggM.setLore(Arrays.asList("§9--------------------",
                    "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                    "§3Item Crystal : Leggings",
                    "§3Ceci est un pièce de l'armure en :",
                    "§9Crystals",
                    "§9--------------------"));
            CrystalsLegg.setItemMeta(CrystalsLeggM);

            ItemStack CrystalsBoot = new ItemStack(Material.CHAINMAIL_BOOTS);
            ItemMeta CrystalsBootM = CrystalsBoot.getItemMeta();
            CrystalsBootM.setDisplayName("§3Crystals §9Boots");
            CrystalsBootM.addEnchant(Enchantment.DURABILITY, 5, true);
            CrystalsBootM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
            CrystalsBootM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CrystalsBootM.setLore(Arrays.asList("§9--------------------",
                    "§e⭐⭐⭐⭐⭐⭐⭐⭐",
                    "§3Item Crystal : Boots",
                    "§3Ceci est un pièce de l'armure en :",
                    "§9Crystals",
                    "§9--------------------"));


            Player player = (Player) ev.getWhoClicked();

            if (ev.getView().getTitle().contains("Crystals")) {


                if (current != null) {

                    if (current.getItemMeta().getDisplayName().equals(" ")) {
                        ev.setCancelled(true);
                    }

                    if (current.getItemMeta().getDisplayName().contains("§3Asembler")) {
                        ev.setCancelled(true);

                        if (ev.getInventory().getItem(20).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(28).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(29).getItemMeta().getDisplayName().contains("Ingot") && ev.getInventory().getItem(30).getItemMeta().getDisplayName().contains("Assembler") && ev.getInventory().getItem(38).getType().equals(Material.STICK)) {

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