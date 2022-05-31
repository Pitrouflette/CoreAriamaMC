package fr.childish.coreariama.listeners;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class HammerListener implements Listener {
    Faction faction = null;

    public HammerListener(fr.childish.coreariama.Main main) {

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand() != null && p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().contains("§e§lHammer") && !p.isOp() && (e.getMessage().contains("repair") || e.getMessage().contains("fix"))) {
            e.setCancelled(true);
            p.sendMessage("§cVous ne pouvez pas exécuter cette commande avec cet objet dans votre main.");
        }
    }

    @EventHandler
    public void test(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block a = e.getBlock();
        if (p.getItemInHand().getItemMeta() != null && p.getItemInHand() != null && p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().contains("§e§lHammer")) {
            Location loc = e.getBlock().getLocation();
            FPlayer fp = FPlayers.getInstance().getByPlayer(p);
            Faction fb = Board.getInstance().getFactionAt(new FLocation(a.getLocation()));
            FLocation fl = new FLocation();
            this.faction = Board.getInstance().getFactionAt(fl);
            if (this.canBuild(p) && this.canBuildUnder1(p) && this.canBuildUnder2(p) && this.canBuildUnder3(p) && this.canBuildUnder4(p) && this.canBuildAbove1(p) && this.canBuildAbove2(p) && this.canBuildAbove3(p) && this.canBuildAbove4(p) && this.canBuildDevant1(p) && this.canBuildDevant2(p) && this.canBuildDevant3(p) && this.canBuildDevant4(p) && this.canBuildDevantS1(p) && this.canBuildDevantS2(p) && this.canBuildDevantS3(p) && this.canBuildDevantS4(p) && this.canBuildDerriere1(p) && this.canBuildDerriere2(p) && this.canBuildDerriere3(p) && this.canBuildDerriere4(p) && this.canBuildDerriere1s(p) && this.canBuildDerriere2s(p) && this.canBuildDerriere3s(p) && this.canBuildDerriere4s(p)) {
                if (!fp.isInAllyTerritory() && !fp.isInOthersTerritory() && !fp.isInEnemyTerritory()) {
                    if (fp.isInNeutralTerritory() || fp.isInOwnTerritory()) {
                        if (fb.isWilderness() || fp.isInOwnTerritory()) {
                            Faction fac = Board.getInstance().getFactionAt(new FLocation(loc));
                            if (fac != Factions.getInstance().getByTag("Wilderness") && !fac.getFPlayers().contains(FPlayers.getInstance().getByPlayer(p))) {
                                e.setCancelled(true);
                            } else if (fac == Factions.getInstance().getByTag("Wilderness") || fac.getFPlayers().contains(fp)) {
                                for(int xx = -2; xx <= 2; ++xx) {
                                    for(int zz = -2; zz <= 2; ++zz) {
                                        for(int yy = -2; yy <= 2; ++yy) {
                                            Location l = a.getLocation().add((double)xx, (double)yy, (double)zz);
                                            Faction f2 = Board.getInstance().getFactionAt(new FLocation(l));
                                            if (!f2.isWilderness() && !f2.getFPlayers().contains(FPlayers.getInstance().getByPlayer(p))) {
                                                e.setCancelled(true);
                                                p.sendMessage("§cVous ne pouvez pas casser avec votre Hammer proche du territoire de la faction §f" + f2.getTag() + "§c.");
                                                return;
                                            }

                                            for(int x = loc.getBlockX() - 1; x <= loc.getBlockX() + 1; ++x) {
                                                for(int y = loc.getBlockY() - 1; y <= loc.getBlockY() + 1; ++y) {
                                                    for(int z = loc.getBlockZ() - 1; z <= loc.getBlockZ() + 1; ++z) {
                                                        Block b = loc.getWorld().getBlockAt(x, y, z);
                                                        e.setCancelled(true);
                                                        Iterator var19 = b.getDrops().iterator();

                                                        while(true) {
                                                            while(var19.hasNext()) {
                                                                ItemStack drops = (ItemStack)var19.next();
                                                                if (!drops.getData().getItemType().equals(Material.BEDROCK) && !drops.getData().getItemType().equals(Material.OBSIDIAN)) {
                                                                    b.breakNaturally();
                                                                } else {
                                                                    e.setCancelled(true);
                                                                }
                                                            }

                                                            e.setCancelled(true);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        e.setCancelled(true);
                        p.sendMessage("§cVous ne pouvez pas casser avec votre Hammer à cet endroit.");
                    }
                }
            } else {
                e.setCancelled(true);
                p.sendMessage("§cVous ne pouvez pas casser avec votre Hammer à cet endroit.");
            }
        }

    }

    private WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        return plugin != null && plugin instanceof WorldGuardPlugin ? (WorldGuardPlugin)plugin : null;
    }

    private boolean canBuild(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation());
    }

    private boolean canBuildUnder1(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, -1, 0));
    }

    private boolean canBuildUnder2(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, -2, 0));
    }

    private boolean canBuildUnder3(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, -3, 0));
    }

    private boolean canBuildUnder4(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, -4, 0));
    }

    private boolean canBuildAbove1(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 1, 0));
    }

    private boolean canBuildAbove2(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 2, 0));
    }

    private boolean canBuildAbove3(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 3, 0));
    }

    private boolean canBuildAbove4(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 4, 0));
    }

    private boolean canBuildDevant1(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(1, 0, 0));
    }

    private boolean canBuildDevant2(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(2, 0, 0));
    }

    private boolean canBuildDevant3(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(3, 0, 0));
    }

    private boolean canBuildDevant4(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(4, 0, 0));
    }

    private boolean canBuildDevantS1(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(-1, 0, 0));
    }

    private boolean canBuildDevantS2(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(-2, 0, 0));
    }

    private boolean canBuildDevantS3(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(-3, 0, 0));
    }

    private boolean canBuildDevantS4(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(-4, 0, 0));
    }

    private boolean canBuildDerriere1(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, 1));
    }

    private boolean canBuildDerriere2(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, 2));
    }

    private boolean canBuildDerriere3(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, 3));
    }

    private boolean canBuildDerriere4(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, 4));
    }

    private boolean canBuildDerriere1s(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, -1));
    }

    private boolean canBuildDerriere2s(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, -2));
    }

    private boolean canBuildDerriere3s(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, -3));
    }

    private boolean canBuildDerriere4s(Player player) {
        return this.getWorldGuard().canBuild(player, player.getLocation().getBlock().getRelative(0, 0, -4));
    }
}
