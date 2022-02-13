package fr.geekschool.pluginarena;

import fr.geekschool.pluginarena.backpack.BackpackManager;
import fr.geekschool.pluginarena.commands.*;
import fr.geekschool.pluginarena.listeners.*;
import fr.geekschool.pluginarena.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Config config;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }

    @Override
    public void onEnable() {


        fr.geekschool.pluginarena.cooldown.CooldonwManager.setupCooldown();

        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus]§b-------------------------------------------------------------------");
        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus] §6Le plugin PluginOdysseyus fait par Pitrouflette a été initialisé");
        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus]§b-------------------------------------------------------------------");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new MobSpawn(), this);
        manager.registerEvents(new ExplosionListeners(), this);
        manager.registerEvents(new BeenListener(), this);
        manager.registerEvents(new HotteListner(), this);
        manager.registerEvents(new AromorEffectCloseInvListener(), this);
        manager.registerEvents(new PetSpawnedListener(), this);
        manager.registerEvents(new InteractCadeauInvListener(), this);
        manager.registerEvents(new InteractCarteInvListener(), this);
        manager.registerEvents(new onFindGift(), this);
        manager.registerEvents(new godSwordListener(), this);
        //manager.registerEvents(new onDethEvent(), this);
        manager.registerEvents(new onCustomCraft(), this);
        manager.registerEvents(new onBreakBlock(), this);
        manager.registerEvents(new onUsePitrouTools(), this);
        manager.registerEvents(new onClickCustomCraftInv(), this);
        manager.registerEvents(new onRightClickPresse(), this);
        //
        getCommand("hotte").setExecutor(new BackpackCommand());
        getCommand("cadeau").setExecutor(new CadeauCommand());
        getCommand("item-admin").setExecutor(new ItemAdminCommand());
        getCommand("gift").setExecutor(new GiftCommand());
        getCommand("tete").setExecutor(new HeadCommand());
        getCommand("clear-hand").setExecutor(new ClearHandCommand());
        getCommand("poubelle").setExecutor(new BeenCommand());
        getCommand("goulag").setExecutor(new GoulagCommand());
        getCommand("pet").setExecutor(new PetCommand());
        getCommand("event").setExecutor(new onFindGift());
        getCommand("sword").setExecutor(new SwordCommand());
        getCommand("frag").setExecutor(new FragCommand());
        //getCommand("custom-craft").setExecutor(new CustomCraftCommand());
        getCommand("presse").setExecutor(new PresseCommand());
        //getCommand("odysseyus").setExecutor(new OdysseyusHelpCommand());
        //getCommand("vote").setExecutor(new VoteCommand());
        getCommand("crypto").setExecutor(new CryptoCommand());
        //
        backpackManager = new BackpackManager();

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus]§b-------------------------------------------------------------------");
        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus] §6Le plugin PluginOdysseyus fait par Pitrouflette a été éteint");
        getServer().getConsoleSender().sendMessage("§1[PluginOdysseyus]§b-------------------------------------------------------------------");
        backpackManager.save();
        config.save();
    }
}
