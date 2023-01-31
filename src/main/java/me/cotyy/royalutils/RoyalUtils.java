package me.cotyy.royalutils;

import com.earth2me.essentials.IEssentials;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoyalUtils extends JavaPlugin {
    private IEssentials essentials;
    private static RoyalUtils instance;


    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new GodModeCancel(instance), this);

        this.essentials = (IEssentials) this.getServer().getPluginManager().getPlugin("Essentials");
    }

    @Override
    public void onDisable() {
    }

    public IEssentials getEssentials(){
        return essentials;
    }

    public RoyalUtils getInstance(){
        return instance;
    }
}
