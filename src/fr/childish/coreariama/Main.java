package fr.childish.coreariama;

import fr.childish.coreariama.commands.*;
import fr.childish.coreariama.commands.ChasseDragon;
import fr.childish.coreariama.commands.GivePointCommand;
import fr.childish.coreariama.commands.Hammer;
import fr.childish.coreariama.manager.PotionManager;
import fr.childish.coreariama.listeners.*;
import fr.childish.coreariama.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.SpigotConfig;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static HashMap<UUID, Integer> cooldown = new HashMap<UUID, Integer>();

    public static Main instance;

    private PotionManager potionManager;

    @Override
    public void onEnable(){
        instance = this;

        getServer().getConsoleSender().sendMessage("§6===================CoreAriama===================");
        getServer().getConsoleSender().sendMessage("§8prefix initialisé : §e[§6AriamaMC§e]");
        getServer().getConsoleSender().sendMessage("§8classement des meilleurs factions : §2🟢");
        getServer().getConsoleSender().sendMessage("§8écriture du config.yml...");
        getServer().getConsoleSender().sendMessage("§8status des fichiers de configurations : §2🟢");
        getServer().getConsoleSender().sendMessage("§8dépendance SaberFaction(obligatoire) : §2🟢");
        getServer().getConsoleSender().sendMessage("§8dépendance Economy(facultatif) : §4🟥");
        getServer().getConsoleSender().sendMessage("§8recherche du plugin AriamaMC...");
        getServer().getConsoleSender().sendMessage("§8Plugin AriamaMC §2trouvé");
        getServer().getConsoleSender().sendMessage("§6================================================");

        getServer().getPluginManager().registerEvents(new AppleGold(), this);
        SpigotConfig.unknownCommandMessage = "§e[§6AriamaMC§e] §e Commande inconnue...";
        getCommand("site").setExecutor(new CommandSite());
        getCommand("discord").setExecutor(new CommandDiscord());
        getCommand("poubelle").setExecutor(new CommandPoubelle());
        getCommand("vote").setExecutor(new CommandVote());
        getCommand("healstick").setExecutor(new CommandHealstick());
        getCommand("epee").setExecutor(new CommandEpee());
        getServer().getPluginManager().registerEvents(new HealStick(), this);

        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {

            @Override
            public void run() {
                for (Map.Entry<UUID, Integer> entry : fr.childish.coreariama.Main.cooldown.entrySet()){
                    entry.setValue(Integer.valueOf(entry.getValue().intValue() - 1));
                    if(entry.getValue().intValue() == 0){
                        fr.childish.coreariama.Main.cooldown.remove(entry.getKey());
                    }
                }
            }
        }, 0L, 20L);

        Bukkit.getPluginManager().registerEvents(new GivePointCommand(), this);
        Bukkit.getPluginManager().registerEvents(new ClassementListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChasseDragonListener(), this);
        Bukkit.getPluginManager().registerEvents(new DethEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DethEventBow(), this);
        Bukkit.getPluginManager().registerEvents(new ClassementChat(), this);
        Bukkit.getPluginManager().registerEvents(new ChasseDragon(), this);
        Bukkit.getPluginManager().registerEvents(new CoolDownItem(), this);
        Bukkit.getPluginManager().registerEvents(new BlackMarket(), this);
        Bukkit.getPluginManager().registerEvents(new BossDethEvent(), this);
        Bukkit.getPluginManager().registerEvents(new Hammer(this), this);
        Bukkit.getPluginManager().registerEvents(new FarmTools(this), this);
        Bukkit.getPluginManager().registerEvents(new KnoxkbackPatchListener(this), this);
        getCommand("classement").setExecutor(new GivePointCommand());
        getCommand("chassedragon").setExecutor(new ChasseDragon());
        getCommand("infinit-items").setExecutor(new InfinitItems());
        this.getCommand("hammer").setExecutor(new Hammer());

        new ClassementListener.ClassementUpdate();

        File dossier = new File(String.valueOf(this.getDataFolder()));
        if(!dossier.exists()) dossier.mkdir();

        if(!ConfigUtils.configFileExist(this.getDataFolder(), "config.yml")){
            ConfigUtils.createConfigFile("config.yml");
        }
        if(!ConfigUtils.configFileExist(this.getDataFolder(), "factions.yml")){
            ConfigUtils.createConfigFile("factions.yml");
        }
        if(!ConfigUtils.configFileExist(this.getDataFolder(), "classementconf.yml")){
            ConfigUtils.createConfigFile("classementconf.yml");
        }

        File file2 = new File(this.getDataFolder(),"classementconf.yml");
        FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);
        if(!config2.getBoolean("enable-config")){
            config2.set("enable-config", true);
            config2.set("kill-points", 1);
            config2.set("claim-points", 1);
            config2.set("points-for10000money", 100);
            config2.set("prefix-chat", "&8[&a#%rank%&8]");
            config2.set("inventory-name", "&aClassement");
            try{
                config2.save(file2);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        File file = new File(this.getDataFolder(),"config.yml");
        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);
        if(!config.getBoolean("enable-config")){
            config.set("enable-config", true);
            config.set("prefix", "§8[§6Ariama§eMC§8]");
            config.set("mondeKTOR", "world");
            config.set("mondeDragon", "world_the_end");
            config.set("pos1X", 295);
            config.set("pos1Y", 89);
            config.set("pos1Z", 46);
            config.set("pos2X", -262);
            config.set("pos2Y", 90);
            config.set("pos2Z", 158);
            config.set("pos3X", 6);
            config.set("pos3Y", 92);
            config.set("pos3Z", 235);
            config.set("pos4X", -262);
            config.set("pos4Y", 90);
            config.set("pos4Z", -35);

            try{
                config.save(file);
            }catch (IOException e){
                e.printStackTrace();

            }
        }
    }

    private void registerManagers() {

        this.potionManager = new PotionManager(this);

    }

    @Override
    public void onDisable(){
    }

    public PotionManager getPotionManager() {
        return this.potionManager;
    }

}