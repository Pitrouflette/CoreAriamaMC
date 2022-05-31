package fr.childish.coreariama.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSite implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage("");
        sender.sendMessage("§eAriama§6MC §6» §ehttps://www.ariamamc.fr");
        sender.sendMessage("");
        return true;
    }
}
