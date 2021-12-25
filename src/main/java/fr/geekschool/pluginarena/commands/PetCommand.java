package fr.geekschool.pluginarena.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Logger;


public class PetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            //Item QUIT
            ItemStack Quitter = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta quitMeta = Quitter.getItemMeta();
            quitMeta.setDisplayName("§bPoubelle");
            Quitter.setItemMeta(quitMeta);

            //Item PigPet
            ItemStack DragPet = new ItemStack(Material.PIG_SPAWN_EGG);
            ItemMeta DragPetMeta = DragPet.getItemMeta();
            DragPetMeta.setDisplayName("§bPig");
            DragPet.setItemMeta(DragPetMeta);

            //Item WolfPet
            ItemStack WolfPet = new ItemStack(Material.WOLF_SPAWN_EGG);
            ItemMeta WolfPetMeta = WolfPet.getItemMeta();
            WolfPetMeta.setDisplayName("§bWolf");
            WolfPet.setItemMeta(WolfPetMeta);

            //Item CatPet
            ItemStack CatPet = new ItemStack(Material.CAT_SPAWN_EGG);
            ItemMeta CatPetMeta = CatPet.getItemMeta();
            CatPetMeta.setDisplayName("§bCat");
            CatPet.setItemMeta(CatPetMeta);

            //Item FoxPet
            ItemStack FoxPet = new ItemStack(Material.FOX_SPAWN_EGG);
            ItemMeta FoxPetMeta = FoxPet.getItemMeta();
            FoxPetMeta.setDisplayName("§bFox");
            FoxPet.setItemMeta(FoxPetMeta);

            //Item PandaPet
            ItemStack PandaPet = new ItemStack(Material.PANDA_SPAWN_EGG);
            ItemMeta PandaPetMeta = PandaPet.getItemMeta();
            PandaPetMeta.setDisplayName("§bPanda");
            PandaPet.setItemMeta(PandaPetMeta);

            Inventory invPet = Bukkit.createInventory(null, 27, "               §bPets");

            invPet.setItem(0, Quitter);
            invPet.setItem(1, Quitter);
            invPet.setItem(2, Quitter);
            invPet.setItem(3, Quitter);
            invPet.setItem(4, Quitter);
            invPet.setItem(5, Quitter);
            invPet.setItem(6, Quitter);
            invPet.setItem(7, Quitter);
            invPet.setItem(8, Quitter);
            invPet.setItem(9, Quitter);
            invPet.setItem(10, DragPet);
            invPet.setItem(11, WolfPet);
            invPet.setItem(12, CatPet);
            invPet.setItem(12, CatPet);
            invPet.setItem(13, FoxPet);
            invPet.setItem(14, PandaPet);
            invPet.setItem(17, Quitter);
            invPet.setItem(18, Quitter);
            invPet.setItem(19, Quitter);
            invPet.setItem(20, Quitter);
            invPet.setItem(21, Quitter);
            invPet.setItem(22, Quitter);
            invPet.setItem(23, Quitter);
            invPet.setItem(24, Quitter);
            invPet.setItem(25, Quitter);
            invPet.setItem(26, Quitter);

            player.openInventory(invPet);
        }else{
            Logger.getLogger("PluginArena").warning("Vous devez etre un joueur pour utiliser cette command");
        }
        return false;
    }

}
