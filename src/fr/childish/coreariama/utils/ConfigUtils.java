package fr.childish.coreariama.utils;

import fr.childish.coreariama.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {

    public static void createConfigFile(String name)
    {

        File file = new File(Main.instance.getDataFolder(),name);

        if(!file.exists()){
            try{
                file.createNewFile();
                return;
            }catch (IOException e){
                for(int i = 0; i < 5; i++){
                    System.out.println("KataCore -- Le fichier "+name+" n'a pas pu  tre g n r  ! ( "+e+" )");
                }
            }
        }else return;
    }

    public static boolean saveConfigFile(File folder, String name)
    {
        File file = new File(folder,name);
        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

        if(file.exists()){
            try{
                config.save(file);
                return true;
            }catch (IOException e){
                e.printStackTrace();
                return false;

            }
        }else return false;
    }

    public static boolean configFileExist(File folder, String name){
        File file = new File(folder,name);
        if(file.exists()){
            return true;
        }else return false;
    }
}