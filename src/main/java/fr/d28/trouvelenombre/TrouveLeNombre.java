package fr.d28.trouvelenombre;

import fr.d28.trouvelenombre.commands.CommandTrouveLeNombre;
import fr.d28.trouvelenombre.events.ChatEvent;
import fr.d28.trouvelenombre.events.JoinEvent;
import fr.d28.trouvelenombre.objects.GameTLN;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class TrouveLeNombre extends JavaPlugin {

    public static TrouveLeNombre get;
    private GameTLN gameTLN;



    public GameTLN getGameTLN() {
        return gameTLN;
    }

    @Override
    public void onEnable() {
        get = this;

        gameTLN = new GameTLN();
        //met un message de lancement
        getLogger().info("TrouveLeNombre is now enabled");
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this),this);
        getCommand("trouvelenombre").setExecutor(new CommandTrouveLeNombre(this));

    }

    @Override
    public void onDisable() {
        //met un message de fermeture
        getLogger().info("TrouveLeNombre is now disabled");
    }

}

