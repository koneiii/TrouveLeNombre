package fr.d28.trouvelenombre.objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GameTLN {
    int TLN;
    boolean started = false;

    public void start(Player player){
        if(started){
         player.sendMessage("§cLe jeu est déjà en cours");
         return;
        }
        started = true;
        TLN = (int) (Math.random() * 100);
        Bukkit.broadcastMessage("§e" + player.getName() + " §aa lancé une partie de TrouveLeNombre");
        Bukkit.broadcastMessage("§aTrouvez le nombre entre §e0 §aet §e100");

    }

    public void finish(Player player){
        started = false;
        Bukkit.broadcastMessage("§e" + player.getName() + " §aa trouvé le bon nombre ! Le nombre était bien §e" + TLN);
    }

    public int getTLN() {
        return TLN;
    }

    public void setTLN(int TLN) {
        this.TLN = TLN;
    }

    public boolean isStarted() {
        return started;
    }
}

