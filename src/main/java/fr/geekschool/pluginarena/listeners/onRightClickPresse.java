package fr.geekschool.pluginarena.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
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
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class onRightClickPresse implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent ev){
        Player player = ev.getPlayer();
        if(player.getItemInHand().hasItemMeta()){

            if(player.getItemInHand().getItemMeta().getDisplayName().contains("Carte")){

                if(ev.getAction() == Action.RIGHT_CLICK_AIR){

                    Inventory inv = Bukkit.createInventory(null, 9, "Carte de Presse");

                    //Item Border
                    ItemStack border = new ItemStack(Material.CYAN_STAINED_GLASS_PANE);
                    ItemMeta borderM = border.getItemMeta();
                    borderM.setDisplayName(" ");
                    borderM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    borderM.addEnchant(Enchantment.DURABILITY, 1, false);
                    border.setItemMeta(borderM);

                    ItemStack head = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

                    SkullMeta meta = (SkullMeta) head.getItemMeta();

                    meta.setOwningPlayer(player);
                    meta.setDisplayName("§eInfomation sur §b" + player.getName());
                    meta.setLore(Arrays.asList(" ",
                            "§eJoueur: §b" + player.getName(),
                            "§eUUID: §b" + player.getUniqueId(),
                            "",
                            "§eVie: §b" + player.getHealth(),
                            "§eNourriture: §b" + player.getFoodLevel(),
                            "§eXP: §b" + player.getLevel(),
                            " ",
                            "§ePosition: ",
                            "§eMonde: §b" + player.getWorld().getName(),
                            "§eX: §b" + player.getLocation().getX(),
                            "§eY: §b" + player.getLocation().getY(),
                            "§eZ: §b" + player.getLocation().getZ(),
                            "§eYaw: §b" + player.getLocation().getYaw(),
                            "§ePitch: §b" + player.getLocation().getPitch()
                    ));

                    head.setItemMeta(meta);

                    inv.setItem(0, border);
                    inv.setItem(1, border);
                    inv.setItem(2, border);
                    inv.setItem(3, border);
                    inv.setItem(4, border);
                    inv.setItem(5, border);
                    inv.setItem(6, border);
                    inv.setItem(7, border);
                    inv.setItem(8, head);

                    player.openInventory(inv);

                }
            }
        }
    }
}
