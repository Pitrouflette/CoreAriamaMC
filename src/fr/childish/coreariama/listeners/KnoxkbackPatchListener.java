package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class KnoxkbackPatchListener implements Listener {

    public KnoxkbackPatchListener(Main main) {

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        if (itemStack != null) {
            if (itemStack.getEnchantments().containsKey(Enchantment.KNOCKBACK)) {
                event.setCancelled(true);
                player.getInventory().removeItem(new ItemStack[]{itemStack});
                player.updateInventory();
                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onDrop(ItemSpawnEvent event) {
        if (event.getEntity().getItemStack().getEnchantments().containsKey(Enchantment.KNOCKBACK)) {
            event.getEntity().remove();
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player)entity;
            ItemStack itemStack = player.getItemInHand();
            if (itemStack == null) {
                return;
            }

            if (itemStack.getEnchantments().containsKey(Enchantment.KNOCKBACK)) {
                itemStack.setType(Material.AIR);
                player.updateInventory();
            }
        }
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        if (event.getEnchantsToAdd().containsKey(Enchantment.KNOCKBACK)) {
            event.setCancelled(true);
            event.getEnchanter().closeInventory();
        }
    }
}