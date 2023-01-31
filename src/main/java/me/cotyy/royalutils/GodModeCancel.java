package me.cotyy.royalutils;


import com.earth2me.essentials.IEssentials;
import net.ess3.api.IUser;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GodModeCancel implements Listener{
    private final RoyalUtils ru;

    public GodModeCancel(RoyalUtils ru){
        this.ru = ru;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();
        if(damaged instanceof ArmorStand || damaged instanceof ItemFrame){
            return;
        }

        if(damager instanceof Player){
            Player player = (Player) damager;
            if(player.hasPermission("royalutils.godbypass")){
                return;
            }
            IEssentials essentials = ru.getEssentials();
            IUser essPlayer = essentials.getUser(player);

            if(essPlayer.isGodModeEnabled()){
                event.setCancelled(true);
                player.sendMessage("[lang]Essentials.Godmode.Mob-Damage[/lang]");
            }
        }

        if(damager instanceof Projectile){
            Projectile projectile = (Projectile) event.getDamager();
            if(projectile.getShooter() instanceof Player){
                Player player = (Player) projectile.getShooter();
                IEssentials essentials = ru.getEssentials();
                IUser essPlayer = essentials.getUser(player);

                if(essPlayer.isGodModeEnabled()){
                    event.setCancelled(true);
                    player.sendMessage("[lang]Essentials.Godmode.Mob-Damage[/lang]");

                }
            }

        }

    }


}
