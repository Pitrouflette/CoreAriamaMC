package fr.childish.coreariama.commands;

import fr.childish.coreariama.Main;
import fr.childish.coreariama.utils.CountdownTimer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ChasseDragon implements CommandExecutor, Listener {

    public static boolean etat = false;
    public static int lescredits = 0;
    JavaPlugin plugin = JavaPlugin.getProvidingPlugin(this.getClass());
    static File files = new File(Main.instance.getDataFolder(),"config.yml");
    static FileConfiguration configs = new YamlConfiguration().loadConfiguration(files);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            if(args.length == 2){
                try
                {
                    if(!etat) {
                        Integer.parseInt(args[0]);
                        Integer.parseInt(args[1]);
                        int duree = Integer.valueOf(args[0]);
                        int credits = Integer.valueOf(args[1]);
                        lescredits = credits;

                        CountdownTimer timer = null;

                        launchDragon(duree, credits, timer);
                    }else {
                        System.out.println(configs.getString("prefix").replaceAll("&", "§") + " §cUne chasse a déjà été lancée !");
                        return false;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println(configs.getString("prefix").replaceAll("&", "§") + " §cArguments incorrects ! (Utilisation: /chassedragon <secondes> <credits>)");
                    return false;
                }


            }else{
                System.out.println(configs.getString("prefix").replaceAll("&", "§") + " §cSyntaxe incorrecte.");
                return false;
            }
        }
        Player p = (Player)sender;
        if(p.hasPermission("katacore.dragon")){
            if(args.length == 2){
                try
                {
                    if(!etat) {
                        Integer.parseInt(args[0]);
                        Integer.parseInt(args[1]);
                        int duree = Integer.valueOf(args[0]);
                        int credits = Integer.valueOf(args[1]);
                        lescredits = credits;

                        CountdownTimer timer = null;

                        launchDragon(duree, credits, timer);
                    }else {
                        p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cUne chasse a déjà été lancée !");
                        return false;
                    }
                }
                catch (NumberFormatException e)
                {
                    p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cArguments incorrects ! (Utilisation: /chassedragon <secondes> <credits>)");
                    return false;
                }


            }else{
                p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cSyntaxe incorrecte.");
                return false;
            }
        }else{
            p.sendMessage(configs.getString("prefix").replaceAll("&", "§") + " §cVous n'avez pas la permission d'utiliser cette commande.");
            return false;
        }
        return false;
    }

    public static void launchDragon(int duree, int credits, CountdownTimer timer){
        File file = new File(Main.instance.getDataFolder(),"config.yml");
        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);
        Sound son = Sound.NOTE_PLING;
        Sound sonfinal = Sound.LEVEL_UP;
        World world = Bukkit.getServer().getWorld(config.getString("mondeDragon"));
        timer = new CountdownTimer(Main.instance,
                duree,
                () -> {
                    Bukkit.broadcastMessage("§6§m-|§e§m--------------------------------------------------§6§m|-");
                    Bukkit.broadcastMessage("                    §6Le §eDragon §6vient d'§eapparaître§6.");
                    Bukkit.broadcastMessage("         §6Rendez vous en dans l'End pour l'affronter.");
                    Bukkit.broadcastMessage("     §6Il y a §a" + credits + "$§6, §a30 points faction §6et §eUne Clé Event §6en jeu !");
                    Bukkit.broadcastMessage("§6§m-|§e§m--------------------------------------------------§6§m|-");
                    Location locationSpawn = new Location(world, 0, 75, 0);
                    Chunk chunk = world.getChunkAt(locationSpawn);
                    world.loadChunk(chunk);
                    EnderDragon enderDragon = world.spawn(locationSpawn, EnderDragon.class);
                    enderDragon.setCustomName("§cDragon");
                    Bukkit.getOnlinePlayers().forEach((p) -> {
                        Location location = p.getLocation();
                        p.playSound(location, Sound.ENDERDRAGON_GROWL, 3.0F, 0.533F);
                        p.playSound(location, Sound.ENDERDRAGON_GROWL, 3.0F, 1.033F);

                        etat = true;
                    });
                },

                () -> {

                    Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cLa Chasse au Dragon est terminée!");

                    for(Entity mob : world.getEntities())
                    {
                        if(mob.getType().equals(EntityType.ENDER_DRAGON))
                        {
                            mob.remove();

                        }

                    }

                    Bukkit.getOnlinePlayers().forEach((p) -> {
                        Location location = p.getLocation();
                        p.playSound(location, sonfinal, (float)1.0, (float)1.0);
                        etat = false;
                    });

                },
                (t) -> {

                    switch(t.getSecondsLeft()) {
                        case 600: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 10 minutes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 300: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 5 minutes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 240: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 4 minutes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 180: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 3 minutes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 120: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 2 minutes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 60: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 1 minute pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 30: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 30 secondes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 10: {
                            Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 10 secondes pour tuer le Dragon !");
                            Bukkit.getOnlinePlayers().forEach((p) -> {
                                Location location = p.getLocation();
                                p.playSound(location, son, (float)1.0, (float)1.0);
                            });
                            break;
                        }
                        case 5: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }else {
                                Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 5 secondes pour tuer le Dragon !");
                                Bukkit.getOnlinePlayers().forEach((p) -> {
                                    Location location = p.getLocation();
                                    p.playSound(location, son, (float)1.0, (float)1.0);
                                });
                            }
                            break;
                        }
                        case 4: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }else {
                                Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 4 secondes pour tuer le Dragon !");
                                Bukkit.getOnlinePlayers().forEach((p) -> {
                                    Location location = p.getLocation();
                                    p.playSound(location, son, (float)1.0, (float)1.0);
                                });
                            }
                            break;
                        }
                        case 3: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }else {
                                Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 3 secondes pour tuer le Dragon !");
                                Bukkit.getOnlinePlayers().forEach((p) -> {
                                    Location location = p.getLocation();
                                    p.playSound(location, son, (float)1.0, (float)1.0);
                                });
                            }
                            break;

                        }

                        case 2: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }else {
                                Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 2 secondes pour tuer le Dragon !");
                                Bukkit.getOnlinePlayers().forEach((p) -> {
                                    Location location = p.getLocation();
                                    p.playSound(location, son, (float)1.0, (float)1.0);
                                });
                            }
                            break;
                        }
                        case 1: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }else {
                                Bukkit.broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §cIl vous reste 1 seconde pour tuer le Dragon !");
                                Bukkit.getOnlinePlayers().forEach((p) -> {
                                    Location location = p.getLocation();
                                    p.playSound(location, son, (float)1.0, (float)1.0);
                                });
                            }
                            break;
                        }
                        default: {
                            if(!etat) {
                                t.setSecondsLeft(0);
                            }
                        }
                    }
                }
        );

        // Start scheduling, don't use the "run" method unless you want to skip a second
        timer.scheduleTimer();

    }

    public static void spawnFireworks(Location location, int amount, int power){
        Location loc = location;
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.setPower(power);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.PURPLE, Color.WHITE).flicker(true).with(FireworkEffect.Type.BALL_LARGE).build());

        fw.setFireworkMeta(fwm);
        fw.detonate();

        for(int i = 0;i<amount; i++){
            Firework fw2 = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            fw2.setFireworkMeta(fwm);
        }
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent e){

        if (e.getEntity() instanceof EnderDragon && e.getEntity().getKiller() instanceof Player){
            String tueur = e.getEntity().getKiller().getName();
            if(etat) {
                etat = false;
                Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + configs.getString("prefix").replaceAll("&", "§") + " §aFélicitations! §a§l"+ tueur + " §aa réussi à tuer le Dragon! Il a gagné §a§l" + lescredits + "§a$ !");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + tueur + " " + lescredits);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crate gk " + tueur + " Event 1");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "classement " + tueur + " 30");


                for(Player p : Bukkit.getOnlinePlayers()){
                    if(p.getWorld().getName().equals("world_the_end")){
                        Location location = p.getLocation();
                        spawnFireworks(location, 1, 1);

                    }
                }
            }
        }else {
            return;
        }
    }
}