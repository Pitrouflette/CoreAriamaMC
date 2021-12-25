package fr.geekschool.pluginarena.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class InteractCadeauInvListener implements Listener {

    @EventHandler
    public void onInvInteract(InventoryClickEvent ev){

        Player player = (Player) ev.getWhoClicked();
        ItemStack current = ev.getCurrentItem();

        int giftContains = player.getItemInHand().getAmount() - 5;

        //Item to give

        //ItemSnowLancheur
        ItemStack SnowLancheur = new ItemStack(Material.STICK);
        ItemMeta SonwLancheurMeta = SnowLancheur.getItemMeta();
        SonwLancheurMeta.setDisplayName("§bLanceur De Boules De §eNeiges");
        SonwLancheurMeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        SonwLancheurMeta.setLore(Arrays.asList("§e--------------------", "§bLanceur De Boules De §eNeiges", "§e--------------------"));
        SnowLancheur.setItemMeta(SonwLancheurMeta);

        //Gift
        ItemStack gift = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta giftSkullMeta = (SkullMeta) gift.getItemMeta();
        giftSkullMeta.setOwner("HypixelGifting");
        giftSkullMeta.setDisplayName("§eGift");
        gift.setItemMeta(giftSkullMeta);

        //Hotte
        ItemStack Hotte = new ItemStack(Material.NETHER_STAR);
        ItemMeta HotteMeta = Hotte.getItemMeta();
        HotteMeta.setDisplayName("§4Christmas §1Hotte");
        HotteMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        HotteMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        HotteMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : Hotte", "§1Prix : §4 5 cadeaux", "§1Cette hotte vous permet d'ouvrir un §4sac a dos", "§4--------------------"));
        Hotte.setItemMeta(HotteMeta);

        //Patin a Glace
        ItemStack PatinGlace = new ItemStack(Material.IRON_BOOTS);
        ItemMeta PatinGlaceMeta = PatinGlace.getItemMeta();
        PatinGlaceMeta.setDisplayName("§4Patin à §1Glace");
        PatinGlaceMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        PatinGlaceMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        PatinGlaceMeta.addEnchant(Enchantment.FROST_WALKER, 5, true);
        PatinGlaceMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : Patin A Glace", "§4--------------------"));
        PatinGlace.setItemMeta(PatinGlaceMeta);

        //HelmetGod
        ItemStack HelmetGod = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta HelmetGodMeta = HelmetGod.getItemMeta();
        HelmetGodMeta.setDisplayName("§4Christmas §1Helmet");
        HelmetGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        HelmetGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        HelmetGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : casque", "§1Prix : §4 5 cadeaux", "§4--------------------"));
        HelmetGod.setItemMeta(HelmetGodMeta);

        //ChestGod
        ItemStack ChestGod = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta ChestGodMeta = ChestGod.getItemMeta();
        ChestGodMeta.setDisplayName("§4Christmas §1Chestplate");
        ChestGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        ChestGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        ChestGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : plastron", "§1Prix : §4 5 cadeaux", "§4--------------------"));
        ChestGod.setItemMeta(ChestGodMeta);

        //LeggGod
        ItemStack LeggGod = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta LeggGodMeta = LeggGod.getItemMeta();
        LeggGodMeta.setDisplayName("§4Christmas §1Leggings");
        LeggGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        LeggGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        LeggGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : jambière", "§1Prix : §4 5 cadeaux", "§4--------------------"));
        LeggGod.setItemMeta(LeggGodMeta);

        //BootsGod
        ItemStack BootsGod = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta BootsGodMeta = BootsGod.getItemMeta();
        BootsGodMeta.setDisplayName("§4Christmas §1Boots");
        BootsGodMeta.addEnchant(Enchantment.FROST_WALKER, 5, true);
        BootsGodMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        BootsGodMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        BootsGodMeta.setLore(Arrays.asList("§4--------------------", "§1Armure de Noël : bottes", "§1Prix : §4 5 cadeaux", "§4--------------------"));
        BootsGod.setItemMeta(BootsGodMeta);

        if(current == null) return;

        if(ev.getView().getTitle().contains("§bRécomp")){

            if(current.getItemMeta().getDisplayName().contains("§bRécompen")){
                ev.setCancelled(true);
            }

            if (current.getItemMeta().getDisplayName().contains("Quitter")){
                ev.setCancelled(true);
            }
            ev.setCancelled(true);
            if(current.getItemMeta().getDisplayName().contains("Lanceur De")){
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5){
                    player.getInventory().addItem(SnowLancheur);
                    player.getInventory().remove(player.getItemInHand());
                    for(int i = 0; i < giftContains; i++) {
                        player.getInventory().addItem(gift);
                    }
                }else{
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }
            if (current.getItemMeta().getDisplayName().contains("§4Christmas §1Hotte : 5 cadeaux")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5) {
                    player.getInventory().addItem(Hotte);
                    player.getInventory().remove(player.getItemInHand());
                    for (int i = 0; i < giftContains; i++) {
                        player.getInventory().addItem(gift);
                    }
                } else {
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }
            if (current.getItemMeta().getDisplayName().contains("§4Patin à")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5) {
                    player.getInventory().addItem(PatinGlace);
                    player.getInventory().remove(player.getItemInHand());
                    for (int i = 0; i < giftContains; i++) {
                        player.getInventory().addItem(gift);
                    }
                } else {
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }
            if (current.getItemMeta().getDisplayName().contains("§4Christmas §1Helmet : §4 5 cadeaux")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5){
                    player.getInventory().addItem(HelmetGod);
                    player.getInventory().remove(player.getItemInHand());
                    for(int i = 0; i < giftContains; i++) {
                        player.getInventory().addItem(gift);
                    }
                }else{
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }

            if (current.getItemMeta().getDisplayName().contains("§4Christmas §1Boots : §4 5 cadeaux")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5){
                    player.getInventory().addItem(BootsGod);
                    player.getInventory().remove(player.getItemInHand());
                    for(int i = 0; i < giftContains; i++) {
                        player.getInventory().addItem(gift);
                    }
                }else{
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }

            if (current.getItemMeta().getDisplayName().contains("§4Christmas §1Chestplate : §4 5 cadeaux")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5){
                    player.getInventory().addItem(ChestGod);
                    player.getInventory().remove(player.getItemInHand());
                    for (int i = 0; i < giftContains + 1; i++) {
                        player.getInventory().addItem(gift);
                    }
                }else{
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez le nombre de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }

            if (current.getItemMeta().getDisplayName().contains("§4Christmas §1Leggings : §4 5 cadeaux")) {

                ev.setCancelled(true);
                if (player.getItemInHand().getType().equals(Material.PLAYER_HEAD) && player.getItemInHand().getAmount() >= 5){
                    player.getInventory().addItem(LeggGod);
                    player.getInventory().remove(player.getItemInHand());
                    for (int i=0; i < giftContains + 1; i++) {
                        player.getInventory().addItem(gift);
                    }
                }else{
                    player.sendMessage("§c[§bGift§c] §2Vous devez avoir assez de cadeaux dans votre main.");
                    player.closeInventory();
                }
            }
        }
    }
}
