package fr.geekschool.pluginarena.listeners;

import fr.geekschool.pluginarena.Main;
import fr.geekschool.pluginarena.backpack.Backpack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HotteListner implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClickForHotte(PlayerInteractEvent ev) {

        if(ev.getPlayer().getItemInHand().hasItemMeta()){
            if(ev.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Hotte"))

            if(ev.getAction() == Action.RIGHT_CLICK_BLOCK || ev.getAction() == Action.RIGHT_CLICK_AIR){

                Player player = ev.getPlayer();

                Backpack backpack = Main.getInstance().getBackpackManager().getBackpack(player.getUniqueId());

                player.openInventory(backpack.getInventory());


            }
        }
    }
}
