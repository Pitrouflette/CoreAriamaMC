package fr.childish.coreariama.commands;

import java.util.ArrayList;

import fr.childish.coreariama.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hammer implements Listener, CommandExecutor {
    public Hammer(Main main) {
    }

    public Hammer() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hammer")) {
            Player target;
            ItemStack item;
            ItemMeta itemMeta;
            ArrayList itemLore;
            if (sender instanceof Player) {
                Player p = (Player)sender;
                if (p.hasPermission("starlux.hammer")) {
                    if (args.length == 0) {
                        p.sendMessage("§cErreur : /hammer <pseudo>");
                    }

                    if (args.length == 1) {
                        target = Bukkit.getPlayerExact(args[0]);
                        if (target == null) {
                            p.sendMessage("§cCe joueur n'est pas connecté.");
                        } else {
                            p.sendMessage("§aVous avez donné §ex1 Hammer§a au joueur " + target.getName());
                            item = new ItemStack(Material.GOLD_PICKAXE);
                            itemMeta = item.getItemMeta();
                            itemMeta.setDisplayName("§e§lHammer");
                            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                            itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                            itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                            item.setItemMeta(itemMeta);
                            target.getInventory().addItem(new ItemStack[]{item});
                        }
                    }
                } else {
                    p.sendMessage("§cVous n'avez pas la permission d'exécuter cette commande.");
                }
            } else {
                if (args.length == 0) {
                    sender.sendMessage("§cErreur : /hammer <pseudo>");
                }

                if (args.length == 1) {
                    target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        sender.sendMessage("§cCe joueur n'est pas connecté.");
                    } else {
                        sender.sendMessage("§aVous avez donné §ex1 Hammer§a au joueur " + target.getName());
                        item = new ItemStack(Material.GOLD_PICKAXE);
                        itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName("§e§lHammer");
                        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        itemMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                        item.setItemMeta(itemMeta);
                        target.getInventory().addItem(new ItemStack[]{item});
                    }
                }
            }
        }
        return false;
    }
}