package fr.childish.coreariama.listeners;

import fr.childish.coreariama.Main;
import com.massivecraft.factions.FPlayers;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ClassementChat implements Listener {

    File file2 = new File(Main.instance.getDataFolder(),"classementconf.yml");
    FileConfiguration config2 = new YamlConfiguration().loadConfiguration(file2);

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerSpeaking(AsyncPlayerChatEvent e){



        if(!ClassementListener.getPlaceFactions.containsKey(FPlayers.getInstance().getByPlayer(e.getPlayer()).getFaction().getTag())){
            String prefix = config2.getString("prefix-chat").replace("%rank%","");
            String format = e.getFormat().replace("{CLASSEMENT-PREFIX}", prefix).replaceAll("&", "§");
            e.setFormat(format);
            return;
        }

        int rank = ClassementListener.getPlaceFactions.get(FPlayers.getInstance().getByPlayer(e.getPlayer()).getFaction().getTag());

        String format;
        switch(rank) {
            case 1: {
                String prefix = config2.getString("prefix-chat").replace("%rank%","§8[§c§l#"+rank+"§8] ");
                format = e.getFormat().replace("{CLASSEMENT-PREFIX}", prefix).replaceAll("&", "§");
                break; }
            case 2: {
                String prefix = config2.getString("prefix-chat").replace("%rank%","§8[§a§l#"+rank+"§8] ");
                format = e.getFormat().replace("{CLASSEMENT-PREFIX}", prefix).replaceAll("&", "§");
                break;
            }
            case 3: {
                String prefix = config2.getString("prefix-chat").replace("%rank%","§8[§e§l#"+rank+"§8] ");
                format = e.getFormat().replace("{CLASSEMENT-PREFIX}", prefix).replaceAll("&", "§");
                break;
            }
            default:{
                String prefix = config2.getString("prefix-chat").replace("%rank%","§8[§7#"+rank+"§8] ");
                format = e.getFormat().replace("{CLASSEMENT-PREFIX}", prefix).replaceAll("&", "§");
                break;
            }


        }

        e.setFormat(format);

    }


    public static HashMap<UUID, UUID> dernierKill = new HashMap<>();

    @EventHandler
    private void onDeath(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player tueur=e.getEntity().getKiller();
            Player tuer=e.getEntity().getPlayer();
            UUID id = tueur.getUniqueId();
            UUID idtuer = tuer.getUniqueId();
            double randDouble = Math.random();
            if(randDouble <= 0.5D) {
                ItemStack item = new ItemStack(Material.COOKIE, 1);
                ItemMeta sm = item.getItemMeta();
                sm.setDisplayName("§6§l◍ §eCookie de Kill §6§l◍");
                List<String> loresList = new ArrayList<String>();
                loresList.add("§7Cookie échangeable au marché");
                loresList.add("§7du spawn. ");
                sm.setLore(loresList);
                item.setItemMeta(sm);

                e.getDrops().add(item);
                return;
            }else {
                return;
            }

        }else {
            return;
        }


    }




    @EventHandler
    public void onDispense(BlockDispenseEvent e) {
        ItemStack it = e.getItem();
        Material mat = it.getType();
        if (mat == Material.POTION && it.getDurability() == 16425) {
            Potion potion = Potion.fromItemStack(it);
            PotionEffectType effecttype = potion.getType().getEffectType();
            if (effecttype == PotionEffectType.INCREASE_DAMAGE) {
                e.setCancelled(true);
            }
        }
    }
}