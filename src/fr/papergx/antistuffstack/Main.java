package fr.papergx.antistuffstack;

import fr.papergx.antistuffstack.cmd.CommandManager;
import fr.papergx.antistuffstack.listeners.Listeners;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        List<Material> stuff = new ArrayList<>();
        stuff.add(Material.DIAMOND_HELMET);
        stuff.add(Material.DIAMOND_CHESTPLATE);
        stuff.add(Material.DIAMOND_LEGGINGS);
        stuff.add(Material.DIAMOND_BOOTS);
        getServer().getPluginManager().registerEvents(new Listeners(stuff), this);
        getCommand("stuff").setExecutor(new CommandManager());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
