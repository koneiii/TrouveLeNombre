package fr.d28.trouvelenombre.events;

import fr.d28.trouvelenombre.TrouveLeNombre;
import fr.d28.trouvelenombre.api.events.WinGameTLNEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;



public class ChatEvent implements Listener {
    private final TrouveLeNombre trouveLeNombre;

    public ChatEvent(TrouveLeNombre trouveLeNombre){
        this.trouveLeNombre = trouveLeNombre;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(trouveLeNombre.getGameTLN().isStarted()){
            Player player = event.getPlayer();
            String message = event.getMessage();
            int nombre;
            try {
                nombre = Integer.parseInt(message);
            }catch (Exception ignored){
                return;
            }
            if(nombre == trouveLeNombre.getGameTLN().getTLN()){
                WinGameTLNEvent winGameTLNEvent = new WinGameTLNEvent(player);
                Bukkit.getPluginManager().callEvent(winGameTLNEvent);
                if(!winGameTLNEvent.isCancelled()){
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    player.sendMessage("§aVous avez trouvé le nombre !");
                    trouveLeNombre.getGameTLN().finish(player);
                }
            }

            if(nombre < trouveLeNombre.getGameTLN().getTLN()){
                player.sendMessage("§cCe nombre est trop petit !");
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.VILLAGER_NO, 1, 1);
            }

            if(nombre > trouveLeNombre.getGameTLN().getTLN()){
                player.sendMessage("§cCe nombre est trop grand !");
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.VILLAGER_HAGGLE, 1, 1);
            }


        }
    }

}
