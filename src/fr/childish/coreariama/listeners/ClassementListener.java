package fr.childish.coreariama.listeners;

import com.massivecraft.factions.*;
import com.massivecraft.factions.integration.Econ;
import fr.childish.coreariama.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClassementListener implements Listener{

    public static HashMap<String, Integer> getRankFaction = new HashMap<>();

    public static HashMap<String, Integer> getPlaceFactions = new HashMap<>();

    public static Map<String, Integer> topFactionValues;
    public static Map<String, Integer> topFactionPlace;

    public static class ClassementUpdate extends BukkitRunnable {
        public ClassementUpdate(){
            this.runTaskTimer(Main.instance,0L,6000L); // 20 L = 1s
        }

        @Override
        public void run() {
            List<String> factions = new ArrayList<>();

            File file = new File(Main.instance.getDataFolder(),"factions.yml");
            FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

            File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
            FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);

            Bukkit.broadcastMessage("§8[§6Ariama§eMC§8] §aLe classement vient d'être mis à jour !");
            getRankFaction.clear();
            getPlaceFactions.clear();
            for(Faction faction : Factions.getInstance().getAllFactions()){
                if(faction.isWilderness() || faction.isWarZone() || faction.isSafeZone()) continue;
                factions.add(faction.getTag());
                config.set(faction.getTag()+".claims-points", faction.getAllClaims().size() * config2.getInt("claim-points"));
                config.set(faction.getTag()+".money-points", (int)(Econ.getBalance(faction.getAccountId())/50000) * config2.getInt("points-for10000money"));

                int points = config.getInt(faction.getTag()+".claims-points") + config.getInt(faction.getTag()+".money-points")
                        + config.getInt(faction.getTag()+".kill-points") + config.getInt(faction.getTag()+".give-points");
                config.set(faction.getTag()+".points-totaux", points);

                getRankFaction.put(faction.getTag(), points);
            }
            topFactionValues =
                    getRankFaction.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(1000000000)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            int i = 0;
            for(Map.Entry<String, Integer> compa : topFactionValues.entrySet()){
                i++;
                getPlaceFactions.put(compa.getKey(), i);
                topFactionPlace =
                        getPlaceFactions.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .limit(1000000000)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            }
            try {
                config.save(file);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void playerKillPlayer(EntityDeathEvent e){
        if(e.getEntity() instanceof Player){
            if(e.getEntity().getKiller() instanceof Player){
                LivingEntity le = e.getEntity();
                Player victime = (Player)le;
                Player killer = e.getEntity().getKiller();
                Faction faction = FPlayers.getInstance().getByPlayer(killer).getFaction();
                Faction factionMoins = FPlayers.getInstance().getByPlayer(victime).getFaction();
                if(faction.getTag() == factionMoins.getTag()) {

                    return;
                }else {

                    File file = new File(Main.instance.getDataFolder(),"factions.yml");
                    FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

                    File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
                    FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);

                    config.set(faction.getTag()+".kill-points", config.getInt(faction.getTag()+".kill-points") + config2.getInt("kill-points"));


                    config.set(factionMoins.getTag()+".kill-points", config.getInt(factionMoins.getTag()+".kill-points") - config2.getInt("death-points"));


                    try {
                        config.save(file);
                    }catch (IOException e2){
                        e2.printStackTrace();
                    }
                }
            }else return;
        }else return;
    }
}