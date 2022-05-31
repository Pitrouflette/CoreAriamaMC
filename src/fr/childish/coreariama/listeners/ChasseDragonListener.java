package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;

public class ChasseDragonListener implements Listener {
    File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
    FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);


}