package fr.geekschool.pluginarena.listeners;

import fr.geekschool.pluginarena.Main;
import fr.geekschool.pluginarena.cooldown.CooldonwManager;
import org.bukkit.Particle;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.logging.Logger;

public class godSwordListener implements Listener {

    @EventHandler
    public void toggle(PlayerInteractEvent event){
        Integer enemyKilled = 0;
        final Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§3Pitrouflette §6Sword")) {
            if (CooldonwManager.checkCooldown(event.getPlayer())) {
                CooldonwManager.setCooldown(event.getPlayer(), 60);
                new BukkitRunnable(){
                    Location loc = player.getLocation();
                    double t = 0;
                    double r = 1;
                    public void run(){
                        r = r + 0.2;
                        t = t + Math.PI/8;
                        double x = r*Math.cos(t);
                        double y = t;
                        double z = r*Math.sin(t);
                        loc.add(x, y, z);
                        player.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc, 0, 0, 0, 0, 5);
                        player.getLocation().getWorld().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 5);
                        loc.subtract(x, y, z);
                        if (t > Math.PI*4){
                            this.cancel();
                        }
                    }
                }.runTaskTimer(Main.getInstance(), 0, 1);

                new BukkitRunnable() {
                    Location loc = player.getLocation();
                    double t = 0;
                    double r = 3;
                    public void run() {
                        t = t + Math.PI/8;
                        double x = r * Math.cos(t);
                        double y = player.getLocation().getY();
                        double z = r * Math.sin(t);
                        loc.add(x, 0, z);
                        player.getLocation().getWorld().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                        player.getLocation().getWorld().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                        loc.subtract(x, 0, z);
                        if (t > Math.PI*4){
                            this.cancel();
                        }
                    }
                } .runTaskTimer(Main.getInstance(), 0, 1);

                Logger.getLogger("PluginOdysseyus:  GodWarth").info("in godwrath");
                //player.sendMessage("§4La colère liée au fait que vous n'avez pas eu de cadeaux monte en vous.....");

                Collection<Entity> enemies = player.getWorld().getNearbyEntities(player.getLocation(),1000,1000,1000);

                for(Entity thisEnemy : enemies){
                    enemyKilled ++;
                    if(thisEnemy instanceof Damageable && thisEnemy.getType() != player.getType()){
                        ((Damageable) thisEnemy).setHealth(0);
                    }
                }
                player.sendMessage("§4vous avez éliminé :  §1" + enemyKilled+ " §4énemies");

            } else {
                //event.getPlayer().sendMessage("§4La colère liée au fait que vous n'avez pas eu de cadeaux monte en vous...");
                event.getPlayer().sendMessage("§4veuillez attendre encore §1" + CooldonwManager.egtCooldown(player) + "§4 secondes");
            }
        }
    }
}
