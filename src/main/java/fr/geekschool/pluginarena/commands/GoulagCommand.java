package fr.geekschool.pluginarena.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class GoulagCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (args.length !=1) {

                player.sendMessage("§c[§bGoulag§c] §2Vous devez indiqué le nom d'un joueur");
            }else {

                player.chat("/tp " + args[0] + " 1521 76 6867");
            }

        }else{
            Logger.getLogger("PluginArena").warning("Vous devez etre un joueur pour utiliser cette command");
        }
        return true;
    }


}
