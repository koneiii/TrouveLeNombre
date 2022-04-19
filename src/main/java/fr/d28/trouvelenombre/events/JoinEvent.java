package fr.d28.trouvelenombre.events;

import fr.d28.trouvelenombre.api.events.WinGameTLNEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("§7Bienvenue §e" + player.getName() + " §7sur le serveur x)");
        System.out.println(player.getName() + "a rejoint le serveur. Son uuid: " + player.getUniqueId());
    }

}
