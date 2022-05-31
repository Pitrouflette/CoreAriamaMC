package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LinkedChest implements Listener {

    final Main main;

    public LinkedChest(Main main) {

        this.main = main;

    }

    @EventHandler
    public void onPlayerLinkChest(PlayerInteractEvent ev){
        if(ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(ev.getItem() != null && ev.getClickedBlock() != null){
                if(ev.getItem().getType().equals(Material.NETHER_STAR) && ev.getClickedBlock().getType().equals(Material.CHEST)){
                    Block b = ev.getClickedBlock();
                    ItemStack netherStart = ev.getItem();
                    ItemMeta meta = netherStart.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(b.getX() + ";" + b.getY() + ";" + b.getZ());
                    meta.setLore(lore);
                    meta.setDisplayName("§eLinkedChest");
                    netherStart.setItemMeta(meta);
                }
            }
        }
    }

    @EventHandler
    public void OnPlayerOpenLinkedChest(PlayerInteractEvent e){
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(e.getItem()!= null){
                if( e.getItem().getType().equals(Material.NETHER_STAR)){
                    if(e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getLore() != null){
                        List<String> lore = e.getItem().getItemMeta().getLore();
                        String [] locationXYZ = lore.get(0).split(";");
                        int x = Integer.parseInt(locationXYZ[0]);
                        int y = Integer.parseInt(locationXYZ[1]);
                        int z = Integer.parseInt(locationXYZ[2]);
                        BlockState bs = e.getPlayer().getWorld().getBlockAt(x, y, z).getState();
                        Chest c = (Chest) bs;
                        if(main.getConfig().getBoolean("linkedchest.status.allow")){
                            e.getPlayer().openInventory(c.getInventory());
                        }else{
                            e.getPlayer().sendMessage(main.getConfig().getString("linkedchest.status.deny").replace("&", "§"));
                        }
                    }
                }
            }
        }
    }
}