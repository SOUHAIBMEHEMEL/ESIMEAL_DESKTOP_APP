package Classes;

import java.time.LocalDateTime;
import java.util.*;

public class cmd_domicile extends commande {
    public String adresse;
    public int distance;
	public cmd_domicile(client cl, int nbr_personne, LocalDateTime heure_cons, String adresse, int distance) {
		super(cl,nbr_personne, heure_cons);
		this.adresse=adresse;
		this.distance=distance;
	}
	public Boolean getDistance(){return true;}

}
