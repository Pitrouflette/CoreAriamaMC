package fr.geekschool.pluginarena.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class onUsePitrouTools implements Listener {

    @EventHandler
    public void ONRightClic(PlayerInteractEvent ev) {
        Player player = ev.getPlayer();

        if (player.getItemInHand().hasItemMeta()) {

            if (ev.getAction() == Action.RIGHT_CLICK_BLOCK ) {

                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Hoe")) {

                    EggLanche(ev);

                } else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Pickaxe")){

                    zeus(ev);

                }else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Axe")){

                    EndAxe(ev);

                }

            }else if(ev.getAction() == Action.RIGHT_CLICK_AIR) {


                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Hoe")) {

                    EggLanche(ev);

                } else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Pickaxe")){

                    zeus(ev);

                }else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§6Axe")){

                    EndAxe(ev);

                }
            }
        }
    }

    public void zeus(PlayerInteractEvent eventzeus) {
        Location maposition = eventzeus.getPlayer().getLocation();
        Vector madirection = maposition.getDirection();
        Vector matranslation = madirection.multiply(15);
        Location nouvelleposition = maposition.add(matranslation);
        eventzeus.getPlayer().getWorld().strikeLightning(nouvelleposition);
    }

    public void EndAxe(PlayerInteractEvent ev) {
        Location maposition = ev.getPlayer().getLocation();
        Vector madirection = maposition.getDirection();
        Vector matranslation = madirection.multiply(6);
        Location nouvelleposition = maposition.add(matranslation);
        ev.getPlayer().teleport(nouvelleposition);
    }

    private void EggLanche(PlayerInteractEvent ev){
        Player player = ev.getPlayer();
        Location myPosition = player.getEyeLocation();
        myPosition.add(myPosition.getDirection());

        Egg myEgg = player.getWorld().spawn(myPosition, Egg.class);
    }
}
