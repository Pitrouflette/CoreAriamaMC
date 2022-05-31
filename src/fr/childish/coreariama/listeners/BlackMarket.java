package fr.childish.coreariama.listeners;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import fr.childish.coreariama.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.io.File;

public class BlackMarket implements Listener {
    File files = new File(Main.instance.getDataFolder(),"config.yml");
    FileConfiguration configs = new YamlConfiguration().loadConfiguration(files);

    @EventHandler(priority=EventPriority.HIGHEST)
    public void openBlackMarket(PlayerInteractEntityEvent e)
    {
        if(e.getRightClicked().getCustomName() != null) {
            if(!e.isCancelled() && e.getRightClicked() != null && e.getRightClicked() instanceof Villager && e.getRightClicked().getCustomName().equalsIgnoreCase("§9§lBlack Market"))
            {
                Villager v = (Villager) e.getRightClicked();
                Player p = e.getPlayer();

                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                Date date = calendar.getTime();
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                if(dayOfWeek == 4 || dayOfWeek == 7) {
                    e.setCancelled(true);
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    if(dayOfWeek == 4) {
                        String command = "cc open marchandnoir "+p.getName();
                        Bukkit.dispatchCommand(console, command);
                    }

                    if(dayOfWeek == 7) {
                        String command = "cc open marchandnoir2 "+p.getName();
                        Bukkit.dispatchCommand(console, command);
                    }

                    return;

                }else {
                    p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cLe Black Market est ouvert le Mercredi et le Samedi.");
                    return;
                }
            }
        }else return;
    }
}