package fr.childish.coreariama.commands;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import com.massivecraft.factions.event.FPlayerLeaveEvent.PlayerLeaveReason;

import fr.childish.coreariama.Main;
import fr.childish.coreariama.listeners.ClassementListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GivePointCommand implements CommandExecutor, Listener {

    File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
    FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);

    File file = new File(Main.instance.getDataFolder(),"factions.yml");
    FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

    File filees = new File(Main.instance.getDataFolder(),"config.yml");
    FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender){
            if(args.length == 2){
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
                Faction faction = FPlayers.getInstance().getByOfflinePlayer(target).getFaction();
                int nbre = 0;
                if(faction != null){
                    try{
                        nbre = Integer.parseInt(args[1]);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                        return false;
                    }

                    File file = new File(Main.instance.getDataFolder(),"factions.yml");
                    FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

                    config.set(faction.getTag()+".give-points", config.getInt(faction.getTag()+".give-points") + nbre);

                    try {
                        config.save(file);
                        System.out.println(configaa.getString("prefix").replaceAll("&", "§") + " §aVous avez donné §l"+nbre+" §apoints à la faction §l"+faction.getTag());

                        Set<FPlayer> membres = faction.getFPlayers();
                        for(FPlayer curr : membres) {
                            curr.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §eVotre faction a reçu §a"+nbre+" §epoints faction.");
                        }

                        return true;
                    }catch (IOException e){
                        e.printStackTrace();
                        return false;
                    }
                }else{
                    return false;
                }

            }else{
                System.out.println(configaa.getString("prefix").replaceAll("&", "§") + " §cSyntaxe incorrecte.");
                return false;
            }
        }else{
            Player p = (Player)sender;
            if(args.length == 0){
                Inventory inv = Bukkit.createInventory(null, 9*6, config2.getString("inventory-name").replaceAll("&", "§"));

                ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)10);
                ItemMeta meta = glass.getItemMeta();
                meta.setDisplayName(" ");
                glass.setItemMeta(meta);

                ItemStack topTen = new ItemStack(Material.PAPER,1);
                ItemMeta metaTen = topTen.getItemMeta();
                metaTen.setDisplayName("§8> §7Top §510 §7des meilleurs factions");

                List<String> lore = new ArrayList<>();
                lore.add("§8§m----------");
                lore.add(" ");

                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add("nullFaction");
                lore.add( "nullFaction");
                lore.add( "nullFaction");

                int i =0;
                for(Map.Entry<String, Integer> map : ClassementListener.topFactionValues.entrySet()){
                    i++;
                    if(i >= 10)break;
                    lore.set(i+1, "§8> §7N°"+i+": §5"+map.getKey()+" §7avec §5"+map.getValue()+" points§7");
                }

                metaTen.setLore(lore);
                topTen.setItemMeta(metaTen);

                if(lore.get(3) == null && lore.get(2) == null){
                    return true;
                }

                ItemStack topOne = new ItemStack(Material.FIREBALL);
                ItemMeta topOneM = topOne.getItemMeta();
                topOneM.setDisplayName("§8> §7Top §51 §7des meilleurs factions :");
                topOneM.setLore(Arrays.asList(lore.get(0), lore.get(2) + ".", lore.get(0)));
                topOneM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                topOne.setItemMeta(topOneM);

                ItemStack topTwo = new ItemStack(Material.FIREBALL);
                ItemMeta topTwoM = topTwo.getItemMeta();
                topTwoM.setDisplayName("§8> §7Top §52 §7des meilleurs factions :");
                topTwoM.setLore(Arrays.asList(lore.get(0), lore.get(3) + ".", lore.get(0)));
                topTwoM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                topTwo.setItemMeta(topTwoM);

                inv.setItem(20, topOne);
                inv.setItem(21, topTwo);

                ItemStack topThree = new ItemStack(Material.FIREBALL);
                ItemMeta topThreeM = topThree.getItemMeta();
                topThreeM.setDisplayName("§8> §7Top §53 §7des meilleurs factions :");
                topThreeM.setLore(Arrays.asList(lore.get(0), lore.get(4) + ".", lore.get(0)));
                topThreeM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                topThree.setItemMeta(topThreeM);

                inv.setItem(22, topThree);

                ItemStack top4 = new ItemStack(Material.FIREBALL);
                ItemMeta top4M = top4.getItemMeta();
                top4M.setDisplayName("§8> §7Top §54 §7des meilleurs factions :");
                top4M.setLore(Arrays.asList(lore.get(0), lore.get(5) + ".", lore.get(0)));
                top4M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top4.setItemMeta(top4M);

                inv.setItem(23, top4);

                ItemStack top5 = new ItemStack(Material.FIREBALL);
                ItemMeta top5M = top5.getItemMeta();
                top5M.setDisplayName("§8> §7Top §55 §7des meilleurs factions :");
                top5M.setLore(Arrays.asList(lore.get(0), lore.get(6) + ".", lore.get(0)));
                top5M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top5.setItemMeta(top5M);

                inv.setItem(24, top5);

                ItemStack top6 = new ItemStack(Material.FIREBALL);
                ItemMeta top6M = top6.getItemMeta();
                top6M.setDisplayName("§8> §7Top §56 §7des meilleurs factions :");
                top6M.setLore(Arrays.asList(lore.get(0), lore.get(7) + ".", lore.get(0)));
                top6M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top6.setItemMeta(top6M);

                inv.setItem(29, top6);

                ItemStack top7 = new ItemStack(Material.FIREBALL);
                ItemMeta top7M = top7.getItemMeta();
                top7M.setDisplayName("§8> §7Top §57 §7des meilleurs factions :");
                top7M.setLore(Arrays.asList(lore.get(0), lore.get(8) + ".", lore.get(0)));
                top7M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top7.setItemMeta(top7M);

                inv.setItem(30, top7);
                ItemStack top8 = new ItemStack(Material.FIREBALL);
                ItemMeta top8M = top8.getItemMeta();
                top8M.setDisplayName("§8> §7Top §58 §7des meilleurs factions :");
                top8M.setLore(Arrays.asList(lore.get(0), lore.get(9) + ".", lore.get(0)));
                top8M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top8.setItemMeta(top8M);

                inv.setItem(31, top8);

                ItemStack top9 = new ItemStack(Material.FIREBALL);
                ItemMeta top9M = top9.getItemMeta();
                top9M.setDisplayName("§8> §7Top §59 §7des meilleurs factions :");
                top9M.setLore(Arrays.asList(lore.get(0), lore.get(10) + ".", lore.get(0)));
                top9M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top9.setItemMeta(top9M);

                inv.setItem(32, top9);

                ItemStack top10 = new ItemStack(Material.FIREBALL);
                ItemMeta top10M = top10.getItemMeta();
                top10M.setDisplayName("§8> §7Top §510 §7des meilleurs factions :");
                top10M.setLore(Arrays.asList(lore.get(0), lore.get(11) + ".", lore.get(0)));
                top10M.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                top10.setItemMeta(top10M);

                inv.setItem(33, top10);

                ItemStack playerplace = new ItemStack(Material.IRON_AXE,1);
                meta.setDisplayName("§8> §7Votre classement");
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                lore.clear();
                lore.add(" ");
                lore.add("§8§m----------");
                if(ClassementListener.getPlaceFactions.containsKey(FPlayers.getInstance().getByPlayer(p).getFaction().getTag())){
                    int rank = ClassementListener.getPlaceFactions.get(FPlayers.getInstance().getByPlayer(p).getFaction().getTag());
                    lore.add("§8> §7Vous êtes classé §5#"+rank+"§7!");
                }else{
                    lore.add("§8> §cVous n'avez pas de faction.");
                }
                lore.add("§8§m----------");
                meta.setLore(lore);
                playerplace.setItemMeta(meta);

                inv.setItem(0, glass);
                inv.setItem(1, glass);
                inv.setItem(9, glass);
                inv.setItem(7, glass);
                inv.setItem(8, glass);
                inv.setItem(17, glass);
                inv.setItem(44, glass);
                inv.setItem(52, glass);
                inv.setItem(53, glass);
                inv.setItem(46, glass);
                inv.setItem(45, glass);
                inv.setItem(36, glass);
                inv.setItem(49, topTen);

                inv.setItem(4, playerplace);

                p.openInventory(inv);
                return true;
            }else if(args.length == 2){
                if(p.hasPermission("classement.admin")){
                    OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
                    Faction faction = FPlayers.getInstance().getByOfflinePlayer(target).getFaction();
                    int nbre = 0;
                    if(faction != null){
                        try{
                            nbre = Integer.parseInt(args[1]);
                        }catch (NumberFormatException e){
                            e.printStackTrace();
                            p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §cVotre deuxième argument doit être un nombre.");
                            return false;
                        }

                        File file = new File(Main.instance.getDataFolder(),"factions.yml");
                        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

                        config.set(faction.getTag()+".give-points", config.getInt(faction.getTag()+".give-points") + nbre);

                        try {
                            config.save(file);
                            p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §aVous avez donné §l"+nbre+" §apoints à la faction §l"+faction.getTag());

                            Set<FPlayer> membres = faction.getFPlayers();
                            for(FPlayer curr : membres) {
                                curr.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §eVotre faction a reçu §a"+nbre+" §epoints faction.");
                            }

                            return true;
                        }catch (IOException e){
                            e.printStackTrace();
                            p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §cErreur lors de l'écriture du fichier configuration.");
                            return false;
                        }
                    }else{
                        p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §cCe joueur n'est dans aucune faction.");
                        return false;
                    }
                }else{
                    p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §cVous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

            }else{
                p.sendMessage(configaa.getString("prefix").replaceAll("&", "§") + " §cSyntaxe incorrecte.");
                return false;
            }
        }

    }
    @EventHandler
    public void onEventFactionsLeave(FPlayerLeaveEvent event) {
        String faction = event.getFaction().getTag();
        if(event.getReason() == PlayerLeaveReason.DISBAND) {
            config.set(faction, null);
            try {
                config.save(file);
            }catch (IOException e){
                e.printStackTrace();
                return;
            }
        }else {
            return;
        }
    }

    @EventHandler
    public void playerClickInventory(InventoryClickEvent e){
        if(e.getClickedInventory() == null) return;
        if(e.getClickedInventory().getName().equals(config2.getString("inventory-name").replaceAll("&", "§"))){
            e.setCancelled(true);
        }else return;
    }
}