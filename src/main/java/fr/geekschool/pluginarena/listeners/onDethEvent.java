package fr.geekschool.pluginarena.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDethEvent implements Listener {

    @EventHandler
    public void onDethPlayer(PlayerDeathEvent ev){

        if(ev.getEntity().getKiller() instanceof Player){

            Player killer = ev.getEntity().getKiller();
            Player player = ev.getEntity();
            ev.setDeathMessage("§e>§6>§b" + killer.getCustomName() + "§1 a élinimé §b"  + player.getCustomName() + "§1, §bil §1 n'avait plus que " + killer.getHealth() + " §4♥");
            killer.sendMessage("§e>§6>§b§1vous avez élinimé §b"  + player.getCustomName() + "§1, vous n'aviez plus que " + killer.getHealth() + " §4♥");
            player.sendMessage("§e>§6>§b§1vous avez été élinimé par §b"  + player.getCustomName() + "§1, il n'avait plus que " + killer.getHealth() + " §4♥");

        }
    }

}
