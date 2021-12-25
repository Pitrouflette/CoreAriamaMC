package fr.geekschool.pluginarena.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class onFindGift implements Listener, CommandExecutor {

    public static Integer giftFind = 0;
    public static Boolean evntOnOff = false;

    public boolean getVaribleEventOnOff(Boolean bol){
        evntOnOff = bol;
        return bol;
    }

    public int getVaribleGiftFind(Integer gift){
        giftFind = gift;
        return giftFind;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player){

            if (args.length == 0){
                sender.sendMessage("§4Veuillez spécifier l'action voulu : start / stop");
            }else if(args.length == 1){
                sender.sendMessage("§4Veuillez spécifier l'envent en question : christmas");
            }else if(args[0].equals("start")){
                if(args[1].equals("christmas")){
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b L'event a débuté, allez trouver les");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b cadeaux cachés dans le spawn !!");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                    getVaribleEventOnOff(true);
                    getVaribleGiftFind(0);
                }
            }else if(args[0].equals("stop")){
                if(args[1].equals("christmas")){
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b L'event est terminé, tous les cadeaux ont ");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b été trouvé!! Bravo a vous!!");
                    Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                    getVaribleEventOnOff(false);
                    getVaribleGiftFind(0);
                }
            }else{
                sender.sendMessage("§4Veuillez spécifier un argument valadble");
            }
        }
        return true;
    }

    private void fireBall(PlayerInteractEvent ev){
        Player player = ev.getPlayer();
        Location myPosition = player.getEyeLocation();
        myPosition.add(myPosition.getDirection());
        Snowball mySnowBall = player.getWorld().spawn(myPosition, Snowball.class);
        mySnowBall.setFallDistance(100);
    }


    @EventHandler
    public void OnFindGift(PlayerInteractEvent ev) {

        ItemStack gift = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta giftSkullMeta = (SkullMeta) gift.getItemMeta();
        giftSkullMeta.setOwner("HypixelGifting");
        gift.setItemMeta(giftSkullMeta);

        if (ev.getAction() == Action.RIGHT_CLICK_AIR && ev.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Lanceur De Boules")){
            fireBall(ev);
        }else if (ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ev.getClickedBlock().getType().equals(Material.PLAYER_HEAD)) {
                if(evntOnOff){
                    giftFind++;
                    ev.getPlayer().sendMessage("§c[§bNoëlEvent§c] §2Vous avez trouvé un cadeau!! Au total, " + giftFind + "/100 cadeaux ont été trouvé");
                    ev.getClickedBlock().breakNaturally();
                    if(giftFind == 100){
                        Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                        Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b L'event est terminé, tous les cadeaux ont ");
                        Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b été trouvé!! Bravo a vous!!");
                        Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §1----------------------------------------");
                        Bukkit.broadcastMessage("§c[§bNoëlEvent§c] §b Vous pouvez échanger vos cadeau contre différantes récompenses en faisant /cadeau!!");
                        evntOnOff = false;
                    }
                }
            }
        }
    }
}
