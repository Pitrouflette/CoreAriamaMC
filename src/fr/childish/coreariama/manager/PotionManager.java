package fr.childish.coreariama.manager;

import fr.childish.coreariama.Main;
import fr.childish.coreariama.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PotionManager {

    File filees = new File(Main.instance.getDataFolder(), "config.yml");
    FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

    private final Main main;
    private List<ItemStack> potionsBlocked;

    public PotionManager(Main main) {
        this.main = main;
        this.potionsBlocked = new ArrayList();
        this.load();
    }

    private void load() {
            configaa.getStringList("blocked-potions").forEach((s) -> {
                ItemStack itemStack = (new ItemBuilder(Material.POTION)).setDurability((short)Integer.parseInt(s)).toItemStack();
            this.potionsBlocked.add(itemStack);
        });
    }

    public boolean isBlocked(ItemStack itemStack) {
        Iterator var3 = this.potionsBlocked.iterator();

        while(var3.hasNext()) {
            ItemStack itemStacks = (ItemStack)var3.next();
            if (itemStack.getDurability() == itemStacks.getDurability()) {
                return true;
            }
        }

        return false;
    }

    public List<ItemStack> getPotionsBlocked() {
        return this.potionsBlocked;
    }
}
