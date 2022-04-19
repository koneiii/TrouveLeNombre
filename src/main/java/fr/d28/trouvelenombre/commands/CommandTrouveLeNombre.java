package fr.d28.trouvelenombre.commands;

import fr.d28.trouvelenombre.TrouveLeNombre;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandTrouveLeNombre implements CommandExecutor {

    TrouveLeNombre trouveLeNombre;
    public CommandTrouveLeNombre(TrouveLeNombre trouveLeNombre){
        this.trouveLeNombre = trouveLeNombre;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(cmd.getName().equalsIgnoreCase("TrouveLeNombre")){

            if(sender instanceof Player){
                Player player = (Player) sender;

                if(!player.hasPermission("trouvelenombre.start")){
                    player.sendMessage("Tu n'as pas la perm connard !");
                    return false;
                }

                trouveLeNombre.getGameTLN().start(player);


            }
        }
        return true;
    }

}
