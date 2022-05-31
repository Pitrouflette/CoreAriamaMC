package fr.pitrouflette.ariamamc.listeners;

import fr.pitrouflette.ariamamc.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BlockedWordsUsage implements Listener {

    final Main main;

    public BlockedWordsUsage(Main main) {

        this.main = main;

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String[] split;
        int length = (split = event.getMessage().split(" ")).length;

        for(int i = 0; i < length; ++i) {
            String word = split[i];
            if (main.getConfig().getStringList("security.blocked-words").contains(word.toLowerCase()) && !event.getPlayer().hasPermission(main.getConfig().getString("security.permission-bypass"))) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(main.getConfig().getString("security.messages.cant-say-that").replace("&", "§"));
                return;
            }
        }
    }
}
